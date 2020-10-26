/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service.impl;

import com.omni.core.model.StationElevage;
import com.omni.core.repository.StationElevageRepository;
import com.omni.core.service.StationElevageService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service("stationElevageService")
public class StationElevageServiceImpl implements  StationElevageService{
    
    @Autowired
    StationElevageRepository stationRepository;
    @Override
    public List<StationElevage> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public StationElevage findStationById(Long stationId) {
        
        return stationRepository.findOne(stationId);
    }
    
    
    @Override
    public StationElevage save(StationElevage stationToSave) {
        StationElevage station = stationToSave;
        if (station.getStationId()!= null) {
            final StationElevage stationFromDB = stationRepository.findOne(station.getStationId());
            OmniCoreUtils.copyNonNullProperties(stationToSave, stationFromDB);
            station = stationFromDB;
            return stationRepository.save(station);
        }
        return stationRepository.save(station);
    }

}
