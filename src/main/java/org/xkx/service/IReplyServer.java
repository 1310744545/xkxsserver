package org.xkx.service;

import org.xkx.pojo.reply;

import java.util.List;

public interface IReplyServer {
    void addReply(reply reply);

    List<reply> selectReply(int cid);


}
