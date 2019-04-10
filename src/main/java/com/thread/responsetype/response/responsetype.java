package com.thread.responsetype.response;

import org.springframework.stereotype.Component;

@Component
public class responsetype {
   private String status;
   private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //创建通用的创建方法
    public static responsetype create(Object result){
        return responsetype.create(result,"success");
    }

    public static responsetype create(Object result,String status){
        responsetype rt = new responsetype();
        rt.setStatus(status);
        rt.setData(result);
        return rt;
    }



}
