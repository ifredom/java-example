package com.springboot.domain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.dao.StudentDao;
import com.springboot.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Boolean save(StudentEntity student) {
        return studentDao.insert(student) > 0;
    }

    @Override
    public Boolean update(StudentEntity student) {
        return studentDao.updateById(student) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return studentDao.deleteById(id) > 0;
    }

    @Override
    public StudentEntity getById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentDao.selectList(null);
    }

    @Override
    public IPage<StudentEntity> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return studentDao.selectPage(page, null);
    }
}
