package com.springboot.domain.controller;

import com.springboot.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public String getJob(){
        System.out.println("响应定时器");

        jobService.addTask();
        return "定时器";
    }
}
