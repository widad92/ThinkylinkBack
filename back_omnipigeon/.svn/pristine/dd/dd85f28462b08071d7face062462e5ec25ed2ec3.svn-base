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
@Table(name = "produit")
@Proxy(lazy = false)
public class Produit extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produitId", unique = true, nullable = false)
    private Long produitId;

    // Le nom du produit
    @Column(name = "libelleProduit", length = 100)
    private String libelleProduit;

    // Description détaillée du produit
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
