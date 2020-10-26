package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientDto extends AbstractDto {

    private static final long serialVersionUID = 1L;

    private Long clientId;

    private String nom;

    private String civilite;

    private String prenom;
    private String tel;

    private UserDto user;

	    
}
