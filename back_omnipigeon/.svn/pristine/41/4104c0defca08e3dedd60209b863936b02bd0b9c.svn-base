/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;



/**
 *
 * @author asus
 */
@Entity
@Table(name = "acteur")
@Proxy(lazy = false)
public class Acteur extends AbstractTimestampEntity implements Serializable {
    	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "acteurId", unique = true, nullable = false)
	    private Long acteurId;
	    @Column(name = "nom", length = 100)
	    private String nom;
            @Column(name = "prenom", length = 100)
	    private String prenom;
            
            @Column(name = "profession", length = 100)
	    private String profession;
            
           @OneToMany(mappedBy="acteur")
            private List<Pigeon> pigeons ;
            
            /*
            @OneToMany(mappedBy="soigneur")
            private List<Pigeon> pigeons ;*/
        
        //@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        //@JoinColumn(name = "organisationId", referencedColumnName = "organisationId")
       // private Organisation Organisation;
        
       
        //@ManyToOne(fetch = FetchType.EAGER)
        //@JoinColumn(name = "stationElevage")
      //  private StationElevage stationElevage;
        
        public Acteur() {
		super();
	}

    /**
     * @return the acteurId
     */
        
        
    public Long getActeurId() {
        return acteurId;
    }

    /**
     * @param acteurId the acteurId to set
     */
    public void setActeurId(Long acteurId) {
        this.acteurId = acteurId;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return the pigeons
     */
    public List<Pigeon> getPigeons() {
        return pigeons;
    }

    /**
     * @param pigeons the pigeons to set
     */
    public void setPigeons(List<Pigeon> pigeons) {
        this.pigeons = pigeons;
    }

    /**
     * @return the Organisation
     */
  
        
    
}
