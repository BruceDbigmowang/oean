package com.example.oean.service;

import com.example.oean.dao.AccountDAO;
import com.example.oean.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;

    public Account login(String account , String password){
        return accountDAO.findByAccountAndPassword(account , password);
    }

    public List<Account> findByRole(String role){
        return accountDAO.findByRole(role);
    }

    public void save(Account account){
        accountDAO.save(account);
    }

    public boolean exist(String account){
        Account user = accountDAO.findByAccount(account);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }

    public Account findByAccount(String account){
        return accountDAO.findByAccount(account);
    }
}
