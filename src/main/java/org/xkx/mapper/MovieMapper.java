package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.movie;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {

    List<movie> selectMovies();

    List<movie> selectMovieDetailByMovieId(int movieId);
}
