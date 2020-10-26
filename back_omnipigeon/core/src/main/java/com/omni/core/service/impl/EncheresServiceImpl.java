/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service.impl;

import com.google.j2objc.annotations.AutoreleasePool;
import com.omni.core.model.Enchere;
import com.omni.core.repository.EncheresRepository;
import com.omni.core.service.EnchereService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service("enchereService")
public class EncheresServiceImpl implements EnchereService {
    
    @Autowired
    EncheresRepository ancheresReposiory;
    

    @Override
    public List<Enchere> findAll() {
        return  ancheresReposiory.findAll();
    }

    @Override
    public Enchere findEnchereById(Long anchereId) {
       return ancheresReposiory.findOne(anchereId);
    }
    
     
  
    @Override
    public Enchere save(Enchere enchereToSave) {
        Enchere enchere = enchereToSave;
        if (enchere.getEnchersId()!= null) {
            final Enchere enchereFromDB = ancheresReposiory.findOne(enchere.getEnchersId());
            OmniCoreUtils.copyNonNullProperties(enchereToSave, enchereFromDB);
            enchere = enchereFromDB;
            return ancheresReposiory.save(enchere);
        }
        return ancheresReposiory.save(enchere);
    }

}
