/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author asus
 */
@Data
@JsonIgnoreProperties({"stationId"})
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StationDto  extends AbstractDto{
    
    
        private Long stationId;	

	private AdresseDto adresse;
	
	private String responsable;
	
	private long tel;
	
	//private List<Pigeon> pigeons;
	
	//private List<Acteur> soigneurs;
	
	//private List<Acteur> eleveurs;

	
        public StationDto() {
           }
    
}