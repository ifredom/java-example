package com.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import com.springboot.domain.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional

// @Transactional注解 内含 @Rollback(true)自动回滚
//@Rollback(false)
public class IStudentServiceTest {
    @Autowired
    private IStudentService studentService;

    @Test
    public void select() {
        System.out.println(studentService.getById(1));
    }

    // 自增ID 需要设置数据库
    @Test
    public void save() {
        StudentEntity student = new StudentEntity();
        student.setName("tomma3");
        student.setAge(66);
        studentService.save(student);
    }

    @Test
    public void update() {
        StudentEntity student = new StudentEntity();
        student.setId(26);
        student.setName("tomma");
        student.setAge(888);
        studentService.updateById(student);
    }

    @Test
    public void selectAll() {
        studentService.list();
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        Page<StudentEntity> page = new Page<>(2, 5);
        studentService.page(page);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
    }

}
