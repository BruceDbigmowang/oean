package com.example.oean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @GetMapping("/")
    public String toLogin(){
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(){
        return "page/login";
    }

    @GetMapping("foreUserIndex")
    public String toUserIndex(){
        return "page/UserIndex";
    }

    @GetMapping("foreAdminIndex")
    public String toAdminIndex(){
        return "page/AdminIndex";
    }

    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }
    @GetMapping("foreUserInfoManager")
    public String toUserInfoManage(){
        return "page/UserInfoManage";
    }
    @GetMapping("/foreCategoryManage")
    public String toCategoryManage(){
        return "page/CategoryManage";
    }
    @GetMapping("/foreInfoManage")
    public String toInfoManage(){
        return "page/InfoManage";
    }
}
