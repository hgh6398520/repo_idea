package com.hgy.controller;

import com.hgy.entity.Test;
import com.hgy.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    @Qualifier("testService")
    private TestService service;

    @RequestMapping("/findAll")
    @ResponseBody()
    public List<Test> findAll(){
        return service.findAll();
    }

}
