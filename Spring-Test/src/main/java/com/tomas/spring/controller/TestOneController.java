package com.tomas.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tomas on 13/07/2016.
 */
@Controller
public class TestOneController
{

     @ResponseBody
     @RequestMapping("view")
     public String view()
     {
          return "Vista, ruta especificada en forma implicita" +
                  "\n@ResponseBody\n" +
                  "     @RequestMapping(\"view\")\n" +
                  "     public String view()\n" +
                  "     {\n" +
                  "          return \"Vista, ruta especificada en forma implicita\";\n" +
                  "     }";
     }

     @ResponseBody
     @RequestMapping(value="add", method = RequestMethod.GET)
     public String add()
     {
          return "add, ruta especificada en forma implicita" +
                  "\n @ResponseBody\n" +
                  "     @RequestMapping(value=\"add\", method = RequestMethod.GET)\n" +
                  "     public String add()\n" +
                  "     {\n" +
                  "          return \"add, ruta especificada en forma implicita\";\n" +
                  "     }";
     }

}
