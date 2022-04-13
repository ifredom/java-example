package com.springboot.domain.service.impl;

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

    // 其他业务
    public boolean otherService(StudentEntity student) {
        // do other something
        return false;
    }
}
