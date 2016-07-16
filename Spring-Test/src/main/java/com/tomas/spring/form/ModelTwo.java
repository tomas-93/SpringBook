package com.tomas.spring.form;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Tomas on 16/07/2016.
 */
@XmlRootElement
public class ModelTwo
{
     private String nameList;
     private List<ModelOne> listModel;

     public String getNameList() {
          return nameList;
     }

     public void setNameList(String nameList) {
          this.nameList = nameList;
     }

     public List<ModelOne> getListModel() {
          return listModel;
     }

     public void setListModel(List<ModelOne> listModel) {
          this.listModel = listModel;
     }
}
