package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.service.ReferentielService;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.rest.dto.*;
//import com.omni.rest.view.OmniJsonView;
//import com.fasterxml.jackson.annotation.JsonView;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/referentiel")
public class ReferentielController extends AbstractController {

    private static final Logger logger = OmniCoreUtils.getLogger(ReferentielController.class);
    @Autowired
    private ReferentielService referentielService;

    /**
     * findAll Partenaires
     *
     * @param request
     * @param response
     * @return
     * @throws com.omni.core.exceptions.OmniException
     * @throws java.io.IOException
     */
//    @JsonView(omniJsonView.PublicView.class)
    @RequestMapping(value = "/produit/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<ProduitDto> findAllProduit(HttpServletRequest request, HttpServletResponse response) throws OmniException, IOException {
        return mapList(referentielService.findAllProduit(), ProduitDto.class);
    }
    
    
        @RequestMapping(value = "/couleur/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<CouleurDto> findAllCouleur(HttpServletRequest request, HttpServletResponse response) throws OmniException, IOException {
        return mapList(referentielService.findAllCouleur(), CouleurDto.class);
    }
    
     @RequestMapping(value = "/caracteristique/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<CaracteristiqueDto> findAllCaracteristique(HttpServletRequest request, HttpServletResponse response) throws OmniException, IOException {
        return mapList(referentielService.findAllCaracteristique(), CaracteristiqueDto.class);
    }
}