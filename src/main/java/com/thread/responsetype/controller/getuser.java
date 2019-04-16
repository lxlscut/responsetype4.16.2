package com.thread.responsetype.controller;

import com.thread.responsetype.controller.viewobject.Userview;
import com.thread.responsetype.error.erroen;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import com.thread.responsetype.service.UserService;
import com.thread.responsetype.service.usermodel.Usermodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


@Controller
@RequestMapping("/get")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class getuser extends Basecontroller {
    @Autowired
    private UserService serv;
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
    public responsetype sign(@RequestParam(name = "u")String telphone){
        responsetype rt = new responsetype();
        //1.产生验证码
        Random random = new Random();
        int a = random.nextInt(89999);
        a+=10000;
        //2.将验证码与手机号绑定,使用Httpsession方式
        httpServletRequest.getSession().setAttribute(telphone,String.valueOf(a));
        String otpcode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        System.out.println(otpcode);
        //3.向指定手机号发送验证码
        System.out.println("telphone = "+telphone+"&OTP = " +a);
        return rt.create(null);
    }

    @RequestMapping("/Register")
    @ResponseBody
    public responsetype register(@RequestParam(name = "telphone")String telphone,
                                 @RequestParam(name = "name")String name,
                                 @RequestParam(name = "gerder")String gerder,
                                 @RequestParam(name = "password")String password,
                                 @RequestParam(name = "otp")String otp
                                 ) throws Mexception, UnsupportedEncodingException, NoSuchAlgorithmException {
        responsetype rt = new responsetype();
        String otpcode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        System.out.println(otpcode);
        //如果验证码错误，抛出异常
        if(!otp.equals(otpcode)){
            System.out.println("hahhahaha");
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"验证码错误");
        }
        //如果验证码正确，进入用户注册流程
        Usermodel usermodel = new Usermodel();
        usermodel.setPassword(Md5encode(password));
        usermodel.setGerder(Integer.valueOf(gerder));
        usermodel.setName(name);
        usermodel.setTelephone(Integer.valueOf(telphone));
        usermodel.setRegisterMode("by phone");
        System.out.println(usermodel);
        serv.register(usermodel);
        System.out.println("telphone"+telphone +"name"+name+"gerder"+gerder+"password"+password+"otp"+ otp);
        return  rt.create(null);

    }






    private Userview convert(Usermodel um){
        Userview uv = new Userview();
        BeanUtils.copyProperties(um,uv);
        return uv;
    }


}
