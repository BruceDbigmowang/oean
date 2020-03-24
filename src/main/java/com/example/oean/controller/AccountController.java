package com.example.oean.controller;

import com.example.oean.pojo.Account;
import com.example.oean.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/doLogin")
    public int login(@RequestParam("account")String account , @RequestParam("password")String password , HttpSession session){
        Account user = accountService.login(account , password);
        if(user == null){
            return 0;
        }else{
            session.setAttribute("user" , user);
            String role = user.getRole();
            if(role.equals("admin")){
                return 2;
            }else{
                return 1;
            }
        }
    }
}
