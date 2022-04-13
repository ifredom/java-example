package com.springboot.domain.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 使用编辑器中的lombok插件
@Data
@NoArgsConstructor
@TableName("ta_student")
public class StudentEntity implements Serializable {

    @TableId
    private Integer id;
    private String name;
    private int age;
}
