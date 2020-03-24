package com.example.oean.service;

import com.example.oean.dao.BiologyDAO;
import com.example.oean.pojo.Biology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiologyService {
    @Autowired
    BiologyDAO biologyDAO;

    public Biology findByName(String name){
        List<Biology> biologyList = biologyDAO.findByName(name);
        return biologyList.get(0);
    }
    public void updateRecord(Biology biology){
        biologyDAO.save(biology);
    }
}
