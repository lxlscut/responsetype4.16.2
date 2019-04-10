package com.thread.responsetype.controller;

import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Basecontroller {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object Mexp(HttpServletRequest request, Exception ex){
        responsetype rt = new responsetype();
        Map<String,Object> map = new HashMap();
        if(ex instanceof Mexception){
            map.put("errcode",((Mexception) ex).geterrcode());
            map.put("errmessage",((Mexception) ex).geterrormsg());
        }else{
            map.put("errorcode", erroen.UNKNOW_ERROR.geterrcode());
            map.put("errmsg",erroen.UNKNOW_ERROR.geterrormsg());
        }
        return rt.create(map,"fail");
    }
}
