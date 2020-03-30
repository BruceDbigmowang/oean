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

    public List<Biology> findAll(){
        return biologyDAO.findAll();
    }

    public void save(Biology biology){
        biologyDAO.save(biology);
    }

    public boolean checkExist(String name){
        List<Biology> biologyList = biologyDAO.findByName(name);
        if(biologyList == null || biologyList.size() == 0){
            return false;
        }else{
            return true;
        }
    }
    public void delete(int bid){
        biologyDAO.deleteById(bid);
    }

    public List<Biology> find(String JIE , String MEN , String GANG , String MU , String KE , String SHU){
        return biologyDAO.find(JIE , MEN , GANG , MU , KE , SHU);
    }

    public List<Biology> findByJIE(String JIE){
        return biologyDAO.findByJie(JIE);
    }

    public List<Biology> findByMEN(String MEN){
        return biologyDAO.findByMen(MEN);
    }

    public List<Biology> findByGANG(String GANG){
        return biologyDAO.findByGang(GANG);
    }

    public List<Biology> findByMU(String MU){
        return biologyDAO.findByMu(MU);
    }

    public List<Biology> findByKE(String KE){
        return biologyDAO.findByKe(KE);
    }

    public List<Biology> findBySHU(String SHU){
        return biologyDAO.findByShu(SHU);
    }
}
