package com.springboot.domain.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.common.utils.R;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Map<String, Object> map = new HashMap<>();
        map.put("data", iStudentService.list());
        return R.ok(map);
    }


    @PostMapping
    public R save(@RequestBody StudentEntity studentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", iStudentService.selfDefineFun1(studentEntity));
        return R.ok(map);
    }

    @PutMapping
    public R update(@RequestBody StudentEntity studentEntity) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", iStudentService.updateById(studentEntity));
        return R.ok(map);
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", iStudentService.selfDefineFun2(id));
        return R.ok(map);
    }

    // http://localhost/book/2
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", iStudentService.getById(id));
        return R.ok(map);
    }

    // http://localhost/book/2
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", iStudentService.getPage(currentPage, pageSize));
        return R.ok(map);
    }
}
