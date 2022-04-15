package com.springboot.domain.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobDao extends BaseMapper<JobEntity> {
}
