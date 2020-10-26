/**
 * OrganisationServiceImpl.java
 */
package com.omni.core.service.impl;

import com.omni.core.model.Organisation;
import com.omni.core.model.User;
import com.omni.core.repository.OrganisationRepository;
import com.omni.core.repository.UserRepository;
import com.omni.core.service.OrganisationService;
import com.omni.core.service.ReferentielService;
import com.omni.core.utils.OmniCoreUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("organisationService")
public class OrganisationServiceImpl implements OrganisationService {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(OrganisationServiceImpl.class);

    @Autowired
    private OrganisationRepository organisationRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ReferentielService referentielService;

    @Override
    public List<Organisation> findAll() {
        return organisationRepo.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Organisation findOrganisationById(Long organisationId) {
        return organisationRepo.findOne(organisationId);
    }

    @Override
    public Organisation save(Organisation organisationToSave) {
        Organisation organisation = organisationToSave;
        if (organisationToSave.getOrganisationId() != null) {// Update Organisation
            LOGGER.info("Update OrganisationId : " + organisationToSave.getOrganisationId());
            final Organisation organisationFromDB = organisationRepo.findOne(organisationToSave.getOrganisationId());
            OmniCoreUtils.copyNonNullProperties(organisationToSave, organisationFromDB);
            organisation = organisationFromDB;
            return organisationRepo.save(organisation);
        } else {// Create new organisation
            LOGGER.info("Create new Organisation : " + organisationToSave.getDenomination() + " Email : " + organisationToSave.getUser().getEmail());
            organisation.setFlagOrganisation(true);

            Organisation _b = organisationRepo.save(organisation);

            return _b;
        }
    }

    @Override
    public Organisation findOrganisationByUser(User user) {
        return organisationRepo.findByUser(user);
    }

    @Override
    public Organisation getCurrentOrganisation() {
        final User user = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        final Organisation organisation = findOrganisationByUser(user);
        return organisation;
    }

    @Override
    public Organisation findByAliasOrganisation(String aliasOrganisation) {
        return organisationRepo.findByAliasOrganisationAndFlagOrganisationTrue(aliasOrganisation);
    }

    @Override
    public Integer countByDenomination(String denomination) {
        return organisationRepo.countByDenomination(denomination);
    }

    @Override
    public List<Organisation> findAllActiveOrganisation() {
        return organisationRepo.findByFlagOrganisationTrue();
    }

}
