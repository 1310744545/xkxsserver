package org.xkx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xkx.pojo.comment;
import org.xkx.service.IArticleService;
import org.xkx.service.ICommentService;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    ICommentService iCommentService;

    @Autowired
    IArticleService iArticleService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addComment")
    public List<comment> addComment(@RequestBody comment comment){
        int cid = iCommentService.selectMaxCid()+1;
        comment.setCid(cid);
        Long startTs = System.currentTimeMillis();
        comment.setTime(startTs);

        iCommentService.addComment(comment);
        iArticleService.comment(comment.getAid());
        return iCommentService.selectAllCommentByAid(comment.getAid());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/commentCheck")
    public List<comment> commentCheck(@RequestBody comment comment){
        return iCommentService.selectAllCommentByAid(comment.getAid());
    }
}
