package org.xkx.service;

import org.xkx.pojo.movieContent;

import java.util.List;

public interface IMovieContentService {
    List<movieContent> selectMovieContentByMovieId(int movieId);
}
