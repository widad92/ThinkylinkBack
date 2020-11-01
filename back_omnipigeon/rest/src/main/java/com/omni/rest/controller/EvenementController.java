/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.Evenement;
import com.omni.core.model.Pigeon;
import com.omni.core.model.StationElevage;
import com.omni.core.service.EvenementService;
import com.omni.core.service.StationElevageService;
import com.omni.core.utils.OmniCoreUtils;
import static com.omni.rest.controller.AbstractController.LOGGER;
import com.omni.rest.dto.EvenementDto;
import com.omni.rest.dto.PigeonDto;
import com.omni.rest.dto.StationDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/evenement")

public class EvenementController extends AbstractController {

    private static final Logger logger = OmniCoreUtils.getLogger(EvenementController.class);

    @Autowired
    private EvenementService evenementService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<EvenementDto> getStations(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("EvenementController - getEvents");
        List<Evenement> evenements = evenementService.findAll();
        return evenements.stream()
                .map(this::convertToEvenementDto)
                .collect(Collectors.toList());
    }

    //http://localhost:8081/omniBackendRest/evenement/evenementById?evenementId=1
    @RequestMapping(value = "/evenementById", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
//    @JsonView({OmniJsonView.ClientView.class})
    public EvenementDto getEvenementById(
            @RequestParam("evenementId") Long evenementId,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws OmniException {
        return mapper.map(evenementService.findEvenementById(evenementId), EvenementDto.class);
    }

    private EvenementDto convertToEvenementDto(Evenement evenement) {
        return mapper.map(evenement, EvenementDto.class);
    }
<<<<<<< .mine

    //@Transactional
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    //@ResponseBody
    public boolean save(@RequestBody EvenementDto evenement) throws OmniException {
        logger.debug("EvenementController - SaveEvenement");
        return evenementService.save(mapper.map(evenement, Evenement.class));
    }

||||||| .r25
    
    
=======

    @Transactional
    @RequestMapping(value = "/save", method = {RequestMethod.PUT})
    @ResponseBody
    public Evenement save(@RequestBody EvenementDto evenement) throws OmniException {
        logger.debug("EvenementController - SaveEvenement : " + evenement);
        return evenementService.save(mapper.map(evenement, Evenement.class));
    }

    @RequestMapping(value = "/deleteById", method = {RequestMethod.OPTIONS})
    @ResponseBody
//    @JsonView({OmniJsonView.ClientView.class})
    public void deleteEvenementById(
            @RequestParam("evenementId") Long evenementId,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws OmniException {
        evenementService.deleteById(evenementId);
    }

>>>>>>> .r31
}
