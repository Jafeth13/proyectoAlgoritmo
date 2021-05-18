/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Matamoros Cordero
 */
public class Course {
    private String id;
    private String name;
    private int credtis;
    private int careerID;
    
    public Course(String id, String name, int credtis,int careerID ) {
        this.id = id;
        this.name = name;
        this.credtis = credtis;
        this.careerID=careerID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredtis() {
        return credtis;
    }

    public void setCredtis(int credtis) {
        this.credtis = credtis;
    }

    public int getCareerID() {
        return careerID;
    }

    public void setCareerID(int careerID) {
        this.careerID = careerID;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", credtis=" + credtis + ", careerID=" + careerID + '}';
    }

   
   
    
}
