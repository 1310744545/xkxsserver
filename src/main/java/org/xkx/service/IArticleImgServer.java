package org.xkx.service;

import org.xkx.pojo.articleImg;

import java.util.List;

public interface IArticleImgServer {

    void addImg(articleImg articleImg);

    List<String> selectImgByAid(int aid);

    void deleteUrl(String url);
}
