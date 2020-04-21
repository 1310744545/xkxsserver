package org.xkx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.ArticleMapper;
import org.xkx.pojo.article;

import java.util.List;

@Service
public class ArticleImpl implements IArticleService {
    @Autowired
    ArticleMapper articleMapper;


    @Override
    public int selectMax() {
        return articleMapper.selectMax();
    }

    @Override
    public void addArticle(article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public List<article> selectArticle(int uid) {
        return articleMapper.selectArticle(uid);
    }


}
