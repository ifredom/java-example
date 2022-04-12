package com.mybatis.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookDao {

    @Select("select * from student where name = #{name}")
    public Book getByName(String name);

}
