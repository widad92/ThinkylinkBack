/**
 * omniRestWebConfig.java
 */
package com.omni.rest.config.mvc;

import com.omni.rest.utils.OmniRestConstants;
import com.omni.core.schedule.Scheduler;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is {@link omniRestWebConfig} config class.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.omni.rest", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Scheduler.class)
})
@EnableJdbcHttpSession
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({OmniRestTemplateConfig.class})
public class OmniRestWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
//                .allowedOrigins("https://omnipigeon.fr", "https://www.omnipigeon.fr", "https://Omni.com", "https://www.Omni.com", "https://localhost:4200", "http://localhost:4200", "https://recette.omnipigeon.fr", "https://pp.omnipigeon.fr")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders(OmniRestConstants.X_FRAME_OPTIONS, OmniRestConstants.X_AUTH_TOKEN);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("OmniServlet");
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
