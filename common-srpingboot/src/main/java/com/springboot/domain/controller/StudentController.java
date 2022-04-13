package com.springboot.domain.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.common.utils.R;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private IStudentService iStudentService;

    @GetMapping
    public R getAll() {
        return R.ok(iStudentService.list());
    }


    @PostMapping
    public R save(@RequestBody StudentEntity studentEntity) throws IOException {

        if (true) throw new IOException();
        iStudentService.selfDefineFun1(studentEntity);
        return R.ok();
    }

    @PutMapping
    public R update(@RequestBody StudentEntity studentEntity) {
        iStudentService.updateById(studentEntity);
        return R.ok();
    }
    // http://localhost/students/2
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {

        boolean result = iStudentService.selfDefineFun2(id);
        return result ? R.ok() : R.error("删除失败");
    }

    // http://localhost/students/2
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {

        iStudentService.getById(id);
        return R.ok();
    }

    // http://localhost/students/2/10
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, StudentEntity student) {
        System.out.println("============" + student);
        IPage<StudentEntity> page = iStudentService.getPage(currentPage, pageSize, student);
        return R.ok(page.getRecords());
    }
}
