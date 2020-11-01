/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.*;
import com.omni.core.service.PigeonService;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.rest.dto.OrganisationDto;
import com.omni.rest.dto.PigeonDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< .mine
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
||||||| .r25
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> .r31
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
@RequestMapping("/pigeon")

public class PigeonController extends AbstractController {

    private static final Logger logger = OmniCoreUtils.getLogger(PigeonController.class);

    @Autowired
    private PigeonService pigeonService;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<PigeonDto> getPigeons(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("PigeonController - getPigeons");
        List<Pigeon> pigeons = pigeonService.findAll();
        return pigeons.stream()
                .map(this::convertToPigeonDto)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/pigeonById", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
//    @JsonView({OmniJsonView.ClientView.class})
    public PigeonDto getPigeonById(
            @RequestParam(value = "pigeonId") Long pigeonId, HttpServletRequest request,
            HttpServletResponse response
    ) throws OmniException {
        return mapper.map(pigeonService.findPigeonById(pigeonId), PigeonDto.class);
    }

    private PigeonDto convertToPigeonDto(Pigeon pigeon) {
        return mapper.map(pigeon, PigeonDto.class);
    }
    
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public PigeonDto save(@RequestBody Pigeon pigeon) throws OmniException {
        logger.debug("Pigeonontroller - SavePigeon");
          Pigeon _pigeon = pigeonService.save(mapper.map(pigeon, Pigeon.class));
        return mapper.map(_pigeon, PigeonDto.class);
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public PigeonDto save(@RequestBody PigeonDto pigeon) throws OmniException {
        logger.debug("Pigeonontroller - SavePigeon");
        return mapper.map(pigeonService.save(mapper.map(pigeon, Pigeon.class)), PigeonDto.class);
    }

}
