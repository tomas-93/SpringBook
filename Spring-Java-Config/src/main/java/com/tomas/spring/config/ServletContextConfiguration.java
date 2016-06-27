package com.tomas.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Tomas on 27/06/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "com.tomas.spring",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class))
public class ServletContextConfiguration {
}
