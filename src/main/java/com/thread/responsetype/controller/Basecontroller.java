package com.thread.responsetype.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Basecontroller {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object Mexp(HttpServletRequest request, Exception ex){
        responsetype rt = new responsetype();
        Map<String,Object> map = new HashMap();
        System.out.println(ex.getClass());
        if(ex instanceof Mexception){
            Mexception mexception = (Mexception) ex;
            map.put("errcode",mexception.geterrcode());
            map.put("errmessage",mexception.geterrormsg());
        }else{
            map.put("errcode", erroen.UNKNOW_ERROR.geterrcode());
            map.put("errmessage",erroen.UNKNOW_ERROR.geterrormsg());
        }
        return rt.create(map,"fail");
    }

    public String Md5encode(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        String ss =   base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
        return  ss;
    }
}
