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
@Table(name = "couleur")
@Proxy(lazy = false)
public class Couleur extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couleurId", unique = true, nullable = false)
    private Long couleurId;

    @Column(name = "codeCouleur", length = 100)
    private String codeCouleur;

    @Column(name = "libelleCouleur", length = 100)
    private String libelleCouleur;

    @Column(name = "isPigeon", length = 100)
    private String isPigeon;

    @Column(name = "isYeux", length = 100)
    private String isYeux;

    @Column(name = "isBague", length = 100)
    private String isBague;

    /**
     * @return the couleurId
     */
    public Long getCouleurId() {
        return couleurId;
    }

    /**
     * @param couleurId the couleurId to set
     */
    public void setCouleurId(Long couleurId) {
        this.couleurId = couleurId;
    }

    /**
     * @return the codeCouleur
     */
    public String getCodeCouleur() {
        return codeCouleur;
    }

    /**
     * @param codeCouleur the codeCouleur to set
     */
    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }

    /**
     * @return the libelleCouleur
     */
    public String getLibelleCouleur() {
        return libelleCouleur;
    }

    /**
     * @param libelleCouleur the libelleCouleur to set
     */
    public void setLibelleCouleur(String libelleCouleur) {
        this.libelleCouleur = libelleCouleur;
    }

    /**
     * @return the isPigeon
     */
    public String getIsPigeon() {
        return isPigeon;
    }

    /**
     * @param isPigeon the isPigeon to set
     */
    public void setIsPigeon(String isPigeon) {
        this.isPigeon = isPigeon;
    }

    /**
     * @return the isYeux
     */
    public String getIsYeux() {
        return isYeux;
    }

    /**
     * @param isYeux the isYeux to set
     */
    public void setIsYeux(String isYeux) {
        this.isYeux = isYeux;
    }

    /**
     * @return the isBague
     */
    public String getIsBague() {
        return isBague;
    }

    /**
     * @param isBague the isBague to set
     */
    public void setIsBague(String isBague) {
        this.isBague = isBague;
    }

}
