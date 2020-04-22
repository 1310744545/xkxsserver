package org.xkx.pojo;

public class article {
    private int aid;
    private String title;
    private String content;
    private int uid;
    private String time;
    private int comment;
    private int praise;
    private int read;
    private god god;

    public article(int aid, String title, String content, int uid, String time, int comment, int praise, int read, org.xkx.pojo.god god) {
        this.aid = aid;
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.time = time;
        this.comment = comment;
        this.praise = praise;
        this.read = read;
        this.god = god;
    }


    public article(int aid, String title, String content, int uid, String time, int comment, int praise, int read) {
        this.aid = aid;
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.time = time;
        this.comment = comment;
        this.praise = praise;
        this.read=read;
    }


    public article() {
    }

    public org.xkx.pojo.god getGod() {
        return god;
    }

    public void setGod(org.xkx.pojo.god god) {
        this.god = god;
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

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
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
