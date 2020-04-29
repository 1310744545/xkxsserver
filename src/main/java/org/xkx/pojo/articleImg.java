package org.xkx.pojo;

public class articleImg {
    private String url;
    private int aid;

    public articleImg(String url, int aid) {
        this.url = url;
        this.aid = aid;
    }

    public articleImg() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
