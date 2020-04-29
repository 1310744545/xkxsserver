package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.reply;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {
    void addReply(reply reply);

    List<reply> selectReply(int cid);
}
