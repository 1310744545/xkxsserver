package org.xkx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xkx.mapper.CommentMapper;
import org.xkx.pojo.comment;

import java.util.List;

@Service
public class CommentImpl implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void addComment(comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public int selectMaxCid() {
        return commentMapper.selectMaxCid();
    }

    @Override
    public List<comment> selectAllCommentByAid(int aid) {
        return commentMapper.selectAllCommentByAid(aid);
    }
}
