package org.xkx.service;




import org.xkx.pojo.god;

import java.util.Map;

public interface IGodService {
    god selectGodByCount(String count);

    god selectGodById(int id);

    String godUpdateById(god god);

    boolean isExist(String count);

    String addGod(god god);

    void setHeadUrl(Map headMap);

}
