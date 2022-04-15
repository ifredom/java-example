package com.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.domain.dao.StudentDao;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void select() {
        System.out.println(studentService.getById(1));
    }

    // 自增ID 需要设置数据库
    @Test
    public void save() {
        // 当Entity使用 @Builer注解时
//        StudentEntity student = StudentEntity.builder().name("小华").age(87).build();
        StudentEntity student = new StudentEntity();
        student.setName("tableFiele");
        student.setAge(65);
        studentService.save(student);
    }

    @Test
    public void update() {
//        StudentEntity student = new StudentEntity();
//        student.setId(26);
//        student.setName("tomma");
//        student.setAge(999);
//        studentService.update(student);
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
