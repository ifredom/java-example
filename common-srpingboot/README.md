# 工程内含写法

- Mybatis 配置-日志-拦截器


## Dao数据层书写

第一步定义 Entity
```java
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

```

第二步定义 Dao

```java
package com.springboot.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
}
```
## Service业务层书写

定义 Service:
固定写法： interface XXX extends IService<实体类Entity>

```java
package com.springboot.domain.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.domain.entity.StudentEntity;

public interface IStudentService extends IService<StudentEntity> {
}

```


实现ServiceImpl: 
固定写法， XXX 继承 ServiceImpl<Dao类，Entity实体类> implements  IStudentService 自定义接口

```java
package com.springboot.domain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.domain.dao.StudentDao;
import com.springboot.domain.entity.StudentEntity;
import com.springboot.domain.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    // 其他业务
    public boolean otherService(StudentEntity student) {
        // do other something
        return false;
    }
}

```
## Controller 表现层 书写

- @RestController 
  - 相当于 @Controller + @ResponseBody 两个注解的结合，
  - 返回json数据不需要在方法前面加@ResponseBody注解
  - 一旦使用 @RestController 这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面


- @RequestMapping("/students") 定义接口访问地址
  - 根据类型  @GetMapping 查询
  - 根据类型  @PostMapping 新增
  - 根据类型  @PutMapping 更新
  - 根据类型  @DeleteMapping 删除


### 
[spring yml配置文件](https://www.bilibili.com/video/BV15b4y1a7yG?p=60)
- 配置文件一共四级，默认固定名称application.yml
- springboot环境优先级低于 maven中的 profiles 环境变量