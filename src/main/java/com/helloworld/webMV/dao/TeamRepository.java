package com.helloworld.webMV.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.helloworld.webMV.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long> {

    @Query("select t from Team t where t.name like :x")
    
    List<Team> findByName(@Param("x")String mc);
    
    }