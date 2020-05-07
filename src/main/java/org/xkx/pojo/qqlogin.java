package org.xkx.pojo;

public class qqlogin {
    private int godId;
    private String QQOpenId;

    public qqlogin(int godId, String QQOpenId) {
        this.godId = godId;
        this.QQOpenId = QQOpenId;
    }

    public qqlogin() {
    }

    public int getGodId() {
        return godId;
    }

    public void setGodId(int godId) {
        this.godId = godId;
    }

    public String getQQOpenId() {
        return QQOpenId;
    }

    public void setQQOpenId(String QQOpenId) {
        this.QQOpenId = QQOpenId;
    }
}
