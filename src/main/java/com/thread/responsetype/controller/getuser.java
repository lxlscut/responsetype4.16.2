package com.thread.responsetype.controller;

import com.thread.responsetype.controller.viewobject.Userview;
import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import com.thread.responsetype.service.Service;
import com.thread.responsetype.service.serviceimpl.ServiceImpl;
import com.thread.responsetype.service.usermodel.Usermodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller
@RequestMapping("/get")
public class getuser extends Basecontroller {
    @Autowired
    private Service serv;
    @Autowired
    //对应当前用户的请求，自动可以解决并发问题
    private  HttpServletRequest httpServletRequest;

    @RequestMapping("/Byid")
    @ResponseBody
    public responsetype getuser(@RequestParam(name = "id")int id) throws Mexception {
        responsetype rt = new responsetype();
        Userview userview = new Userview();
        Usermodel i =  serv.selectByPrimaryKey(id);
        if(i==null)
            throw new Mexception(erroen.USER_NOT_EXIST);

            return rt.create(convert(i));
    }
    @RequestMapping("/sign")
    @ResponseBody
    public responsetype sign(@RequestParam(name = "telphone")String telphone){
        responsetype rt = new responsetype();
        //1.产生验证码
        Random random = new Random();
        int a = random.nextInt(89999);
        a+=10000;
        //2.将验证码与手机号绑定,使用Httpsession方式
        httpServletRequest.getSession().setAttribute(telphone,String.valueOf(a));
        //3.向指定手机号发送验证码
        System.out.println("telphone = "+telphone+"&OTP = " +a);
        return rt.create(null);
    }

    private Userview convert(Usermodel um){
        Userview uv = new Userview();
        BeanUtils.copyProperties(um,uv);
        return uv;
    }


}
