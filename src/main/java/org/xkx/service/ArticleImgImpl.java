package org.xkx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.ArticleImgMapper;
import org.xkx.pojo.articleImg;

import java.util.List;

@Service
public class ArticleImgImpl implements IArticleImgServer {
    @Autowired
    ArticleImgMapper articleImgMapper;

    @Override
    public void addImg(articleImg articleImg) {
        articleImgMapper.addImg(articleImg);
    }

    @Override
    public List<String> selectImgByAid(int aid) {
        return articleImgMapper.selectImgByAid(aid);
    }

    @Override
    public void deleteUrl(String url) {
        articleImgMapper.deleteUrl(url);
    }
}
