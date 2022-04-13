package com.springboot.domain.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.domain.entity.StudentEntity;

public interface IStudentService extends IService<StudentEntity> {

    // 写一些其他业务，方法名要避开Iservice中的方法
    // 自定义一些额外方法
    boolean selfDefineFun1(StudentEntity student);

    boolean selfDefineFun2(Integer id);

    IPage<StudentEntity> getPage(int currentPage, int pageSize);
    IPage<StudentEntity> getPage(int currentPage, int pageSize, StudentEntity student);

}
