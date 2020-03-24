package com.example.oean.service;

import com.example.oean.dao.AccountDAO;
import com.example.oean.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;

    public Account login(String account , String password){
        return accountDAO.findByAccountAndPassword(account , password);
    }
}
