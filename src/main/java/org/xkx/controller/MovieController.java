package org.xkx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xkx.pojo.movie;
import org.xkx.pojo.movieContent;
import org.xkx.service.IMovieContentService;
import org.xkx.service.IMovieServer;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    IMovieServer iMovieServer;
    @Autowired
    IMovieContentService iMovieContentService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/selectMoves")
    public List<movie> selectMoves(){
        return iMovieServer.selectMoves();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/selectMovieDetailByMovieId")
    public List<movie> selectMovieDetailByMovieId(@RequestBody movie movie){
        return iMovieServer.selectMovieDetailByMovieId(movie.getMovieId());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/selectMovieContentByMovieId")
    public List<movieContent> selectMovieContentByMovieId(@RequestBody movie movie){
        return iMovieContentService.selectMovieContentByMovieId(movie.getMovieId());

    }
}