package com.imooc.service;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;

public interface StuService {


    Stu getStuInfo(int id);

    void saveStuInfo();

    void updateStuInfo(int id);

    void deleteStuInfo(int id);

    void saveParent();

    void saveChildren();

    void saveChild1();

    void saveChild2();




}
