package com.springboot.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

// 使用编辑器中的lombok插件
@Data
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private int age;
}
