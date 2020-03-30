package com.example.oean.dao;

import com.example.oean.pojo.Biology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BiologyDAO extends JpaRepository<Biology , Integer> {
    List<Biology> findByName(String name);
    List<Biology> findByNameLike(String name);
    List<Biology> findByJie(String JIE);
    List<Biology> findByMen(String MEN);
    @Query(value = "select * from oeanbiology where if(?1 !='',JIE =?1 ,1=1) and if(?2 != '' , MEN =?2,1=1) and if(?3 != '',GANG=?3,1=1) and if(?4 !='' , MU=?4,1=1) " +
            "and if(?5 != '', KE=?5,1=1) and if(?6 != '' , SHU=?6,1=1)",nativeQuery = true)
    List<Biology> find(String JIE , String MEN , String GANG , String MU , String KE , String SHU);
    List<Biology> findByGang(String GANG);
    List<Biology> findByMu(String MU);
    List<Biology> findByKe(String KE);
    List<Biology> findByShu(String SHU);
}
