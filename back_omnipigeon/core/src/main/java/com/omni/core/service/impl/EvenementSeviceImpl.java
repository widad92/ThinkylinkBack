/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service.impl;


import com.omni.core.model.Evenement;
import com.omni.core.model.Pigeon;
import com.omni.core.repository.EvenementRepository;
import com.omni.core.service.EvenementService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service("evenementService")
public class EvenementSeviceImpl implements EvenementService {

    @Autowired
    EvenementRepository evenementRepository;

    @Override
    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement findEvenementById(Long evenementId) {
        return evenementRepository.findOne(evenementId);
    }

    @Override
    public Evenement save(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public void deleteById(Long evenementId) {
        evenementRepository.deleteByEvenementId(evenementId);
    }

    @Override
    public boolean save(Evenement evenement) {
//        Evenement evenement = evenementToSave;
//        if (evenement.getEvenementId()!= null) {
//            final Evenement evenementFromDB = evenementRepository.findOne(evenement.getEvenementId());
//            OmniCoreUtils.copyNonNullProperties(evenementToSave, evenementFromDB);
//            evenement = evenementFromDB;
//            return evenementRepository.save(evenement) !=null;
//        }
        return evenementRepository.save(evenement) !=null;
    }
    
}
