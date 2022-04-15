package com.springboot.config;

import com.springboot.common.utils.QuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    // 工作详情
    // storeDurably持久化

    @Bean
    public JobDetail printJobDetail() {
        // 绑定具体工作
        return JobBuilder.newJob(QuartzJob.class).storeDurably().build();
    }

    // 触发器
    @Bean
    public Trigger triggerPrintJob() {
        ScheduleBuilder<? extends Trigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }
}
