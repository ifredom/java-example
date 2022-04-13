package com.springboot.common.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler
    public R doException(Exception ex){
        // 记录日志
        // 通知运维
        // 返回给前端
        ex.printStackTrace();
        return R.error(-1,"服务器故障，稍后在尝试");
    }
}
