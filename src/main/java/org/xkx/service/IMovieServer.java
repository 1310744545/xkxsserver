package org.xkx.service;

import org.xkx.pojo.movie;

import java.util.List;

public interface IMovieServer {

    List<movie> selectMoves();

    List<movie> selectMovieDetailByMovieId(int movieId);
}
