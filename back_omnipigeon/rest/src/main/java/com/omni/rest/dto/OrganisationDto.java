package com.omni.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrganisationDto extends AbstractDto {

    private Long organisationId;

    private String denomination;

    private String nom;

    private String prenom;

    private String tel;

    private String siret;

    private String responsable;

    private Date dateCreation;

    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String aliasOrganisation;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean flagOrganisation;

    private UserDto user;

    public OrganisationDto() {
    }

}
