package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class StuDemoController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStu")
    public Object getStu(int id){

        return stuService.getStuInfo(id);
    }

    // 这个接口不具有幂等性 调用多次 会保存多条记录
    @PostMapping("/saveStu")
    public Object saveStu(){
        stuService.saveStuInfo();
        return "OK";
    }

    // 更新和删除是有幂等性的
    @PostMapping("/updateStu")
    public Object updateStu(int id){
        stuService.updateStuInfo(id);
        return "OK";
    }

    @PostMapping("/deleteStu")
    public Object deleteStu(int id){
        stuService.deleteStuInfo(id);
        return "OK";
    }

}
