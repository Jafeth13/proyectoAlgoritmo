/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.SinglyLinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private MenuItem btnAddCareer;
    @FXML
    private MenuItem btnAddStudent;
    @FXML
    private MenuItem btnAddCourse;
    @FXML
    private MenuItem btnNewEnrollment;
    @FXML
    private MenuItem btnDeenrollment;
    @FXML
    private MenuItem btnEnrollmentReport;
    @FXML
    private MenuItem btnDeenrollmentReport;
    @FXML
    private MenuItem btnClean;
    @FXML
    private MenuItem btnLogOut;
    @FXML
    private MenuItem btnSchedule;
    @FXML
    private Menu MenuCareer;
    @FXML
    private Menu MenuStudent;
    @FXML
    private Menu MenuCourses;
    @FXML
    private Menu MenuSchedules;
    @FXML
    private Menu MenuReports;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(FXMLSecurityController.Type==2){
        MenuCareer.setVisible(false); MenuStudent.setVisible(false);
        MenuCourses.setVisible(false);MenuSchedules.setVisible(false); MenuReports.setVisible(false);
        if(FXMLSecurityController.Type==1){
        MenuCareer.setVisible(true); MenuStudent.setVisible(true);
        MenuCourses.setVisible(true);MenuSchedules.setVisible(true); MenuReports.setVisible(true);
        }
    }}    
    private void loadpage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bp.setCenter(root);
    }

    @FXML
    private void AddCareer(ActionEvent event) {
        this.loadpage("FXMLCareers1");
    }

    private void ModifyCareer(ActionEvent event) {
        this.loadpage("FXMLCareers1");
    }

    private void DeleteCareer(ActionEvent event) {
        this.loadpage("FXMLCareers1");
    }

    private void ShowCareers(ActionEvent event) {
        this.loadpage("FXMLCareers1");
    }

    @FXML
    private void AddStudent(ActionEvent event) {
        this.loadpage("FXMLStudents1");
    }

    private void ModifyStudent(ActionEvent event) {
        this.loadpage("FXMLStudents1");
    }

    private void DeleteStudent(ActionEvent event) {
        this.loadpage("FXMLStudents1");
    }

    private void ShowStudents(ActionEvent event) {
        this.loadpage("FXMLStudents1");
    }

    @FXML
    private void AddCourse(ActionEvent event) {
        this.loadpage("FXMLCourse");
    }


    @FXML
    private void Schedule(ActionEvent event) {
         this.loadpage("FXMLSchedules");
    }

    @FXML
    private void NewEnrollment(ActionEvent event) {
        this.loadpage("FXMLEnrollment");
    }

    @FXML
    private void Deenrollment(ActionEvent event) {
        this.loadpage("FXMLDeEnrollment");
    }

    @FXML
    private void EnrollmentReport(ActionEvent event) {
        
       FXMLEnrollmentController list = new FXMLEnrollmentController();
      
       util.Utility.exportToPDF(list.listEnro,"Reporte de Matrícula.pdf");
    }

    @FXML
    private void Clean(ActionEvent event) {
        this.loadpage("FXMLMenuPrincipal");
    }

    @FXML
    private void LogOut(ActionEvent event) {
        this.loadpage("FXMLSecurity");
    }

    @FXML
    private void DeenrollmentReport(ActionEvent event) {
    SinglyLinkedList list = new SinglyLinkedList();
         list.add(new Career(1, "INGENIERIA ESPACIAL"));
          list.add(new Career(2, "INFORMATICA EMPRESARIAL"));
        list.add(new Career(3, "ENSEÑANZA DEL INGLES"));
      
       util.Utility.exportToPDF(list.toString(),"Reporte de Retiro de cursos.pdf");
    }
}
