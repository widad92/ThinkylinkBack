/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.Enchere;
import com.omni.core.model.StationElevage;
import com.omni.core.service.StationElevageService;
import com.omni.core.utils.OmniCoreUtils;
import static com.omni.rest.controller.AbstractController.LOGGER;
<<<<<<< .mine
import com.omni.rest.dto.EnchereDto;
import com.omni.rest.dto.PigeonDto;
||||||| .r25
import com.omni.rest.dto.PigeonDto;
=======
>>>>>>> .r31
import com.omni.rest.dto.StationDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
@RequestMapping("/station")
public class StationElevageController extends AbstractController {

    private static final Logger logger = OmniCoreUtils.getLogger(StationElevageController.class);

    @Autowired
    private StationElevageService stationService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<StationDto> getStations(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("StationElevageController - getStations");
        List<StationElevage> Stations = stationService.findAll();
        return Stations.stream()
                .map(this::convertToStationDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/stationById", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
//    @JsonView({OmniJsonView.ClientView.class})
    public StationDto getActeurById(
            @RequestParam(value = "stationId") Long stationId,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws OmniException {
        return mapper.map(stationService.findStationById(stationId), StationDto.class);
    }

    private StationDto convertToStationDto(StationElevage station) {
        return mapper.map(station, StationDto.class);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.PUT})
    @ResponseBody
    public boolean save(@RequestBody StationDto station) throws OmniException {
        logger.debug("StationController - SaveStation");
        return stationService.save(mapper.map(station, StationElevage.class)) != null;
    }

           @RequestMapping(value = "/save", method = {RequestMethod.POST})
       @ResponseBody
     public StationDto save(@RequestBody StationElevage station) throws OmniException {
        logger.debug("StationController - SaveStation");
          StationElevage _station = stationService.save(mapper.map(station, StationElevage.class));
        return mapper.map(_station, StationDto.class);
    }
   
}
