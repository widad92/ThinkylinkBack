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
@JsonIgnoreProperties({"acteurId"})
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ActeurDto extends AbstractDto {

    private String nom;

    private String prenom;

    private String profession;

    public ActeurDto() {
    }

}
