package com.example.oean.dao;

import com.example.oean.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer> {
    Account findByAccount(String account);
    Account findByAccountAndPassword(String account , String password);
}
