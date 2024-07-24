package com.zc.wiki_springboot2.service;

import com.zc.wiki_springboot2.domain.Ebook;
import com.zc.wiki_springboot2.domain.EbookExample;
import com.zc.wiki_springboot2.mapper.EbookMapper;
import com.zc.wiki_springboot2.req.EbookReq;
import com.zc.wiki_springboot2.resp.EbookResp;
import com.zc.wiki_springboot2.utils.CopyUtil;
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

    public List<Ebook> selectByName(String name) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return ebookMapper.selectByExample(ebookExample);
    }

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

/*        List<EbookResp> respList = new ArrayList<EbookResp>();
        for (Ebook ebook : ebookList) {
            EbookResp resp = new EbookResp();
            BeanUtils.copyProperties(ebook, resp);
            respList.add(resp);
        }*/
        return CopyUtil.copyList(ebookList, EbookResp.class);
    }

}
