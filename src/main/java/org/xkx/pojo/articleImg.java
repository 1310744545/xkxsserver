package org.xkx.pojo;

public class articleImg {
    private String url;
    private int uid;

    public articleImg(String url, int uid) {
        this.url = url;
        this.uid = uid;
    }

    public articleImg() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
