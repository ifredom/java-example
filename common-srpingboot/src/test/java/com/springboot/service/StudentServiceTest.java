package com.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void select() {
        System.out.println(studentService.getById(1));
    }

    // 自增ID 需要设置数据库
    @Test
    public void save() {
        StudentEntity student = new StudentEntity();
        student.setName("tomma");
        student.setAge(22);
        studentService.save(student);
    }

    @Test
    public void update() {
        StudentEntity student = new StudentEntity();
        student.setId(26);
        student.setName("tomma");
        student.setAge(999);
        studentService.update(student);
    }

    @Test
    public void selectAll() {
        studentService.getAll();
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {

        IPage<StudentEntity> page = studentService.getPage(2, 5);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
    }

}
