package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProduitDto {

    private Long produitId;
    private String libelleProduit;
    private String description;
    public ProduitDto() {
    }

}
