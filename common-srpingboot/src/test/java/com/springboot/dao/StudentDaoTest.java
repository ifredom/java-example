package com.springboot.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.dao.StudentDao;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTest {


    @Autowired
    private StudentDao studentDao;

    @Test
    public void select() {
        System.out.println(studentDao.selectById(1));
    }

    // 自增ID 需要设置数据库
    @Test
    public void save() {
        StudentEntity student = new StudentEntity();

        for (int i = 0; i < 20; i++) {
            student.setName("jenny" + i);
            student.setAge(30 + i);
            studentDao.insert(student);
        }

    }

    @Test
    public void update() {
        studentDao.deleteById(2);
    }

    @Test
    public void selectAll() {
        studentDao.selectList(null);
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        Page page = new Page(2, 5);
        Page page1 = studentDao.selectPage(page, null);

        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
    }

    // 普通查询
    @Test
    public void select1() {
        QueryWrapper qw = new QueryWrapper();
        qw.like("name", "Spring");
        studentDao.selectList(qw);
    }

    // 准确的 查询
    @Test
    public void select2() {
        String name = "3";
        LambdaQueryWrapper<StudentEntity> qw = new LambdaQueryWrapper<StudentEntity>();

        qw.like(Strings.isNotEmpty(null), StudentEntity::getName, name);
        studentDao.selectList(qw);
    }


}
