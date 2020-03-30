package com.example.oean.controller;

import com.example.oean.pojo.Biology;
import com.example.oean.service.BiologyService;
import com.example.oean.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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

    @RequestMapping("/uploadByExcel")
    public String importByExcel(HttpServletRequest request , HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("excelFile");
        if (file.isEmpty()) {
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream in = null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtils().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            return "请选择需要导入的文件";
        }
        String errorInfo = "OK";
        if(listob.size() == 0){
            return "文件中没有数据";
        }
        for (int i = 0; i < listob.size(); i++) {
            int target = i + 1;
            List<Object> lo = listob.get(i);
            String name = String.valueOf(lo.get(0));
            if(name.equals("")){
                errorInfo = "[第"+target+"行海洋生物名称输入错误]";
                break;
            }
            if(biologyService.checkExist(name) == true){
                errorInfo = "[第"+target+"行海洋生物已存在]";
                break;
            }

        }
        if(errorInfo.equals("OK")){
            for (int i = 0; i < listob.size(); i++) {
                int target = i + 1;
                List<Object> lo = listob.get(i);
                Biology biology = new Biology();
                String name = String.valueOf(lo.get(0));
                biology.setName(name);
                String JIE = String.valueOf(lo.get(1));
                if(!JIE.equals("")){
                    biology.setJie(JIE);
                }
                String MEN = String.valueOf(lo.get(2));
                if(!MEN.equals("")){
                    biology.setMen(MEN);
                }
                String GANG = String.valueOf(lo.get(3));
                if(!GANG.equals("")){
                    biology.setGang(GANG);
                }
                String MU = String .valueOf(lo.get(4));
                if(!MU.equals("")){
                    biology.setMu(MU);
                }
                String KE = String.valueOf(lo.get(5));
                if(!KE.equals("")){
                    biology.setKe(KE);
                }
                String SHU = String.valueOf(lo.get(6));
                if(!SHU.equals("")){
                    biology.setShu(SHU);
                }
                String Info = String.valueOf(lo.get(7));
                if(!Info.equals("")){
                    biology.setInfo(Info);
                }

                biologyService.save(biology);

            }

        }else{
            return errorInfo;
        }
        return "数据导入成功";
    }
}
