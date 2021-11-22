package com.example.security.controller;

import com.example.security.config.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class ApplicationController {

    @GetMapping("login")
    public String login(){
        return Constant.VIEW_LOGIN;
    }

    @GetMapping("login/error")
    public ModelAndView loginError(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error","Invalid Credential");
        modelAndView.setViewName(Constant.VIEW_LOGIN);
        return modelAndView;
    }

}
