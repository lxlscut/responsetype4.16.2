package com.thread.responsetype.controller;

import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.response.responsetype;
import com.thread.responsetype.service.Service;
import com.thread.responsetype.service.usermodel.Usermodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class returnpage extends Basecontroller{

    @Autowired
    private Service serv;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/loginPage")
    @CrossOrigin
    @ResponseBody
    public responsetype login(@RequestParam(name = "u")Integer telphone,@RequestParam(name = "p")String pw) throws Mexception, UnsupportedEncodingException, NoSuchAlgorithmException {


        responsetype rt = new responsetype();

        Usermodel usermodel = new Usermodel();

        System.out.println("你输入的用户名为：" + telphone);
        System.out.println("你输入的密码为：" + pw);

        usermodel =  serv.loginvalidate(telphone,Md5encode(pw));

        System.out.println("登陆成功");

        httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        httpServletRequest.getSession().setAttribute("LOG_IN_USER",usermodel);

        return rt.create(null);
    }
}
