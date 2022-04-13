package com.springboot.domain.controller;


import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private IStudentService iStudentService;

    @GetMapping
    public List<StudentEntity> getAll() {
        return iStudentService.list();
    }


    @PostMapping
    public Boolean save(@RequestBody StudentEntity studentEntity) {
        return iStudentService.selfDefineFun1(studentEntity);
    }

    @PutMapping
    public Boolean update(@RequestBody StudentEntity studentEntity) {
        return iStudentService.updateById(studentEntity);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return iStudentService.selfDefineFun2(id);
    }

    // http://localhost/book/2
    @GetMapping("{id}")
    public StudentEntity getById(@PathVariable Integer id) {
        return iStudentService.getById(id);
    }
}
