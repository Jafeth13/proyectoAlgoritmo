/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import proyecto.FXMLDeEnrollmentController;
import proyecto.FXMLEnrollmentController;

/**
 *
 * @author Matamoros Cordero
 */
public class DeEnrollment {
    private int id;
    private Date date;
    private Student studentID;
    private Course courseID;
    private String schedule;
    private String remark;

    public DeEnrollment(int id, Date date, Student studentID,Course courseID,  String schedule,String remark) {
    this.courseID=courseID;
    this.date=date;
    this.id=id;
    this.schedule=schedule;
    this.studentID=studentID;
    this.remark=remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    FXMLEnrollmentController l=new FXMLEnrollmentController();
    @Override
    public String toString() {
        if(l.a==0){
        return "DeEnrollment{" + "id = " + id + ", studentID =" + studentID + ", courseID=" + courseID + ", schedule=" + schedule + ", remark=" + remark + '}';
        }
        if(l.a==3){
            return schedule;
        }if(l.a==2){
            return studentID.toString();
        }
        if(l.a==1){
            return courseID.toString();
        }
        
        return null;
    
    }
    
}
