/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.service;
import com.omni.core.model.Enchere;
import com.omni.core.model.StationElevage;
import java.util.List;

/**
 *
 * @author asus
 */

public interface StationElevageService {
    
      public List<StationElevage> findAll();
      public StationElevage findStationById(Long stationId);
      public StationElevage save(final StationElevage station);
    
}