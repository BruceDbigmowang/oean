package com.example.oean.controller;

import com.example.oean.pojo.Biology;
import com.example.oean.service.BiologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiologyController {

    @Autowired
    BiologyService biologyService;

    @RequestMapping("/searchCategory")
    public Biology findByName(@RequestParam("oean")String oean){
        oean=oean.trim();
        return biologyService.findByName(oean);
    }

    @RequestMapping("/updateCategory")
    public void updateRecord(@RequestParam("name")String name , @RequestParam("JIE")String JIE , @RequestParam("MEN")String MEN , @RequestParam("GANG")String GANG ,
                             @RequestParam("MU")String MU , @RequestParam("KE")String KE , @RequestParam("SHU")String SHU){

        Biology oean = biologyService.findByName(name);
        int id = oean.getId();
        String info = oean.getInfo();
        Biology biology = new Biology();
        biology.setId(id);
        biology.setInfo(info);
        biology.setName(name);
        if(JIE != null && JIE.trim() !=""){
            biology.setJie(JIE);
        }
        if(MEN != null && MEN.trim() !=""){
            biology.setMen(MEN);
        }
        if(GANG != null && GANG.trim() !=""){
            biology.setGang(GANG);
        }
        if(MU != null && MU.trim() !=""){
            biology.setMu(MU);
        }
        if(KE != null && KE.trim() !=""){
            biology.setKe(KE);
        }
        if(SHU != null && SHU.trim() !=""){
            biology.setShu(SHU);
        }
        biologyService.updateRecord(biology);
    }

    @RequestMapping("/findAll")
    public List<Biology> all(){
        return biologyService.findAll();
    }

    @RequestMapping("checkHas")
    public boolean exist(@RequestParam("name")String name){
        return biologyService.checkExist(name);
    }

    @RequestMapping("/saveAll")
    public void save(@RequestParam("name")String name , @RequestParam("JIE")String JIE , @RequestParam("MEN")String MEN , @RequestParam("GANG")String GANG , @RequestParam("MU")String MU ,
                     @RequestParam("KE")String KE , @RequestParam("SHU")String SHU , @RequestParam("Info")String Info){
        Biology biology = new Biology();
        biology.setName(name);
        if(!JIE.equals("")){
            biology.setJie(JIE);
        }

        if(!MEN.equals("")){
            biology.setMen(MEN);
        }

        if(!GANG.equals("")){
            biology.setGang(GANG);
        }

        if(!MU.equals("")){
            biology.setMu(MU);
        }

        if(!KE.equals("")){
            biology.setKe(KE);
        }

        if(!SHU.equals("")){
            biology.setShu(SHU);
        }

        if(!Info.equals("")){
            biology.setInfo(Info);
        }
        biologyService.save(biology);
    }

    @RequestMapping("/deleteBiology")
    public void delete(@RequestParam("bid")int bid){
        biologyService.delete(bid);
    }
}
