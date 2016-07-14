package com.tomas.spring.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Tomas on 13/07/2016.
 */
public class UserForm
{
     @NotNull
     @NotEmpty
     @Valid
     @Size(min=4, max=30)
     private String name, surName, school;
     @NotNull
     @Min(18)
     @Max(30)
     @Valid
     private Integer age;

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSurName() {
          return surName;
     }

     public void setSurName(String surName) {
          this.surName = surName;
     }

     public String getSchool() {
          return school;
     }

     public void setSchool(String school) {
          this.school = school;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }
}
