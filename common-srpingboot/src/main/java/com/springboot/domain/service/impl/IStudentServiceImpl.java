package com.springboot.domain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.dao.StudentDao;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean selfDefineFun1(StudentEntity student) {
        return studentDao.insert(student) > 0;
    }

    @Override
    public boolean selfDefineFun2(Integer id) {
        return studentDao.deleteById(id) > 0;
    }

    @Override
    public IPage<StudentEntity> getPage(int currentPage, int pageSize) {
        Page<StudentEntity> page = new Page<>(currentPage, pageSize);
        return studentDao.selectPage(page, null);
    }

    public StudentEntity getById(Integer id) {
        return studentDao.selectById(id);
    }

}
