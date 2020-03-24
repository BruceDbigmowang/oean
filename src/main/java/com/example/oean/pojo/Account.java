package com.example.oean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Account")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Account {
    @Id
    @Column(name = "account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String account;

    @Column(name = "password")
    String password;
    @Column(name="role")
    String role;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
