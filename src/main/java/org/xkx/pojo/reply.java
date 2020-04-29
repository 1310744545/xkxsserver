package org.xkx.pojo;

import java.util.List;

public class reply {
    private String content;
    private int cid;
    private int fromId ;
    private int toId;
    private long time;
    private String fromName;
    private String toName;
    private String fromImg;


    public reply(String content, int cid, int fromId, int toId, long time, String fromName, String toName, String fromImg) {
        this.content = content;
        this.cid = cid;
        this.fromId = fromId;
        this.toId = toId;
        this.time = time;
        this.fromName = fromName;
        this.toName = toName;
        this.fromImg = fromImg;
    }

    public reply(String content, int cid, int fromId, int toId, long time) {
        this.content = content;
        this.cid = cid;
        this.fromId = fromId;
        this.toId = toId;
        this.time = time;
    }
    public reply() {
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getFromImg() {
        return fromImg;
    }

    public void setFromImg(String fromImg) {
        this.fromImg = fromImg;
    }

    @Override
    public String toString() {
        return "reply{" +
                "content='" + content + '\'' +
                ", cid=" + cid +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", time=" + time +
                ", fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", fromImg='" + fromImg + '\'' +
                '}';
    }
}
