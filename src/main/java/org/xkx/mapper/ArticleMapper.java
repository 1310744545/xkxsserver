package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.article;

import java.util.List;

@Mapper//表示本类是mybatis的mapper
@Repository//表示这是Dao层
public interface ArticleMapper {
    Integer selectMax();

    void addArticle(article article);

    List<article> selectArticle(int uid);
}
