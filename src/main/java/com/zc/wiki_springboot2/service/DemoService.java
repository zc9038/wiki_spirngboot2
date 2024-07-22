package com.zc.wiki_springboot2.service;

import com.zc.wiki_springboot2.domain.Demo;
import com.zc.wiki_springboot2.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {
    @Resource
    private DemoMapper demoMapper;

    public List<Demo> selectByExample() {
        return demoMapper.selectByExample(null);
    }
}
