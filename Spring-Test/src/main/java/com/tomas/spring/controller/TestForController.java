package com.tomas.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tomas on 13/07/2016.
 */
@Controller
public class TestForController
{
     @ResponseBody
     @RequestMapping(value = "var-test4")
     public String varTest4(@RequestParam("var") String var)
     {
          return "value: " +var + "<br>@ResponseBody<br>" +
                  "     @RequestMapping(value = \"test4\")<br>" +
                  "     public String test4(@RequestParam(\"var\") String var)<br>" +
                  "     {<br>" +
                  "          return \"value: \" +var;<br>" +
                  "     }";
     }
     @ResponseBody
     @RequestMapping("option-test4")
     public String optionTest4(@RequestParam(value = "var", required = false) String var)
     {
          return "Valor opcional: " +var + "<br>@ResponseBody<br>" +
                  "     @RequestMapping(\"option-test4\")<br>" +
                  "     public String optionTest4(@RequestParam(value = \"var\", required = false) String var)<br>" +
                  "     {<br>" +
                  "          return \"Valor opcional: \" +var;<br>" +
                  "     }";
     }
     @ResponseBody
     @RequestMapping("force-test4")
     public String forceTest4(@RequestParam(value = "var", required = true) String var)
     {
          return "Valor force " + var + " si el parametro no existe, simplemente no se muestra esta pagina" +
                  " manda un error 404 <br>@ResponseBody<br>" +
                  "     @RequestMapping(\"force-test4\")<br>" +
                  "     public String fotceTest4(@RequestParam(value = \"var\", required = true) String var)<br>" +
                  "     {<br>" +
                  "          return \"Valor force \" + var <br>" +
                  "     }";
     }
     @ResponseBody
     @RequestMapping("default-test4")
     public String defaultTest(@RequestParam(value="var", defaultValue = "default value: Hola mundo xD") String var)
     {
          return var + "<br>@ResponseBody<br>" +
                  "     @RequestMapping(\"default-test4\")<br>" +
                  "     public String defaultTest(@RequestParam(value=\"var\", defaultValue = \"default value: Hola mundo xD\") String var)<br>" +
                  "     {<br>" +
                  "          return var ;<br>" +
                  "     }";
     }
     @ResponseBody
     @RequestMapping("head-test4")
     public String headTest(@RequestHeader MultiValueMap<String, String> valueMap)
     {
          String var = "Headers: ";
          for(String key: valueMap.keySet())
          {
               var +="<br>Key:" + key + " <br>Value: ";
               for (String value: valueMap.get(key))
               {
                    var += value;
               }

          }
          return var;
     }
     @ResponseBody
     @RequestMapping(value = "user/name/{name}/age/{age}", method = RequestMethod.GET)
     public String pathTest(@PathVariable("name") String name,
                            @PathVariable("age") int age)
     {
          return "Nombre: " + name + " Edad: " + age;
     }

     @ResponseBody
     @RequestMapping(value = "user/{id}/end", method = RequestMethod.GET)
     public String routeParameters(@PathVariable("id") int id,
                                   @MatrixVariable int floor,
                                   @MatrixVariable int room)
     {
          return "ID: " + id + " floor: " + floor + " room " + room;
     }

}
