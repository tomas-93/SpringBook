package com.tomas.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Tomas on 12/07/2016.
 */
@Controller
public class HelloWordController
{
     @ResponseBody
     @RequestMapping(value = "/", method = RequestMethod.GET)
     public View index()
     {
          return new RedirectView("/test/menu", true);
     }

     @ResponseBody
     @RequestMapping(value ="test/menu", method = RequestMethod.GET)
     public ModelAndView menu()
     {
         return new ModelAndView("test/menu");
     }

}
