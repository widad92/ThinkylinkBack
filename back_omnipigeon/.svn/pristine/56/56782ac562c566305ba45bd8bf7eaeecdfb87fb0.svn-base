package com.omni.rest.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AnomalyDto {

    private HttpStatus http;
    private String error;

    public AnomalyDto(){
        
    };
    
    public AnomalyDto(String msg, HttpStatus http) {
        this.error = msg;
        this.http = http;
    }
}
