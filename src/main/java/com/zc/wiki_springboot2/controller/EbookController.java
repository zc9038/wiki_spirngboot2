package com.zc.wiki_springboot2.controller;

import com.zc.wiki_springboot2.domain.Ebook;
import com.zc.wiki_springboot2.req.EbookReq;
import com.zc.wiki_springboot2.resp.CommonResp;
import com.zc.wiki_springboot2.resp.EbookResp;
import com.zc.wiki_springboot2.resp.PageResp;
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

/*    @GetMapping("/list")
    public CommonResp selectByExample(){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> ebookList = ebookService.selectByExample();
        resp.setContent(ebookList);
        return resp;
    }*/

    @GetMapping("/listByName")
    public CommonResp selectByName(String name){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> ebookList = ebookService.selectByName(name);
        resp.setContent(ebookList);
        return resp;
    }

    @GetMapping("/list")
    public CommonResp listByReq(EbookReq req){
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> pageResp = ebookService.listByReq(req);
        resp.setContent(pageResp);
        return resp;
    }
}
