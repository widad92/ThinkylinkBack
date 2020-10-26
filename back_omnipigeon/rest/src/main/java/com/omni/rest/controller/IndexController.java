/**
 * IndexController.java
 */
package com.omni.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is {@link IndexController} used to create REST index page
 * services.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
}
