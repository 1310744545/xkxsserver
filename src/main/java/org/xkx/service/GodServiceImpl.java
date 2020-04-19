package org.xkx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.xkx.mapper.GodMapper;
import org.xkx.pojo.god;

import java.util.Map;

@Service
public class GodServiceImpl implements IGodService {

    @Autowired
    GodMapper godMapper;

    @Override
    public god selectGodByCount(String count) {
        god god = godMapper.selectGodByCount(count);
        return god;
    }

    @Override
    public god selectGodById(int id) {
        return godMapper.selectGodById(id);
    }

    @Override
    public String godUpdateById(god god) {
        try {
            godMapper.godUpdateById(god);
            return "更新成功";
        }catch (Exception e){
            return "系统错误,更新失败";
        }

    }

    @Override
    public boolean isExist(String count) {
       if(godMapper.isExist(count)==0){
           return false;
       }else {
           return true;
       }
    }

    @Override
    public String addGod(god god) {
        if(isExist(god.getCount())){
            return "用户名已存在,注册失败";
        }else {
            godMapper.addGod(god);
            return "注册成功";
        }
    }

    @Override
    public void setHeadUrl(Map headMap) {
        godMapper.setHeadUrl(headMap);
    }
}
