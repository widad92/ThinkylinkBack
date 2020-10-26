/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service.impl;

import com.omni.core.model.Acteur;

import com.omni.core.repository.ActeurRepository;
import com.omni.core.repository.ClientRepository;
import com.omni.core.service.ActeurService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service("acteur")
public class ActeurServiceImpl implements ActeurService {
    
    @Autowired
    private ActeurRepository acteurRepo;

    @Override
    public List<Acteur> findAll() {
        return acteurRepo.findAll();
    }

    @Override
    public Acteur findActeurById(Long acteurId) {
       return acteurRepo.findOne(acteurId);
    }
    
    @Override
    public Acteur save(Acteur acteurToSave) {
        Acteur acteur = acteurToSave;
        if (acteur.getActeurId()!= null) {
            final Acteur acteurFromDB = acteurRepo.findOne(acteur.getActeurId());
            OmniCoreUtils.copyNonNullProperties(acteurToSave, acteurFromDB);
            acteur = acteurFromDB;
            return acteurRepo.save(acteur);
        }
        return acteurRepo.save(acteur);
    }
    
    
    
}
