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
public class Student {
    public int id;
    private String studentID;
    private String lastname;
    private String firstname;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String address;
    private Career careerID;
    
    public Student(int id, String studentID, String lastname, String firstname,Date birthday,String phoneNumber,String email,String address,Career careerID) {
        this.id = id;
        this.studentID = studentID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday=birthday;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.address=address;
        this.careerID=careerID;
    }

    public Student(Student student) {
        this.id=student.id;
        this.studentID=student.studentID;
        this.firstname=student.firstname;
        this.lastname=student.lastname;
        this.phoneNumber=student.phoneNumber;
        this.email=student.email;
        this.address=student.address;
        this.careerID=student.careerID;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Career getCareerID() {
        return careerID;
    }

    public void setCareerID(Career careerID) {
        this.careerID = careerID;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentID=" + studentID + ", lastname=" + lastname + ", firstname=" + firstname + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", careerID=" + careerID + '}';
    }
    

    


    
    
}
