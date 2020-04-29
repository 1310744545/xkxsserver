package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.movieContent;

import java.util.List;

@Mapper
@Repository
public interface MovieContentMapper {
    List<movieContent> selectMovieContentByMovieId(int movieId);
}
