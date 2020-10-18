package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service//service需要被容器扫描到，所以需要加这个注解
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)//查询只用support就可以
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStuInfo() {

        Stu stu = new Stu();
        stu.setName("jack");
        stu.setAge(19);
        stuMapper.insert(stu);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStuInfo(int id) {

        Stu stu = new Stu();
        stu.setId(id);
        stu.setName("lucy");
        stu.setAge(20);
        stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStuInfo(int id) {
        stuMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("parent");
        stu.setAge(40);
        stuMapper.insert(stu);

    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void saveChildren() {
        saveChild1();
        int a = 1 / 0;
        saveChild2();
    }

    @Override
    public void saveChild1() {
        Stu stu = new Stu();
        stu.setName("c1");
        stu.setAge(11);
        stuMapper.insert(stu);
    }

    @Override
    public void saveChild2() {
        Stu stu = new Stu();
        stu.setName("c2");
        stu.setAge(11);
        stuMapper.insert(stu);
    }
}
