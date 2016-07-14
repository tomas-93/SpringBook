package com.tomas.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tomas on 13/07/2016.
 */
@Controller
@RequestMapping("url1")
public class TestTwoController
{
     @ResponseBody
     @RequestMapping("url2")
     public String rutaUno()
     {
          return "Herencia de mapeo URL: \n@Controller\n" +
                  "@RequestMapping(\"url1\")\n" +
                  "public class TestTwoController\n" +
                  "{\n" +
                  "     @ResponseBody\n" +
                  "     @RequestMapping(\"url2\")\n" +
                  "     public String rutaUno()\n" +
                  "     {\n" +
                  "          return \"Herencia de mapeo: \"\n" +
                  "     }\n" +
                  "}";
     }
}
