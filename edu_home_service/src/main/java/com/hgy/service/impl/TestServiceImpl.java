package com.hgy.service.impl;

import com.hgy.dao.TestMapper;
import com.hgy.entity.Test;
import com.hgy.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    @Qualifier("testMapper")
    private TestMapper mapper;

    @Override
    public List<Test> findAll() {
        return mapper.findAll();
    }
}
