package com.thread.responsetype.error;

public enum erroen implements errorp{
    PARMETER_VALIDATION_ERROR(000001,"参数错误"),
    USER_NOT_EXIST(10001,"用户不存在"),
    UNKNOW_ERROR(20001,"发生未知错误")
    ;
    private int errorcode;
    private String errmsg;

    erroen(int errorcode, String errmsg) {
        this.errorcode = errorcode;
        this.errmsg = errmsg;
    }

    @Override
    public int geterrcode() {
        return this.errorcode;
    }

    @Override
    public String geterrormsg() {
        return this.errmsg;
    }

    @Override
    public errorp seterrormsg(String msg) {
        this.errmsg = msg;
        return this;
    }
}
