/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Matamoros Cordero
 */
public class Enrollment {
    public  int id;
    private Date date;
    private Student studentID;
    private Course courseID;
    private String schedule;
    
    public Enrollment(int id, Date date, Student studentID,Course courseID,  String schedule) {
    this.courseID=courseID;
    this.date=date;
    this.id=id;
    this.schedule=schedule;
    this.studentID=studentID;
    }

    public Enrollment(Enrollment enrollment) {
      this.courseID=enrollment.courseID;
        this.schedule=enrollment.schedule;
        this.id=enrollment.id;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "id=" + id + ", date=" + date + ", studentID=" + studentID + ", courseID=" + courseID + ", schedule=" + schedule + '}';
    }
    
    
    
}
