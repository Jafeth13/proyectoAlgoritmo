/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import proyecto.FXMLCareers1Controller;

/**
 *
 * @author Matamoros Cordero
 */
public class Career {
    private int id;
    private String description;
    
    public Career(int id,String description) {
    this.id=id;    
    this.description=description;
    }

    public Career(Career career) {
        this.id=career.id;
        this.description=career.description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    FXMLCareers1Controller o=new FXMLCareers1Controller();
    @Override
    public String toString() {
        if(o.ty==0){
          return "Career{" + " id = " + id + ", description =" + description + '}';
        }
        if(o.ty==2){
            return description;
        }
        return null;
    }
    
    
}
