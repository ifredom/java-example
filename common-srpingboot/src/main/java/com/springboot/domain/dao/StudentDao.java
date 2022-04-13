package com.springboot.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDao extends BaseMapper<Student> {

}
