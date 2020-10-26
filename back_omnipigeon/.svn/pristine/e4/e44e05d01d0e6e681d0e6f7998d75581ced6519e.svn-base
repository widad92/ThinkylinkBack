/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omni.rest.dto;

import com.omni.rest.helpers.JsonDateDeserializer;
import com.omni.rest.helpers.JsonDateSerializer;
import com.omni.rest.view.OmniJsonView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public abstract class AbstractDto implements Serializable {

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonView({
//        omniJsonView.PrivateView.class
//    })
    private Date dateCreation;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonView({
//        omniJsonView.PrivateView.class
//    })
    private Date dateModification;
}
