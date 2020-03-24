package com.example.oean.dao;

import com.example.oean.pojo.Biology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiologyDAO extends JpaRepository<Biology , Integer> {
    List<Biology> findByName(String name);
    List<Biology> findByNameLike(String name);

}
