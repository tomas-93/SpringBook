package com.tomas.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Created by Tomas on 27/06/2016.
 */
@Configuration
@ComponentScan(
        basePackages = "com.tomas.spring",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguration {
}
