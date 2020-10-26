package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CouleurDto {

    private Long couleurId;
    private String codeCouleur;
    private String libelleCouleur ;
    private String isPigeon;
    private String isYeux;
    private String isBague;
    public CouleurDto() {
    }

}
