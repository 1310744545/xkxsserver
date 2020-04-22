package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.comment;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    void addComment(comment comment);

    int selectMaxCid();

    List<comment> selectAllCommentByAid(int aid);
}
