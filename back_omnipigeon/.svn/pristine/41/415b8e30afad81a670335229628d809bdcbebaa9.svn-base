/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.model;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import org.hibernate.annotations.Proxy;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "stationElevage")
@Proxy(lazy = false)

public class StationElevage extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stationId", unique = true, nullable = false)
    private Long stationId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "adresseId", referencedColumnName = "adresseId")
    private Adresse adresse;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "tel")
    private long tel;

    //@OneToMany(mappedBy="stationElevage")
    //@Column(name = "pigeons")
    //@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "stationElevage")
    private List<Pigeon> pigeons;
/*
    //@OneToMany(mappedBy="stationElevage")
    //@Column(name = "Soigneurs")
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "stationElevage")
    private List<Acteur> soigneurs;

    //@OneToMany(mappedBy="stationElevage")
    //@Column(name = "eleveurs")
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "stationElevage")
    private List<Acteur> eleveurs;*/

    public StationElevage() {
        super();
    }

    /**
     * @return the stationId
     */
    public Long getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
     * @return the tel
     */
    public long getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(long tel) {
        this.tel = tel;
    }

  
    
    
}
