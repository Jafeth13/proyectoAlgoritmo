/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.CircularDoublyLinkedList;
import domain.Course;
import domain.DeEnrollment;
import domain.Enrollment;
import domain.ListException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLCareers1Controller.list;
import static proyecto.FXMLCourseController.listp;
import static proyecto.FXMLEnrollmentController.listEnro;
import static proyecto.FXMLEnrollmentController.s;
import static proyecto.FXMLSchedulesController.listH;
import static proyecto.FXMLStudents1Controller.list2;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLDeEnrollmentController implements Initializable {
    public  static CircularDoublyLinkedList listDE=new CircularDoublyLinkedList();
    @FXML
    private Label lbLogo;
    @FXML
    private Label txtTittle;
    @FXML
    private Label txtGreen;
    @FXML
    private Label txtRed;
    @FXML
    private Label txtMessage;
    @FXML
    private TextField txtCarnet;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label txtInfo;
    @FXML
    private Button btnDeEnrollment;
    @FXML
    private Label txtMessage2;
    @FXML
    private TextArea txtAreaRemark;
    @FXML
    private Label txtInfo2;
    @FXML
    private TableView<Enrollment> tvDesmatricular;
    @FXML
    private TableColumn<Enrollment,String> tcSigla;
    @FXML
    private TableColumn<Enrollment,String> tcNombre;
    @FXML
    private TableColumn<Enrollment, String> tcHorario;
     TextInputDialog id = new TextInputDialog("");
  
    @FXML
    private ComboBox<String> cbxName;
    @FXML
    private ComboBox<String> cbxCurso;
    @FXML
    private ComboBox<String> cbxHorario;
    public static int b;
   
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if (listEnro.isEmpty()) {

        } else {
            try {
                Enrollment ep = new Enrollment((Enrollment) listEnro.getNode(1).getData());
                for (int j = 0; j <= tvDesmatricular.getItems().size(); j++) {
                    this.tvDesmatricular.getItems().clear();
                }
                for (int i = 1; i <= listEnro.size(); i++) {
                    ep = new Enrollment((Enrollment) listEnro.getNode(i).getData());
                    this.tvDesmatricular.getItems().add(ep);
                    this.tcSigla.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcNombre.setCellValueFactory(new PropertyValueFactory<>("courseID"));
                    this.tcHorario.setCellValueFactory(new PropertyValueFactory<>("schedule"));
                }
                this.tvDesmatricular.setVisible(false);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
  
        if (!listEnro.isEmpty()) {
            b = 3;
            try {
                for (int i = 1; i <= listEnro.size(); i++) {
                    System.out.println("El elemento en la posicion " + i + " es " + listEnro.getNode(i).data);
                    cbxHorario.getItems().addAll(("" + listEnro.getNode(i).data));
                }
            } catch (ListException ex) {
                Logger.getLogger(FXMLDeEnrollmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cbxHorario.getItems().add("No hay horarios registradas");
        }
        
          if (!listEnro.isEmpty()) {
            b = 2;
            try {
                for (int i = 1; i <= listEnro.size(); i++) {
                    System.out.println("El elemento en la posicion " + i + " es " + listEnro.getNode(i).data);
                    cbxName.getItems().addAll(("" + listEnro.getNode(i).data));
                }
            } catch (ListException ex) {
                Logger.getLogger(FXMLDeEnrollmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cbxName.getItems().add("No hay estudiantes matriculados registradas");
        }
          if (!listEnro.isEmpty()) {
            b = 1;
            try {
                for (int i = 1; i <= listEnro.size(); i++) {
                    System.out.println("El elemento en la posicion " + i + " es " + listEnro.getNode(i).data);
                    cbxCurso.getItems().addAll(("" + listEnro.getNode(i).data));
                }
            } catch (ListException ex) {
                Logger.getLogger(FXMLDeEnrollmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cbxCurso.getItems().add("No hay cursos matriculados");
        }
        
    }
private String d;
private Date dp;
private boolean er=false;
    @FXML
    private void btnConfirm(ActionEvent event) throws ListException {
        d=(txtCarnet.getText());
       er= list2.contains(new Student(0, d, "", "", dp, "", "", "", new Career(s, "")));
       if(er==true){     
       if (listEnro.isEmpty()) {

        } else {
            try {
                Enrollment ep = new Enrollment((Enrollment) listEnro.getNode(1).getData());
                for (int j = 0; j <= tvDesmatricular.getItems().size(); j++) {
                    this.tvDesmatricular.getItems().clear();
                }
                for (int i = 1; i <= listEnro.size(); i++) {
                    ep = new Enrollment((Enrollment) listEnro.getNode(i).getData());
                    this.tvDesmatricular.getItems().add(ep);
                    this.tcSigla.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcNombre.setCellValueFactory(new PropertyValueFactory<>("courseID"));
                    this.tcHorario.setCellValueFactory(new PropertyValueFactory<>("schedule"));
                }
                this.tvDesmatricular.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
       
    }
       
    }
private int z;
    @FXML
    private void btnDeEnrollment(ActionEvent event) throws ListException, IOException {
         id.setTitle("Retirar curso");
        id.setHeaderText("Ingrese el ID de la matricula a borrar:");
        id.setContentText("");
        
        Optional<String> result3 = id.showAndWait();
        if (result3.isPresent()) {
            
            try {
                this.z = Integer.parseInt(result3.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }   
                  FXMLDeEnrollmentController l=new FXMLDeEnrollmentController();
                  l.b=0;
                listEnro.remove(new Enrollment(z, dp, new Student(z, d, d, d, dp, d, d, d, 
                        new Career(z, d)), new Course(d, d, s, new Career(z, d)), d));
               if (listEnro.isEmpty()) {

        } else {
            try {
                Enrollment ep = new Enrollment((Enrollment) listEnro.getNode(1).getData());
                for (int j = 0; j <= tvDesmatricular.getItems().size(); j++) {
                    this.tvDesmatricular.getItems().clear();
                }
                for (int i = 1; i <= listEnro.size(); i++) {
                    ep = new Enrollment((Enrollment) listEnro.getNode(i).getData());
                    this.tvDesmatricular.getItems().add(ep);
                    this.tcSigla.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcNombre.setCellValueFactory(new PropertyValueFactory<>("courseID"));
                    this.tcHorario.setCellValueFactory(new PropertyValueFactory<>("schedule"));
                }
                this.tvDesmatricular.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }  
               FXMLEnrollmentController lp=new FXMLEnrollmentController();
               lp.a=0;
                listDE.add(new DeEnrollment(z, dp, new Student(0, cbxName.getValue(), d, d, dp, d, d, d,
                new Career(0, d)), new Course(d, cbxCurso.getValue(), s, new Career(0, d))
                , cbxHorario.getValue(), txtAreaRemark.getText()));
         
                util.Utility.file(listDE, "Cursos desmatriculados");
                System.out.println(listDE.toString());
       
    }
}
