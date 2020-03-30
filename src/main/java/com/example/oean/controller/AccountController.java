package com.example.oean.controller;

import com.example.oean.pojo.Account;
import com.example.oean.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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


    @RequestMapping("/showAllUser")
    public List<Account> findAllUser(@RequestParam("role")String role){
        return accountService.findByRole(role);
    }

    @RequestMapping("/has")
    public boolean exist(@RequestParam("account")String account){
        return accountService.exist(account);
    }

    @RequestMapping("/saveUser")
    public void save(@RequestParam("account")String account , @RequestParam("name")String name){
        Account user = new Account();
        user.setAccount(account);
        user.setName(name);
        user.setPassword("12345678");
        user.setRole("user");
        accountService.save(user);
    }

    @RequestMapping("/changeRole")
    public void changeRole(@RequestParam("account")String account , @RequestParam("role")String role){
        Account user = accountService.findByAccount(account);
        String name = user.getName();
        String password = user.getPassword();
        Account person = new Account();
        person.setAccount(account);
        person.setName(name);
        person.setPassword(password);
        person.setRole(role);
        accountService.save(person);
    }
}
