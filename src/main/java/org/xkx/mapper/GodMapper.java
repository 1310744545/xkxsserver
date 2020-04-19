package org.xkx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xkx.pojo.god;

import java.util.Map;

@Mapper//表示本类是mybatis的mapper
@Repository//表示这是Dao层
public interface GodMapper {
    //判断是否存在
    Integer isExist(String count);
    //增
    void addGod(god god);
    //删
    void deleteGod(String id);
    //改
    void updateGod(god god);
    //godid
    god selectGodByCount(String count);

    god selectGodById(int id);

    void godUpdateById(god god);

    void setHeadUrl(Map headMap);
}
