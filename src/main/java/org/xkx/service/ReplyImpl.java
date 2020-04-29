package org.xkx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.ReplyMapper;
import org.xkx.pojo.reply;

import java.util.List;

@Service
public class ReplyImpl implements IReplyServer {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public void addReply(reply reply) {
        replyMapper.addReply(reply);
    }

    @Override
    public List<reply> selectReply(int cid) {
       return replyMapper.selectReply(cid);
    }

}
