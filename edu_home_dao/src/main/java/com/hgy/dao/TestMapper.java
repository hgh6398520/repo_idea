package com.hgy.dao;

import com.hgy.entity.Test;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {
    @Select("SELECT * FROM test")
    public List<Test> findAll();
}
