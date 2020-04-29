package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.articleImg;

import java.util.List;

@Mapper
@Repository
public interface ArticleImgMapper {
    void addImg(articleImg articleImg);

    List<String> selectImgByAid(int aid);

    void deleteUrl(String url);
}
