package com.springboot.common.utils;

import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务
 * 具体任务
 */
public class QuartzJob extends QuartzJobBean {


    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("要执行的任务体");
    }
}
