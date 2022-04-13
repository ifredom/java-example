package com.springboot.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
