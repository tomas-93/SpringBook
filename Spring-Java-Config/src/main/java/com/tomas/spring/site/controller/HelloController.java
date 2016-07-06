package com.tomas.spring.site.controller;

import com.tomas.spring.model.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tomas on 27/06/2016.
 */
@Controller
public class HelloController
{
     private GreetingService greetingService;

     @ResponseBody
     @RequestMapping("/")
     public String helloWord()
     {
          return "Hola mundo";
     }

     @ResponseBody
     @RequestMapping(value = "/saluda", params = "name")
     public String helloName(@RequestParam("name") String name)
     {
          return greetingService.getGreeting(name);
     }

     @Autowired
     public void setGreetingService(GreetingService greetingService)
     {
          this.greetingService = greetingService;
     }
}
