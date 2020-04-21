package org.xkx.pojo;

public class article {
    private int aid;
    private String title;
    private String content;
    private int uid;
    private String time;

    public article(int aid, String title, String content, int uid, String time) {
        this.aid = aid;
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.time=time;
    }

    public article() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String atitle) {
        this.title = atitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", time='" + time + '\'' +
                '}';
    }
}
