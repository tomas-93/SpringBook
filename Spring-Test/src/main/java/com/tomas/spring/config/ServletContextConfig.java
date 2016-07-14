package com.tomas.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tomas on 12/07/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = "com.tomas.spring",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Controller.class)
)
public class ServletContextConfig extends WebMvcConfigurerAdapter
{
     @Inject
     ObjectMapper objectMapper;
     @Inject
     Marshaller marshaller;
     @Inject
     Unmarshaller unmarshaller;


     @Override
     public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
     {
          converters.add(new ByteArrayHttpMessageConverter());
          converters.add(new StringHttpMessageConverter());
          converters.add(new FormHttpMessageConverter());
          converters.add(new SourceHttpMessageConverter<>());

          MappingJackson2HttpMessageConverter jsonConverter =
                  new MappingJackson2HttpMessageConverter();
          jsonConverter.setSupportedMediaTypes(Arrays.asList(
                  new MediaType("application", "json"),
                  new MediaType("text", "json")
          ));
          jsonConverter.setObjectMapper(this.objectMapper);
          converters.add(jsonConverter);

          MarshallingHttpMessageConverter xmlConverters = new MarshallingHttpMessageConverter();
          xmlConverters.setSupportedMediaTypes(Arrays.asList(
                  new MediaType("application", "xml"),
                  new MediaType("text", "xml")));
          xmlConverters.setMarshaller(this.marshaller);
          xmlConverters.setUnmarshaller(this.unmarshaller);
          converters.add(xmlConverters);
     }
     @Override
     public void configureContentNegotiation(
             ContentNegotiationConfigurer configurer)
     {
          //Configuracion los tipo de peticiones, ya sea por xml o json
          configurer.favorPathExtension(true).favorParameter(false)
                  .parameterName("mediaType").ignoreAcceptHeader(false)
                  .useJaf(false).defaultContentType(MediaType.APPLICATION_XML)
                  .mediaType("xml", MediaType.APPLICATION_XML)
                  .mediaType("json", MediaType.APPLICATION_JSON);
     }

     @Bean
     public ViewResolver viewResolver()
     {
          //Configuracion de donde se encuentran los archivos estaticos. y el uso forwards
          //del modelo hacia la vista
          InternalResourceViewResolver resolver =
                  new InternalResourceViewResolver();
          resolver.setViewClass(JstlView.class);
          resolver.setPrefix("/WEB-INF/jsp/view/");
          resolver.setSuffix(".jsp");
          return resolver;
     }
     /*
          View name translator ayuda en la simplificacion
          de la URL en el request al -> nobre de la vita
          http://localhost:8080/gamecast/display.html » display
          http://localhost:8080/gamecast/displayShoppingCart.html » displayShoppingCart
          http://localhost:8080/gamecast/admin/index.html » admin/index
      */
     @Bean
     public RequestToViewNameTranslator viewNameTranslator()
     {
          return new DefaultRequestToViewNameTranslator();
     }
     /*
          Una interfaz de estrategia para la resolución de carga de archivos de varias partes de
          conformidad con el RFC 1867 . Implementaciones son típicamente utilizable tanto dentro
          de un contexto de aplicación y autónomo.

          Hay dos implementaciones concretas incluidas en la primavera, a partir de la primavera 3,1:
               *CommonsMultipartResolver para Apache Commons FileUpload
               *StandardServletMultipartResolver para el Servlet API 3.0 + Parte
      */
     @Bean
     public MultipartResolver multipartResolver()
     {
          return new StandardServletMultipartResolver();
     }

}
