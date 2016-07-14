package com.tomas.spring.controller;

import com.tomas.spring.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Tomas on 13/07/2016.
 */
@Controller
@RequestMapping("test")
public class TestFiveController
{
     @ResponseBody
     @RequestMapping(value = "form", method = RequestMethod.GET)
     public ModelAndView form()
     {
          return new ModelAndView("test/form", "UserForm", new UserForm());
     }
     @ResponseBody
     @RequestMapping(value = "form", method = RequestMethod.POST)
     public ModelAndView form(@Valid @ModelAttribute("UserForm") UserForm userForm, BindingResult bindingResult)
     {
          if (bindingResult.hasErrors())
          {
               return new ModelAndView("test/form");
          }
          ModelAndView modelAndView = new ModelAndView("test/form", "userForm", userForm);
          modelAndView.addObject("flagForm", true);
          return modelAndView;
     }

}
