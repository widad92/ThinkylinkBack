/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;

import com.omni.core.model.Evenement;
import com.omni.core.model.Pigeon;
import java.util.List;

/**
 *
 * @author asus
 */
public interface EvenementService {
   
    public List<Evenement> findAll();

    public Evenement findEvenementById(Long evenementId);
    
    public boolean save(final Evenement evenement);
}