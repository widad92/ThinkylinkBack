/**
 * omniRestInitializer.java
 */
package com.omni.rest.config.mvc;

import com.omni.core.config.OmniDataSourceConfig;
import com.omni.core.config.OmniJpaConfig;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.rest.config.core.OmniRestConfig;
import com.omni.rest.config.security.OmniSecurityConfig;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class is {@link omniRestInitializer} config class.
 */
@Order(1)
public class OmniRestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{OmniRestConfig.class, OmniSecurityConfig.class, OmniJpaConfig.class, OmniDataSourceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{OmniRestWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }

    private static final String LOCATION = OmniCoreUtils.getValueFromPropertyCode("tempDirectory"); // Temporary location where files will be stored

    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size

    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part

    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
}
