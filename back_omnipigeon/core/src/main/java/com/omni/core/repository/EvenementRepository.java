/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.repository;

import com.omni.core.model.Evenement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Repository
public interface EvenementRepository extends JpaRepository<Evenement , Long> {
 //  @Transactional
    //
    //@Query("delete from Evenement e where e.evenementId=:x")
   // public  void  deleteByEvenementId(Long evenementId);
    
    @Modifying
    @Query("delete from Evenement e where e.evenementId= ?1")
    public  void  deleteByEvenementId(Long evenementId);
    
}
