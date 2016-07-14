package com.tomas.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tomas on 13/07/2016.
 */
@Controller
@RequestMapping(value = "ruta1", method = {RequestMethod.GET, RequestMethod.POST})
public class TestThreeController
{
     @ResponseBody
     @RequestMapping(value = "ruta2", method = RequestMethod.GET)
     public String ruta2()
     {
          return "Restricciones Http: \n@Controller\n" +
                  "@RequestMapping(value = \"ruta1\", method = {RequestMethod.GET, RequestMethod.POST})\n" +
                  "public class TestThreeController\n" +
                  "{\n" +
                  "     @ResponseBody\n" +
                  "     @RequestMapping(value = \"ruta2\", method = RequestMethod.GET)\n" +
                  "     public String ruta2()\n" +
                  "     {\n" +
                  "          return \"Restricciones Http: \\n\";\n" +
                  "     }\n" +
                  "     \n" +
                  "     @ResponseBody\n" +
                  "     @RequestMapping(value = \"ruta3\", method = RequestMethod.POST)\n" +
                  "     public String ruta3()\n" +
                  "     {\n" +
                  "          return \"\";\n" +
                  "     }\n" +
                  "}";
     }

     @ResponseBody
     @RequestMapping(value = "ruta3", method = RequestMethod.POST)
     public String ruta3()
     {
          return "";
     }
}
