package org.xkx.controller;

public class Result {
    //响应码
    private int code;
    private int id;
    private String msg;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, int id) {
        this.code = code;
        this.id=id;
    }
    public Result(String msg) {
        this.msg=msg;
    }

    public Result() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
