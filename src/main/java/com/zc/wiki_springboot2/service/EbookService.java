package com.zc.wiki_springboot2.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.wiki_springboot2.domain.Ebook;
import com.zc.wiki_springboot2.domain.EbookExample;
import com.zc.wiki_springboot2.mapper.EbookMapper;
import com.zc.wiki_springboot2.req.EbookReq;
import com.zc.wiki_springboot2.resp.EbookResp;
import com.zc.wiki_springboot2.resp.PageResp;
import com.zc.wiki_springboot2.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> selectByExample() {
        return ebookMapper.selectByExample(null);
    }

    public List<Ebook> selectByName(String name) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return ebookMapper.selectByExample(ebookExample);
    }

    public PageResp<EbookResp> listByReq(EbookReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%" + req.getName() + "%");
        }
//        PageHelper.startPage(1,3);
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<EbookResp> ebookResp =  CopyUtil.copyList(ebookList, EbookResp.class);

        return new PageResp<>(pageInfo.getTotal(), ebookResp);
    }

}
