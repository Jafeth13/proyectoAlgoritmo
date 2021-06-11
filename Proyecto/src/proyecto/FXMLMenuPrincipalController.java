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
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import static proyecto.FXMLDeEnrollmentController.listDE;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLMenuPrincipalController implements Initializable {
Alert alert = new Alert(Alert.AlertType.INFORMATION);
Alert alert1 = new Alert(Alert.AlertType.ERROR);
    @FXML
    private BorderPane bp;
    @FXML
    private MenuItem btnAddCareer;
    @FXML
    private MenuItem btnAddStudent;
    @FXML
    private MenuItem btnAddCourse;
    @FXML
    public MenuItem btnNewEnrollment;
    @FXML
    public MenuItem btnDeenrollment;
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
    public Menu MenuCareer;
    @FXML
    public Menu MenuStudent;
    @FXML
    public Menu MenuCourses;
    @FXML
    public Menu MenuSchedules;
    @FXML
    public Menu MenuReports;
    @FXML
    public  Menu MenuEnroll;
    public static int AllowEnroll;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private AnchorPane AnchorPanePrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPanePrincipal.setVisible(true);
        if(FXMLSecurityController.Type==2){
        MenuCareer.setVisible(false); MenuStudent.setVisible(false);MenuEnroll.setVisible(false);
        MenuCourses.setVisible(false);MenuSchedules.setVisible(false); MenuReports.setVisible(true);
        if(FXMLSecurityController.Type==1){
        MenuCareer.setVisible(true); MenuStudent.setVisible(false); MenuEnroll.setVisible(false);
        MenuCourses.setVisible(false);MenuSchedules.setVisible(false); MenuReports.setVisible(false);
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
        try{
        alert.setHeaderText(null);
                 alert.setTitle("Información");
                    alert.setContentText("Se ha generado su reporte en un archivo PDF...");
                    alert.showAndWait(); 
      if(FXMLSecurityController.Type==1){  
       FXMLEnrollmentController list = new FXMLEnrollmentController();
       
                 list.a=0;
       util.Utility.exportToPDF(list.listEnro,"Reporte de Matrícula.pdf");
      }
      if(FXMLSecurityController.Type==2){
      FXMLEnrollmentController list = new FXMLEnrollmentController();
       
                 list.a=0;      
       util.Utility.exportToPDF("Número de matricula:"+list.id+"\n Estudiante: "+list.estudiante+" \n Curso: "+list.curso.toString()+"\n Horaio: "+list.horario,"Reporte de Matrícula Estudiante.pdf");
      
      }}catch(Exception e){
      alert1.setHeaderText(null);
                 alert1.setTitle("Información");
                    alert1.setContentText("Ha ocurrido un error, es probable que la lista se encuentre vacía...");
                    alert1.showAndWait();
      }  
    }

    @FXML
    private void Clean(ActionEvent event) {
        this.loadpage("FXMLMenuPrincipal");
    }

    @FXML
    private void LogOut(ActionEvent event) {
        AnchorPanePrincipal.setVisible(false);
        this.loadpage("FXMLSecurity");
    }

    @FXML
    private void DeenrollmentReport(ActionEvent event) {
        try{
        if(FXMLSecurityController.Type==1){ 
         alert.setHeaderText(null);
                 alert.setTitle("Información");
                    alert.setContentText("Se ha generado su reporte en un archivo PDF...");
                    alert.showAndWait(); 
     FXMLDeEnrollmentController l=new FXMLDeEnrollmentController();
                  l.b=0;
       util.Utility.exportToPDF(l.listDE,"Reporte de Retiro de cursos.pdf");
        }  
       if(FXMLSecurityController.Type==2){
      FXMLDeEnrollmentController list = new FXMLDeEnrollmentController();
       
                 list.b=0;      
       util.Utility.exportToPDF("Número de matricula:"+list.id2+"\n Estudiante: "+list.estudiante2+" \n Curso: "+list.curso2.toString()+"\n Horaio: "+list.horario2,"Reporte de Retiro Estudiante.pdf");
      alert.setHeaderText(null);
                 alert.setTitle("Información");
                    alert.setContentText("Se ha generado su reporte en un archivo PDF...");
                    alert.showAndWait(); 
      }}catch(Exception e){
      alert1.setHeaderText(null);
                 alert1.setTitle("Información");
                    alert1.setContentText("Ha ocurrido un error, es probable que la lista se encuentre vacía...");
                    alert1.showAndWait();
      } 
    }
}
