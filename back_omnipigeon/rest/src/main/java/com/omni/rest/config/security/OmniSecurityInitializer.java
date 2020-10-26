/*
 *  omniHttpInitializer.java
 */
package com.omni.rest.config.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class is {@link omniHttpInitializer} omni config class.
 */
@Order(3)
public class OmniSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
