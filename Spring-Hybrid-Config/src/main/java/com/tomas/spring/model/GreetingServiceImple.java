package com.tomas.spring.model;

import org.springframework.stereotype.Service;

/**
 * Created by Tomas on 27/06/2016.
 */
@Service
public class GreetingServiceImple implements GreetingService
{
     @Override
     public String getGreeting(String name)
     {
          return "Hola :) " + name;
     }
}
