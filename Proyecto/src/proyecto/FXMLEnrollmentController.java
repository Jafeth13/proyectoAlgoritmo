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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javax.management.Query.value;
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
    public int a;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image = new Image("images/LogoUCR.png");
         ImageView iv1 = new ImageView();
         iv1.setImage(image);
         this.lbUCR.setGraphic(iv1);
      
         try {
             
            if(!listH.isEmpty()){
            tp.ty=3;
            for (int i = 1; i <= listH.size(); i++) {
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
 public static String id;
 public static Course curso;
 public static Student estudiante;
 public static String horario;
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private void Confirm(ActionEvent event) throws ListException, IOException {
  
             f=Integer.parseInt(numMatricula.getText()); 
             if(cbxSchedules.getValue()!=null){
             opcion=cbxSchedules.getValue();
                 FXMLDeEnrollmentController l=new FXMLDeEnrollmentController();
                 l.b=0;
             listEnro.add(new Enrollment(f, y, new Student(s,cbxEstudiantes.getValue() , "", "", y, "", "", "", new Career(s, "")),
              new Course("", cbxEnrollmentCourses.getValue(), s, new Career(s, "")),(opcion)));
             util.Utility.file(listEnro, "MATRICULA");
             alert.setHeaderText(null);
                 alert.setTitle("Matrícula");
                    alert.setContentText("¡Matrículado exitosamente!");
                    alert.showAndWait(); 
                    id=Integer.toString(f);
                    curso=new Course("", cbxEnrollmentCourses.getValue(), s, new Career(s, ""));
                    horario=opcion;
                    estudiante=new Student(s,cbxEstudiantes.getValue() , "", "", y, "", "", "", new Career(s, ""));
        }
             
             
            if(cbxSchedules2.getValue()!=null){
                FXMLDeEnrollmentController l=new FXMLDeEnrollmentController();
            opcion=cbxSchedules2.getValue();
            l.b=0;
            listEnro.add(new Enrollment(f, y, new Student(s,cbxEstudiantes.getValue() , "", "", y, "", "", "", new Career(s, "")),
               new Course("", cbxEnrollmentCourses.getValue(), s, new Career(s, "")),(opcion)));
            util.Utility.file(listEnro, "MATRICULA");
            alert.setHeaderText(null);
                 alert.setTitle("Matrícula");
                    alert.setContentText("¡Matrículado exitosamente!");
                    alert.showAndWait(); 
        }
            if(cbxSchedules.getValue()!=null&&cbxSchedules2.getValue()!=null){
          
        }
            

    }
    
}
