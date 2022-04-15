package com.springboot.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.dao.JobDao;
import com.springboot.domain.entity.JobEntity;
import com.springboot.domain.service.JobService;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class JobServiceImpl extends ServiceImpl<JobDao, JobEntity> implements JobService {

//    @Autowired
//    private JobDao jobDao;

    @Override
    public void addTask() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("2秒打印");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
