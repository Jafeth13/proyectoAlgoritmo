/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.CircularDoublyLinkedList;
import domain.Course;
import domain.Enrollment;
import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLCourseController.listp;
import static proyecto.FXMLSchedulesController.listH;
import static proyecto.FXMLStudents1Controller.list2;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLEnrollmentController implements Initializable {
  public static CircularDoublyLinkedList listEnro=new CircularDoublyLinkedList();
    @FXML
    private Label txtMessage;
    @FXML
    private Label lbUCR;
    @FXML
    private ComboBox<String> cbxEnrollmentCourses;
    @FXML
    private ComboBox<String> cbxSchedules;
    @FXML
    private Label txtError;
    @FXML
    private Label txtStudent;
    @FXML
    private Button btnConfirm;
    @FXML
    public TableView<Student> TVStu;
    @FXML
    public TableColumn<Student, Integer> tcIDM;
    @FXML
    public TableColumn<Student, String> tcCE;
    @FXML
    public TableColumn<Student, String> tcAE;
    @FXML
    public TableColumn<Student, String> tcNE;
 
    
    /**
     * Initializes the controller class.
     */
    FXMLStudents1Controller o=new FXMLStudents1Controller();
        FXMLCourseController tp=new FXMLCourseController();
    @FXML
    private ComboBox<String> cbxEstudiantes;
    public static int s;
    @FXML
    private ComboBox<String> cbxSchedules2;
    @FXML
    private TextField numMatricula;
    @FXML
    private Label txtStudent1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numMatricula.setText(Integer.toString(Enrollment.id));
         try {
             
            if(!listH.isEmpty()){
            tp.ty=3;
            for (int i = 1; i <= listH.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + listH.getNode(i).data);
                cbxSchedules2.getItems().addAll((""+listH.getNode(i).data));
            }}else{
                cbxSchedules2.getItems().add("No hay horarios registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
          try {
             
            if(!list2.isEmpty()){
            s=2;
            for (int i = 1; i <= list2.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + list2.getNode(i).data);
                cbxEstudiantes.getItems().addAll((""+list2.getNode(i).data));
            }}else{
                cbxEstudiantes.getItems().add("No hay estudiantes registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        try {             
            if(!listp.isEmpty()){
            tp.ty=2;
            for (int i = 1; i <= listp.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + listp.getNode(i).data);
                cbxEnrollmentCourses.getItems().addAll((""+listp.getNode(i).data));
            }}else{
                cbxEnrollmentCourses.getItems().add("No hay cursos registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      try {
             
            if(!listH.isEmpty()){
            tp.ty=2;
            for (int i = 1; i <= listH.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + listH.getNode(i).data);
                cbxSchedules.getItems().addAll((""+listH.getNode(i).data));
            }}else{
                cbxSchedules.getItems().add("No hay horarios registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       if (list2.isEmpty()) {
        s=2;
        } else {
            try {
                Student r = new Student((Student) list2.getNode(1).getData());
                for (int j = 0; j <= TVStu.getItems().size(); j++) {
                    this.TVStu.getItems().clear();
                }
                for (int i = 1; i <= list2.size(); i++) {
                    r = new Student((Student) list2.getNode(i).getData());
                    this.TVStu.getItems().add(r);
                    this.tcIDM.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcCE.setCellValueFactory(new PropertyValueFactory<>("studentID"));
                    this.tcNE.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                    this.tcAE.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                }
                 this.TVStu.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }   
    }
  private Date y;
  private String opcion;
  
 private int f;
    @FXML
    private void Confirm(ActionEvent event) throws ListException, IOException {
        
       f=Integer.parseInt(numMatricula.getText()); 
         if(cbxSchedules.getValue()!=null){
             Enrollment.id+=1;
        numMatricula.setText(Integer.toString(Enrollment.id));
            opcion=cbxSchedules.getValue(); 
           listEnro.add(new Enrollment(f, y, new Student(s,cbxEstudiantes.getValue() , "", "", y, "", "", "", new Career(s, "")),
               new Course("", cbxEnrollmentCourses.getValue(), s, new Career(s, "")),(opcion)));
       util.Utility.file(listEnro, "MATRICULA");
        }
        if(cbxSchedules2.getValue()!=null){
            Enrollment.id+=1;
        numMatricula.setText(Integer.toString(Enrollment.id));
            opcion=cbxSchedules2.getValue();
            listEnro.add(new Enrollment(f, y, new Student(s,cbxEstudiantes.getValue() , "", "", y, "", "", "", new Career(s, "")),
               new Course("", cbxEnrollmentCourses.getValue(), s, new Career(s, "")),(opcion)));
       util.Utility.file(listEnro, "MATRICULA");
        }
        if(cbxSchedules.getValue()!=null&&cbxSchedules2.getValue()!=null){
            
        }
      
      
    }
    
}
