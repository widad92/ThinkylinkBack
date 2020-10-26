package com.omni.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "adresse")
@Proxy(lazy = false)

public class Adresse extends AbstractTimestampEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresseId", unique = true, nullable = false)
    private Long adresseId;

    @Column(name = "adr1")
    private String adr1;

    @Column(name = "adr2", length = 150)
    private String adr2;

    @Column(name = "adr3", length = 150)
    private String adr3;

    @Column(name = "cp", length = 5)
    private String cp;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "pays", length = 50)
    private String pays;

    @Column(name = "libelleAdresse")
    private String libelleAdresse;

    @Column(name = "latitude", length = 12)
    private String latitude;

    @Column(name = "longitude", length = 12)
    private String longitude;

    public Long getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Long adresseId) {
        this.adresseId = adresseId;
    }

    public String getAdr1() {
        return adr1;
    }

    public void setAdr1(String adr1) {
        this.adr1 = adr1;
    }

    public String getAdr2() {
        return adr2;
    }

    public void setAdr2(String adr2) {
        this.adr2 = adr2;
    }

    public String getAdr3() {
        return adr3;
    }

    public void setAdr3(String adr3) {
        this.adr3 = adr3;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
