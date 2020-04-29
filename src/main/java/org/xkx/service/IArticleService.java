package org.xkx.service;

import org.xkx.pojo.article;

import java.util.List;

public interface IArticleService {

    int selectMax();

    void addArticle(article article);

    List<article> selectArticle(int uid);

    article selectArticleDetail(int aid);

    void articleReadPlus(int aid);

    void praise(int aid);

    void comment(int aid);

    List<article> selectAllArticle();

    List<article> selectArticleAndGodByUid(int uid);

    void deleteArticle(int aid);

    article selectArticleByAid(int aid);

    void updateArticle(article article);
}
