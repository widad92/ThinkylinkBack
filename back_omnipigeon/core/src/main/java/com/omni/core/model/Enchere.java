/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.core.model;
import java.io.Serializable;
import java.util.Date;
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
import org.hibernate.annotations.Proxy;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "enchere")
@Proxy(lazy = false)

public class Enchere extends AbstractTimestampEntity implements Serializable{
   
   	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enchereId", unique = true, nullable = false)
    private Long enchereId;	
	
	@Column(name = "dateDebut")
	private Date dateDebut;
	
	@Column(name = "datefin")
	private Date datefin;
        
        
        
        
	
        /*
	//@OneToMany(mappedBy="anchers")
	//@Column(name = "participants")
	private List<Client> participants;
	
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        //@JoinColumn(name = "achteurFId", referencedColumnName = "clientId")
	private Client achteurFinal;*/
	
	@Column(name = "prixMax")
	private long prixMax;
        
        /* @OneToMany(mappedBy="enchere")
         private List<Pigeon> pigeons ;*/
	

	public Enchere() {
		super();
	}

    /**
     * @return the anchersId
     */
    public Long getEnchersId() {
        return enchereId;
    }

    /**
     * @param anchersId the anchersId to set
     */
    public void setEnchersId(Long anchersId) {
        this.enchereId = anchersId;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the datefin
     */
    public Date getDatefin() {
        return datefin;
    }

    /**
     * @param datefin the datefin to set
     */
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    /**
     * @return the prixMax
     */
    public long getPrixMax() {
        return prixMax;
    }

    /**
     * @param prixMax the prixMax to set
     */
    public void setPrixMax(long prixMax) {
        this.prixMax = prixMax;
    }

   
  
        
        

}
