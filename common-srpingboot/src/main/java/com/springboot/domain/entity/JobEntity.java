package com.springboot.domain.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@TableName("ta_job")
public class JobEntity implements Serializable {

    @TableId
    private Integer id;
    private String taskId;
    private Date createTime;
}