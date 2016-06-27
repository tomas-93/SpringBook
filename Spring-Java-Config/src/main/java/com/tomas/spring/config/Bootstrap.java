package com.tomas.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Tomas on 27/06/2016.
 */
public class Bootstrap implements WebApplicationInitializer
{

     @Override
     public void onStartup(ServletContext servletContext) throws ServletException
     {
          servletContext.getServletRegistration("default").addMapping("/resource/*");
          AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
          rootContext.register(RootContextConfiguration.class);
          servletContext.addListener(new ContextLoaderListener(rootContext));

          AnnotationConfigWebApplicationContext servletContextClass = new AnnotationConfigWebApplicationContext();
          servletContextClass.register(ServletContextConfiguration.class);
          ServletRegistration.Dynamic dispatcher = servletContext.addServlet("springDispatcher", new DispatcherServlet(servletContextClass));
          dispatcher.setLoadOnStartup(1);
          dispatcher.addMapping("/");

     }
}
