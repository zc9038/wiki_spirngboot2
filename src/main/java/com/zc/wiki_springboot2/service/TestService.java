package com.zc.wiki_springboot2.service;

import com.zc.wiki_springboot2.domain.Test;
import com.zc.wiki_springboot2.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public List<Test> selectAll() {
        return testMapper.list();
    }
}
