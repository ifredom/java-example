package com.springboot.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.domain.entity.JobEntity;
import org.springframework.stereotype.Service;


public interface JobService extends IService<JobEntity> {

    void addTask();
}
