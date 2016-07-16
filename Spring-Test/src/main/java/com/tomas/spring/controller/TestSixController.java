package com.tomas.spring.controller;

import com.tomas.spring.form.ModelOne;
import com.tomas.spring.form.ModelTwo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas on 14/07/2016.
 */
@Controller
@RequestMapping("services")
public class TestSixController
{
     @ResponseBody
     @RequestMapping(value = "model/one/{id}", method = RequestMethod.GET)
     private ModelOne viewModelOne(@PathVariable("id") long id)
     {
          ModelOne modelOne = new ModelOne();
          modelOne.setId(id);
          modelOne.setName("Tomas");
          modelOne.setDescription("Hola mundo");
          modelOne.setNumber("921-146-85-21");
          return modelOne;
     }
     @ResponseBody
     @RequestMapping(value = "model/two/{name}", method = RequestMethod.GET)
     private ModelTwo viewModelTwon(@PathVariable("name") String name)
     {
          ModelTwo modelTwo = new ModelTwo();
          List<ModelOne> modelOneList = new ArrayList<>();
          modelOneList.add(new ModelOne("Tomas", "1", "Hola Tomas", 1L));
          modelOneList.add(new ModelOne("Yussef", "2", "Hola Yussef", 2L));
          modelOneList.add(new ModelOne("Carlos", "3", "Hola Carlos", 3L));
          modelOneList.add(new ModelOne("keny", "4", "Hola keny", 4L));
          modelOneList.add(new ModelOne("Maria", "5", "Hola Maria", 5L));
          modelOneList.add(new ModelOne("Lucy", "6", "Hola Lucy", 6L));
          modelOneList.add(new ModelOne("Karla", "7", "Hola Karla", 7L));
          modelOneList.add(new ModelOne("Laura", "8", "Hola Laura", 8L));
          modelTwo.setNameList(name);
          modelTwo.setListModel(modelOneList);

          return modelTwo;
     }
}
