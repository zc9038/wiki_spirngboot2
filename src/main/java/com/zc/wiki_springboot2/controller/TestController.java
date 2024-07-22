package com.zc.wiki_springboot2.controller;

import com.zc.wiki_springboot2.domain.Test;
import com.zc.wiki_springboot2.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping("/hello")
    public String hello(){ return "hello"; }

    @GetMapping("/test/list")
    public List<Test> testList(){
        return testService.selectAll();
    }
}
