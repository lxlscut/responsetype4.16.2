package com.thread.responsetype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class Register {
    @RequestMapping("/user")
    public String login(){
        return "loginp";
    }
    @RequestMapping("/mmm")
    public String mmm(){
        return "Register";
    }
    @RequestMapping("/loginl")
    public String lll(){
        return "login";
    }
}
