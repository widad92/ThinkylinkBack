/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service.impl;

import com.omni.core.model.Pigeon;
import com.omni.core.repository.PigeonRepository;
import com.omni.core.service.PigeonService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service("pigeonService")
public class PigeonServiceImpl implements PigeonService {

    @Autowired
    private PigeonRepository pigeonRepo;

    @Override
    public List<Pigeon> findAll() {
        return pigeonRepo.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Pigeon save(Pigeon pigeonToSave) {
        Pigeon pigeon = pigeonToSave;
        if (pigeon.getPigeonId() != null) {
            final Pigeon pigeonFromDB = pigeonRepo.findOne(pigeon.getPigeonId());
            OmniCoreUtils.copyNonNullProperties(pigeonToSave, pigeonFromDB);
            pigeon = pigeonFromDB;
            return pigeonRepo.save(pigeon);
        }
        return pigeonRepo.save(pigeon);
    }

    @Override
    public Pigeon findPigeonById(Long pigeonId) {
        return pigeonRepo.findOne(pigeonId);
    }

    /* @Override
    public List<Pigeon> findPigeonByRefClient(String refClient) {
         return pigeonRepo.findPigeonByRefClient(refClient);
}*/
}
