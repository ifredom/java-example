package com.springboot.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.domain.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    Boolean save(StudentEntity student);
    Boolean update(StudentEntity student);
    Boolean delete(Integer id);
    StudentEntity getById(Integer id);
    List<StudentEntity> getAll();
    IPage<StudentEntity> getPage(int currentPage, int pageSize);
}
