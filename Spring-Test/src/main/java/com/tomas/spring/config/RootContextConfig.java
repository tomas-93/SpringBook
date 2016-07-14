package com.tomas.spring.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;

/**
 * Created by Tomas on 12/07/2016.
 */
@Configuration
@ComponentScan(
        basePackages = "com.tomas.spring",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfig
{
     @Bean
     public ObjectMapper objectMapper()
     {
          ObjectMapper mapper = new ObjectMapper();
          mapper.findAndRegisterModules();
          mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false );
          mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
          return mapper;
     }
     @Bean
     public Jaxb2Marshaller jaxb2Marshaller()
     {
          Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
          marshaller.setPackagesToScan(new String[]{ "com.tomas.spring" });
          return marshaller;
     }


}
