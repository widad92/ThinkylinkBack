/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "caracteristique")
@Proxy(lazy = false)
public class Caracteristique  extends GenericEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caracteristiqueId", unique = true, nullable = false)
    private Long caracteristiqueId;

    @Column(name = "codeCaracteristique", length = 100)
    private String codeCaracteristique;

    @Column(name = "libelleCaracteristique", length = 100)
    private String libelleCaracteristique;
    
    @Column(name = "caracteristiqueGenerales", length = 100)
    private String caracteristiqueGenerales;
    
    @Column(name = "caracteristiqueAile", length = 100)
    private String caracteristiqueAile;
     
     public Caracteristique() {
		super();
	}

    /**
     * @return the caracteristiqueId
     */
    public Long getCaracteristiqueId() {
        return caracteristiqueId;
    }

    /**
     * @param caracteristiqueId the caracteristiqueId to set
     */
    public void setCaracteristiqueId(Long caracteristiqueId) {
        this.caracteristiqueId = caracteristiqueId;
    }

    /**
     * @return the codeCaracteristique
     */
    public String getCodeCaracteristique() {
        return codeCaracteristique;
    }

    /**
     * @param codeCaracteristique the codeCaracteristique to set
     */
    public void setCodeCaracteristique(String codeCaracteristique) {
        this.codeCaracteristique = codeCaracteristique;
    }

    /**
     * @return the libelleCaracteristique
     */
    public String getLibelleCaracteristique() {
        return libelleCaracteristique;
    }

    /**
     * @param libelleCaracteristique the libelleCaracteristique to set
     */
    public void setLibelleCaracteristique(String libelleCaracteristique) {
        this.libelleCaracteristique = libelleCaracteristique;
    }

    /**
     * @return the caracteristiqueGenerales
     */
    public String getCaracteristiqueGenerales() {
        return caracteristiqueGenerales;
    }

    /**
     * @param caracteristiqueGenerales the caracteristiqueGenerales to set
     */
    public void setCaracteristiqueGenerales(String caracteristiqueGenerales) {
        this.caracteristiqueGenerales = caracteristiqueGenerales;
    }

    /**
     * @return the caracteristiqueAile
     */
    public String getCaracteristiqueAile() {
        return caracteristiqueAile;
    }

    /**
     * @param caracteristiqueAile the caracteristiqueAile to set
     */
    public void setCaracteristiqueAile(String caracteristiqueAile) {
        this.caracteristiqueAile = caracteristiqueAile;
    }
     
     
}
