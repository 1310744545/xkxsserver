package org.xkx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.MovieContentMapper;
import org.xkx.pojo.movieContent;

import java.util.List;

@Service
public class MovieContentServiceImpl implements IMovieContentService{
    @Autowired
    MovieContentMapper movieContentMapper;

    @Override
    public List<movieContent> selectMovieContentByMovieId(int movieId) {
        return movieContentMapper.selectMovieContentByMovieId(movieId);
    }
}
