package com.springboot.domain.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

// 使用编辑器中的lombok插件
@Data
@TableName("ta_student")
public class StudentEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    @TableField(condition = "%s &gt; #{%s}")
    private int age;

    // 用来标识该字段：当为空时，自动填充。要求实现填充器

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 仅仅作为数据存储，不对应数据表中的字段
    @TableField(exist = false)
    private Boolean updateTime;
}
