package com.zc.wiki_springboot2.controller;

import com.zc.wiki_springboot2.domain.Ebook;
import com.zc.wiki_springboot2.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    EbookService ebookService;

    @GetMapping("/list")
    public List<Ebook> ebookList(){
        return ebookService.selectByExample();
    }
}
