package com.tomas.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Tomas on 12/07/2016.
 */
@SuppressWarnings("unused")
public class Bosststrap implements WebApplicationInitializer
{


     @Override
     public void onStartup(ServletContext servletConteinerContext) throws ServletException
     {
          servletConteinerContext.getServletRegistration("default").addMapping("/resource/*");
          AnnotationConfigWebApplicationContext rootContext
                  = new AnnotationConfigWebApplicationContext();
          rootContext.register(RootContextConfig.class);
          servletConteinerContext.addListener(new ContextLoaderListener(rootContext));

          AnnotationConfigWebApplicationContext servletContext
                  = new AnnotationConfigWebApplicationContext();
          servletContext.register(ServletContextConfig.class);
          ServletRegistration.Dynamic dispatcher =
                  servletConteinerContext.addServlet(
                          "SpringDispatcher", new DispatcherServlet(servletContext));
          dispatcher.setLoadOnStartup(1);
          dispatcher.setMultipartConfig(
                  new MultipartConfigElement(null, 20_971_520L, 41_943_040L, 512_000));
          dispatcher.addMapping("/");

     }
}
