/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;

import com.omni.core.model.Enchere;
import com.omni.core.model.Evenement;
import com.omni.core.model.Pigeon;
import java.util.List;

/**
 *
 * @author asus
 */
public interface EnchereService {
    
    public List<Enchere> findAll();
    public Enchere findEnchereById(Long enchereId);
    public Enchere save(final Enchere enchere);

    
}