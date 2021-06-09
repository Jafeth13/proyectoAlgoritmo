/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.Course;
import domain.ListException;
import domain.SinglyLinkedList;
import domain.TimeTable;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLCareers1Controller.list;
import static proyecto.FXMLCourseController.listp;

/**
 * FXML Controller class
 *
 * @author Matamoros Cordero
 */
public class FXMLSchedulesController implements Initializable {
  public  static  SinglyLinkedList listH =new SinglyLinkedList();
    
    @FXML
    private TableView<TimeTable> twHorario;
    @FXML
    private TableColumn<Course, String> TCCourse;
    @FXML
    private TableColumn<String, String> TCSemestre;
    @FXML
    private TableColumn<String,String> TCS1;
    @FXML
    private TableColumn<String,String> TCS2;
    @FXML
    private Button btnAddHorario;
    @FXML
    private ComboBox<String> comboHorario;
 FXMLCourseController tp=new FXMLCourseController();
    @FXML
    private ComboBox<String> comboH1;
    @FXML
    private ComboBox<String> comboh2;
    @FXML
    private TextField txtSemestre;
    @FXML
    private Label txtMessage;
    @FXML
    private Label txtTittle;
    @FXML
    private Label txtMessage1;
    @FXML
    private Label txtMessage11;
    @FXML
    private Label txtMessage111;
    @FXML
    private RadioButton L;
    @FXML
    private RadioButton K;
    @FXML
    private RadioButton M;
    @FXML
    private RadioButton V;
    @FXML
    private RadioButton J;
    @FXML
    private RadioButton S;
    @FXML
    private RadioButton M2;
    @FXML
    private RadioButton J2;
    @FXML
    private RadioButton K2;
    @FXML
    private RadioButton L2;
    @FXML
    private RadioButton V2;
    @FXML
    private RadioButton S2;
    @FXML
    private Label lbUCR;
    @FXML
    private Label txtMessage2;
    @FXML
    private Label txtError;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
             
            if(!listp.isEmpty()){
            tp.ty=2;
            for (int i = 1; i <= listp.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + listp.getNode(i).data);
                comboHorario.getItems().addAll((""+listp.getNode(i).data));
//                combo1.getItems().addAll((DoublyLinkedList[]) list.getNode(i).getData());
            }}else{
                comboHorario.getItems().add("No hay cursos registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
 comboH1.getItems().addAll("7:00am-8:50am","9:00am-10:50am","11:00am-12:50","1:00pm-2:50pm",
                           "3:00pm-4:50pm","5:00pm-6:50pm","7:00pm-8:50",
                           "7:00am-9:50am","9:00am-11:50am","1:00pm-3:50pm","4:00pm-6:50",
                           "8:00am-11:50am","1:00pm-4:50pm","5:00pm-8:50pm");
 
 comboh2.getItems().addAll("7:00am-8:50am","9:00am-10:50am","11:00am-12:50","1:00pm-2:50pm",
                           "3:00pm-4:50pm","5:00pm-6:50pm","7:00pm-8:50",
                           "7:00am-9:50am","9:00am-11:50am","1:00pm-3:50pm","4:00pm-6:50",
                           "8:00am-11:50am","1:00pm-4:50pm","5:00pm-8:50pm");
          
          
    }    
  
    @FXML
    private void addHorarios(ActionEvent event) throws IOException, ListException {
    
listH.add(new TimeTable(new Course(this.txtSemestre.getText(), this.comboHorario.getValue(), 0, new Career(0,
        this.comboHorario.getValue())), this.txtSemestre.getText(), day+" "+this.comboH1.getValue(),
        day2+" "+this.comboh2.getValue()));



util.Utility.file(listH,"Horarios");
           if (listH.isEmpty()) {

        } else {
            try {
                TimeTable ep = new TimeTable((TimeTable) listH.getNode(1).getData());
                for (int j = 0; j <= twHorario.getItems().size(); j++) {
                    this.twHorario.getItems().clear();
                }
                for (int i = 1; i <= listH.size(); i++) {
                    ep = new TimeTable((TimeTable) listH.getNode(i).getData());
                    this.twHorario.getItems().add(ep);
                    this.TCCourse.setCellValueFactory(new PropertyValueFactory<>("courseID"));
                    this.TCSemestre.setCellValueFactory(new PropertyValueFactory<>("period"));
                    this.TCS1.setCellValueFactory(new PropertyValueFactory<>("schedule1"));
                    this.TCS2.setCellValueFactory(new PropertyValueFactory<>("schedule2"));
                }
                this.twHorario.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }   
        } 
    }
    
    public static String day;
     public static String day2;
    @FXML
    private void L(ActionEvent event) {
        this.K.setSelected(false);
        this.M.setSelected(false);
        this.J.setSelected(false);
        this.V.setSelected(false);
        this.S.setSelected(false);
        day="L";
    }

    @FXML
    private void K(ActionEvent event) {
        this.L.setSelected(false);
        this.M.setSelected(false);
        this.J.setSelected(false);
        this.V.setSelected(false);
        this.S.setSelected(false);
        day="K";
    }

    @FXML
    private void M(ActionEvent event) {
        this.K.setSelected(false);
        this.L.setSelected(false);
        this.J.setSelected(false);
        this.V.setSelected(false);
        this.S.setSelected(false);
        day="M";
    }

    @FXML
    private void V(ActionEvent event) {
        this.K.setSelected(false);
        this.M.setSelected(false);
        this.J.setSelected(false);
        this.L.setSelected(false);
        this.S.setSelected(false);
        day="V";
    }

    @FXML
    private void J(ActionEvent event) {
        this.K.setSelected(false);
        this.M.setSelected(false);
        this.L.setSelected(false);
        this.V.setSelected(false);
        this.S.setSelected(false);
        day="J";
    }

    @FXML
    private void S(ActionEvent event) {
        this.K.setSelected(false);
        this.M.setSelected(false);
        this.J.setSelected(false);
        this.V.setSelected(false);
        this.L.setSelected(false);
        day="S";
    }

    @FXML
    private void M2(ActionEvent event) {
        this.K2.setSelected(false);
        this.L2.setSelected(false);
        this.J2.setSelected(false);
        this.V2.setSelected(false);
        this.S2.setSelected(false);
        day2="M";
    }

    @FXML
    private void J2(ActionEvent event) {
        this.K2.setSelected(false);
        this.M2.setSelected(false);
        this.L2.setSelected(false);
        this.V2.setSelected(false);
        this.S2.setSelected(false);
        day2="J";
    }

    @FXML
    private void K2(ActionEvent event) {
        this.M2.setSelected(false);
        this.L2.setSelected(false);
        this.J2.setSelected(false);
        this.V2.setSelected(false);
        this.S2.setSelected(false);
        day2="K";
    }

    @FXML
    private void L2(ActionEvent event) {
        this.K2.setSelected(false);
        this.M2.setSelected(false);
        this.J2.setSelected(false);
        this.V2.setSelected(false);
        this.S2.setSelected(false);
        day2="L";
    }

    @FXML
    private void V2(ActionEvent event) {
        this.K2.setSelected(false);
        this.L2.setSelected(false);
        this.J2.setSelected(false);
        this.M2.setSelected(false);
        this.S2.setSelected(false);
        day2="V";
    }

    @FXML
    private void S2(ActionEvent event) {
        this.K2.setSelected(false);
        this.L2.setSelected(false);
        this.J2.setSelected(false);
        this.V2.setSelected(false);
        this.M2.setSelected(false);
        day2="S";
    }
    
}
