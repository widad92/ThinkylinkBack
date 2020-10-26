package com.omni.rest.config.core;

import com.omni.rest.config.security.OmniAuthenticationProvider;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OmniRestConfig {

    @Bean
    @Scope(value = "prototype")
    public Mapper modelMapper() {
        return new DozerBeanMapper();
    }

    @Bean
    public OmniAuthenticationProvider OmniAuthenticationProvider() {
        return new OmniAuthenticationProvider();
    }
}
