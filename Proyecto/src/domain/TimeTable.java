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
public class TimeTable {
    private Course courseID;
    private String period;
    private String schedule1;
    private String schedule2;
    
    public TimeTable(Course courseID,String period, String schedule1,String schedule2 ) {
        
        this.courseID=courseID;
        this.period=period;
        this.schedule1=schedule1;
        this.schedule2=schedule2;
        
    }

    public TimeTable(TimeTable timeTable) {
        this.courseID=timeTable.courseID;
        this.period=timeTable.period;
        this.schedule1=timeTable.schedule1;
        this.schedule2=timeTable.schedule2;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCourseID() {
        return courseID.getName();
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }

    public String getSchedule1() {
        return schedule1;
    }

    public void setSchedule1(String schedule1) {
        this.schedule1 = schedule1;
    }

    public String getSchedule2() {
        return schedule2;
    }

    public void setSchedule2(String schedule2) {
        this.schedule2 = schedule2;
    }

    @Override
    public String toString() {
        return "TimeTable{" + "courseID=" + courseID + ", period=" + period + ", schedule1=" + schedule1 + ", schedule2=" + schedule2 + '}';
    }

   
}
