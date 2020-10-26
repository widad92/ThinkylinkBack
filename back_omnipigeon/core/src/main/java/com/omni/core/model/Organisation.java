package com.omni.core.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "organisation")
@Proxy(lazy = false)
public class Organisation extends AbstractTimestampEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organisationId", unique = true, nullable = false)
    private Long organisationId;

    @Column(name = "tel", length = 14)
    private String tel;

    @Column(name = "responsable", length = 100)
    private String responsable;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "siret", length = 15)
    private String siret;

    @Column(name = "flagOrganisation")
    private boolean flagOrganisation;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "aliasOrganisation")
    private String aliasOrganisation;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    /**
     * @return the organisationId
     */
    public Long getOrganisationId() {
        return organisationId;
    }

    /**
     * @param organisationId the organisationId to set
     */
    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * @return the denomination
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * @param denomination the denomination to set
     */
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    /**
     * @return the siret
     */
    public String getSiret() {
        return siret;
    }

    /**
     * @param siret the siret to set
     */
    public void setSiret(String siret) {
        this.siret = siret;
    }

    /**
     * @return the flagOrganisation
     */
    public boolean isFlagOrganisation() {
        return flagOrganisation;
    }

    /**
     * @param flagOrganisation the flagOrganisation to set
     */
    public void setFlagOrganisation(boolean flagOrganisation) {
        this.flagOrganisation = flagOrganisation;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the aliasOrganisation
     */
    public String getAliasOrganisation() {
        return aliasOrganisation;
    }

    /**
     * @param aliasOrganisation the aliasOrganisation to set
     */
    public void setAliasOrganisation(String aliasOrganisation) {
        this.aliasOrganisation = aliasOrganisation;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

   

}
