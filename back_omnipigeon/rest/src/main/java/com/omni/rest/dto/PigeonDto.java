/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.omni.core.model.Couleur;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author asus
 */
@Data
@JsonIgnoreProperties({"pigeonId"})
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PigeonDto extends AbstractDto {

    private Long pigeonId;

    private String pigeonName;

    private String NumeroSerie;

    private String LieuNaissance;

    private Date dateNaissance;

    private CouleurDto couleurPigeon;

    private CouleurDto couleurYeux;

    private CouleurDto couleurBague;

    private ClientDto client;

    private String sexe;

    private Long idPere;

    private Long idMere;

    private String disciplines;

    //  private Acteur acteur;
    public PigeonDto() {
    }

}
