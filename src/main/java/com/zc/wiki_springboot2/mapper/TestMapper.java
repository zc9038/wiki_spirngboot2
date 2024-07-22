package com.zc.wiki_springboot2.mapper;

import com.zc.wiki_springboot2.domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<Test> list();
}
