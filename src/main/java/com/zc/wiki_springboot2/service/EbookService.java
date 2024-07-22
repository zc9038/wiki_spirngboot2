package com.zc.wiki_springboot2.service;

import com.zc.wiki_springboot2.domain.Ebook;
import com.zc.wiki_springboot2.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> selectByExample() {
        return ebookMapper.selectByExample(null);
    }
}
