package org.xkx.pojo;


public class god {
    private int id;
    private String count;
    private String Password;
    private String name;
    private String email;
    private String url;
    private String introduction;
    private String headImg;



    public god(int id, String count, String name, String email, String url, String introduction,String headImg) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.email = email;
        this.url = url;
        this.introduction = introduction;
        this.headImg=headImg;
    }
    public god(int id, String count, String password, String name) {
        this.id = id;
        this.count = count;
        Password = password;
        this.name = name;
    }
    public god(int id,  String name) {
        this.id = id;
        this.name = name;
    }
    public god(int id) {
        this.id = id;
    }
    public god() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "god{" +
                "id=" + id +
                ", count='" + count + '\'' +
                ", Password='" + Password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
