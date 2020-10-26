/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.repository;


import com.omni.core.model.Pigeon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface PigeonRepository extends JpaRepository<Pigeon, Long>  {

    //public List<Pigeon> findPigeonByRefClient(String refClient);
    
}
