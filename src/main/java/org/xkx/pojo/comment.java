package org.xkx.pojo;

public class comment {
    private int cid;
    private String comment;
    private int aid;
    private long time;
    private god god;


    public comment(int cid, String comment, int aid, long time, god god) {
        this.cid=cid;
        this.comment = comment;
        this.aid = aid;
        this.time = time;
        this.god = god;
    }
    public comment(String comment, int aid,god god) {
        this.comment = comment;
        this.aid = aid;
        this.god = god;
    }

    public comment() {
    }



    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public org.xkx.pojo.god getGod() {
        return god;
    }

    public void setGod(org.xkx.pojo.god god) {
        this.god = god;
    }


    @Override
    public String toString() {
        return "comment{" +
                "cid=" + cid +
                ", comment='" + comment + '\'' +
                ", aid=" + aid +
                ", time=" + time +
                ", god=" + god +
                '}';
    }
}
