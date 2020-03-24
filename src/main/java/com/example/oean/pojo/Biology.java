package com.example.oean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "oeanbiology")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Biology {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "JIE")
    String Jie;
    @Column(name = "MEN")
    String Men;
    @Column(name = "GANG")
    String Gang;
    @Column(name = "MU")
    String Mu;
    @Column(name = "KE")
    String Ke;
    @Column(name = "SHU")
    String Shu;
    @Column(name = "Info")
    String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJie() {
        return Jie;
    }

    public void setJie(String jie) {
        Jie = jie;
    }

    public String getMen() {
        return Men;
    }

    public void setMen(String men) {
        Men = men;
    }

    public String getGang() {
        return Gang;
    }

    public void setGang(String gang) {
        Gang = gang;
    }

    public String getMu() {
        return Mu;
    }

    public void setMu(String mu) {
        Mu = mu;
    }

    public String getKe() {
        return Ke;
    }

    public void setKe(String ke) {
        Ke = ke;
    }

    public String getShu() {
        return Shu;
    }

    public void setShu(String shu) {
        Shu = shu;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
