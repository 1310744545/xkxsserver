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

    @Override
    public article selectArticleDetail(int aid) {
        return articleMapper.selectArticleDetail(aid);
    }

    @Override
    public void articleReadPlus(int aid) {
        articleMapper.articleReadPlus(aid);
    }

    @Override
    public void praise(int aid) {
        articleMapper.praise(aid);
    }

    @Override
    public void comment(int aid) {
        articleMapper.comment(aid);
    }

    @Override
    public List<article> selectAllArticle() {
       return articleMapper.selectAllArticle();
    }

    @Override
    public List<article> selectArticleAndGodByUid(int uid) {
        return articleMapper.selectArticleAndGodByUid(uid);
    }

    @Override
    public void deleteArticle(int aid) {
        articleMapper.deleteArticle(aid);
    }

    @Override
    public article selectArticleByAid(int aid) {
        return articleMapper.selectArticleDetail(aid);
    }

    @Override
    public void updateArticle(article article) {
        articleMapper.updateArticle(article);
    }
}
