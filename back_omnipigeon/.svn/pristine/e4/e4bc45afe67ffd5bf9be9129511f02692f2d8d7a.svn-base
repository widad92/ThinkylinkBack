/**
 * OrganisationServce.java
 */
package com.omni.core.service;

import com.omni.core.model.Organisation;
import com.omni.core.model.User;
import java.util.List;

/**
 * This class is {@link OrganisationService} organisation service interface.
 *
 *
 * @author
 *
 */
public interface OrganisationService {

    public List<Organisation> findAll();

    public Organisation findOrganisationById(Long organisationId);

    public Organisation findByAliasOrganisation(String aliasOrganisation);

    public Organisation save(final Organisation organisation);

    public Organisation findOrganisationByUser(User user);

    public Organisation getCurrentOrganisation();

    public Integer countByDenomination(String denomination);

    public List<Organisation> findAllActiveOrganisation();

}
