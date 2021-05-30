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
    private Career careerID;
    
    public Course(String id, String name, int credtis,Career careerID ) {
        this.id = id;
        this.name = name;
        this.credtis = credtis;
        this.careerID=careerID;
    }

    public Course(Course course) {
     this.id=course.id;
     this.credtis=course.credtis;
     this.name=course.name;
     this.careerID=course.careerID;
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

    public String getCareerID() {
        return careerID.getDescription();
    }

    public void setCareerID(Career careerID) {
        this.careerID = careerID;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", credtis=" + credtis + ", careerID=" + careerID + '}';
    }

   
   
    
}
