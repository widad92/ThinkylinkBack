package com.omni.core.repository;

import com.omni.core.model.Organisation;
import com.omni.core.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    public Organisation findByUser(User user);

    public Organisation findByAliasOrganisationAndFlagOrganisationTrue(String aliasOrganisation);

    public boolean existsBySiret(String siret);

    public List<Organisation> findByFlagOrganisationTrue();

    public Integer countByDenomination(String denomination);
}
