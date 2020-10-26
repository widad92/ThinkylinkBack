/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.Acteur;
import com.omni.core.model.Enchere;
import com.omni.core.model.Evenement;
import com.omni.core.model.StationElevage;
import com.omni.core.service.EnchereService;
import com.omni.core.service.StationElevageService;
import com.omni.core.utils.OmniCoreUtils;
import static com.omni.rest.controller.AbstractController.LOGGER;
import com.omni.rest.dto.ActeurDto;
import com.omni.rest.dto.EnchereDto;
import com.omni.rest.dto.OrganisationDto;
import com.omni.rest.dto.StationDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/enchere")
public class enchereController   extends AbstractController{
    
    private static final Logger logger = OmniCoreUtils.getLogger(enchereController.class);
     
    @Autowired
    private EnchereService enchereService;
     
     
    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<EnchereDto> getEncheres(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("EnchereController - getEncheres");
        List<Enchere> encheres = enchereService.findAll();
        return encheres.stream()
                .map(this::convertToEnchereDto)
                .collect(Collectors.toList());
    }
    
     
    @RequestMapping(value = "/enchereById", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
//    @JsonView({OmniJsonView.ClientView.class})
    public EnchereDto getEnchereById(
            @RequestParam(value = "enchereId") Long enchereId, HttpServletRequest request,
            HttpServletResponse response
    ) throws OmniException {
        return mapper.map(enchereService.findEnchereById(enchereId), EnchereDto.class);
    }
    

    
   
     private EnchereDto convertToEnchereDto(Enchere enchere) {
        return mapper.map(enchere, EnchereDto.class);
    }
         @RequestMapping(value = "/save", method = {RequestMethod.POST})
       @ResponseBody
     public EnchereDto save(@RequestBody Enchere enchere) throws OmniException {
        logger.debug("EnchereController - SaveEnchere");
          Enchere _enchere = enchereService.save(mapper.map(enchere, Enchere.class));
        return mapper.map(_enchere, EnchereDto.class);
    }
   
}
