package org.xkx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xkx.pojo.god;
import org.xkx.pojo.reply;
import org.xkx.service.ICommentService;
import org.xkx.service.IGodService;
import org.xkx.service.IReplyServer;

import java.util.List;

@Controller
public class ReplyController {

    @Autowired
    IReplyServer iReplyServer;
    @Autowired
    ICommentService iCommentService;
    @Autowired
    IGodService iGodService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addReply")
    public void addReply(@RequestBody reply reply){
        Long startTs = System.currentTimeMillis();
        reply.setTime(startTs);
        god fromGod = iGodService.selectGodById(reply.getFromId());
        String toName = iGodService.selectGodById(reply.getToId()).getName();
        reply.setFromName(fromGod.getName());
        reply.setFromImg(fromGod.getHeadImg());
        reply.setToName(toName);
        iReplyServer.addReply(reply);
        iCommentService.replyPlus(reply.getCid());
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/selectReply")
    public List<reply> selectReply(@RequestBody reply reply){
       return iReplyServer.selectReply(reply.getCid());
    }
}
