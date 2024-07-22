package com.zc.wiki_springboot2.controller;

import com.zc.wiki_springboot2.domain.Demo;
import com.zc.wiki_springboot2.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    DemoService demoService;

    @GetMapping("/list")
    public List<Demo> demoList(){
        return demoService.selectByExample();
    }
}
