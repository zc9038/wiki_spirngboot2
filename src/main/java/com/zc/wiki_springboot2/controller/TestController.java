package com.zc.wiki_springboot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){ return "hello"; }
}
