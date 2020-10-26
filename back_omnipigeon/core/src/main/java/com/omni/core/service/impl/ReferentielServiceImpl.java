/**
 * ReferentielServiceImpl.java
 */
package com.omni.core.service.impl;

import com.omni.core.model.*;
import com.omni.core.repository.*;
import com.omni.core.service.ReferentielService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("referentielService")
public class ReferentielServiceImpl implements ReferentielService {

    @Autowired
    private ProduitRepository produitRepo;
    
      @Autowired
    private CouleurRepository couleurRepo;
     
    @Autowired
    private CaracteristiqueRepository caracteristiqueRepo;

    @Override
    public List<Produit> findAllProduit() {
        return produitRepo.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Couleur> findAllCouleur() {
        return couleurRepo.findAll().stream()
                .collect(Collectors.toList());
    }
    
     @Override
    public List<Caracteristique> findAllCaracteristique() {
        return caracteristiqueRepo.findAll().stream()
                .collect(Collectors.toList());
    }

}
