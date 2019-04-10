package com.thread.responsetype.exception;


import com.thread.responsetype.error.errorp;
//包装器业务异常实现
public class Mexception extends Exception implements errorp {
    private errorp err;

    //直接接收类的传参构造业务异常
    public Mexception(errorp err){
        super();
        this.err = err;
    }

    //自定义异常
    public Mexception(errorp err,String msg){
        super();
        this.err = err;
        this.seterrormsg(msg);
    }



    @Override
    public int geterrcode() {
        return this.err.geterrcode();
    }

    @Override
    public String geterrormsg() {
        return this.err.geterrormsg();
    }

    @Override
    public errorp seterrormsg(String msg) {
        this.seterrormsg(msg);
        return this.err;
    }
}
