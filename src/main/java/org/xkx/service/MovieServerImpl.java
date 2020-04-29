package org.xkx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.MovieMapper;
import org.xkx.pojo.movie;

import java.util.List;

@Service
public class MovieServerImpl implements IMovieServer{
    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<movie> selectMoves() {
        return movieMapper.selectMovies();
    }

    @Override
    public List<movie> selectMovieDetailByMovieId(int movieId) {
       return movieMapper.selectMovieDetailByMovieId(movieId);
    }
}
