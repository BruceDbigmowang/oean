package com.example.oean.dao;

import com.example.oean.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {
    Account findByAccount(String account);
    Account findByAccountAndPassword(String account , String password);
    List<Account> findByRole(String role);
}
