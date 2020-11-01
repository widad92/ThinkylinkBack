/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.model;

import java.io.Serializable;
<<<<<<< .mine
||||||| .r24
import java.util.Date;
import java.util.List;

=======
import java.util.List;
import javax.persistence.CascadeType;
>>>>>>> .r31
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< .mine
||||||| .r24
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
=======
import javax.persistence.OneToMany;
>>>>>>> .r31
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "evenement")
@Proxy(lazy = false)

public class Evenement extends GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evenementId", unique = true, nullable = false)
    private Long evenementId;
    
    @Column(name = "nomEvenement")
    private String nom;
    
     
     //@OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL, orphanRemoval = true)
     @OneToMany(mappedBy="evenement")
     private List<Client> clients ;

   /* @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "evenement")
    private List<Client> participants;*/

//    @Column(name = "pigeonGagant") // Je ne vois pas quelle relation à faire, On verra après
//    private Pigeon pigeonGagant;

    /*@Column(name = "classement")
	private TreeSet<Long> classement;
     */

    /**
     * @return the evenementId
     */
    public Long getEvenementId() {
        return evenementId;
    }

    /**
     * @param evenementId the evenementId to set
     */
    public void setEvenementId(Long evenementId) {
        this.evenementId = evenementId;
    }

 
//    /**
//     * @return the pigeonGagant
//     */
//    public Pigeon getPigeonGagant() {
//        return pigeonGagant;
//    }
//
//    /**
//     * @param pigeonGagant the pigeonGagant to set
//     */
//    public void setPigeonGagant(Pigeon pigeonGagant) {
//        this.pigeonGagant = pigeonGagant;
//    }

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
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

   
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    
}
