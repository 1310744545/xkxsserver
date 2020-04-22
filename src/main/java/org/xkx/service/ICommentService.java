package org.xkx.service;

import org.xkx.pojo.comment;

import java.util.List;

public interface ICommentService {
    void addComment(comment comment);

    int selectMaxCid();

    List<comment> selectAllCommentByAid(int aid);
}
