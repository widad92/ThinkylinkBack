/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;

import com.omni.core.model.Acteur;


import java.util.List;

/**
 *
 * @author asus
 */
public interface ActeurService {
    
        public List<Acteur> findAll();
        public Acteur findActeurById(Long acteurId);
        public Acteur save(final Acteur acteur);

  
    
}