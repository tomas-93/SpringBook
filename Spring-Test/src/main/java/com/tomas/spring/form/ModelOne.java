package com.tomas.spring.form;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tomas on 16/07/2016.
 */
@XmlRootElement
public class ModelOne
{
     private String name,
                    number,
                    description;
     private Long id;

     public ModelOne() {
     }

     public ModelOne(String name, String number, String description, Long id) {
          this.name = name;
          this.number = number;
          this.description = description;
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getNumber() {
          return number;
     }

     public void setNumber(String number) {
          this.number = number;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }
}
