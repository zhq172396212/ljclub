package com.xt.dao;

import com.xt.pojo.Blog;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bId);

    @Select("select * from blog")
    @ResultMap("BaseResultMap")
    List<Blog> selAll();

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}