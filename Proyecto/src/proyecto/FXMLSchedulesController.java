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
        comboH1.getItems().addAll("7am-8:50am","9am-10:50am","11am-12:50","1pm-2:50pm","3pm-4:50pm",
                "5pm-6:50pm","7pm-8:50");
        comboh2.getItems().addAll("7am-8:50am","9am-10:50am","11am-12:50","1pm-2:50pm","3pm-4:50pm",
                "5pm-6:50pm","7pm-8:50");
          
          
    }    
     private String CursoPriv;
     private String per;
     private String hora11;
     private String hora12;
    @FXML
    private void addHorarios(ActionEvent event) throws IOException, ListException {
    TextInputDialog perio = new TextInputDialog("");
    TextInputDialog hora1 = new TextInputDialog("");
    TextInputDialog hora2 = new TextInputDialog("");   
    

            
            try {
                this.CursoPriv = comboHorario.getValue();
                
            } catch (NumberFormatException ex) {
                
            }

        
        perio.setTitle("SinglyLinkedList");
        perio.setHeaderText("Ingrese el semestre :");
        perio.setContentText("");
        
        Optional<String> result2 = perio.showAndWait();
        if (result2.isPresent()) {
            
            try {
                this.per = result2.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        
        hora1.setTitle("SinglyLinkedList");
        hora1.setHeaderText("Ingrese la opcion de horario 1:");
        hora1.setContentText("");
        
        Optional<String> result25 = hora1.showAndWait();
        if (result25.isPresent()) {
            
            try {
                this.hora11 = result25.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        hora2.setTitle("SinglyLinkedList");
        hora2.setHeaderText("Ingrese la opcion de horario 2:");
        hora2.setContentText("");
        
        Optional<String> result256 = hora2.showAndWait();
        if (result256.isPresent()) {
            
            try {
                this.hora12 = result256.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
listH.add(new TimeTable(new Course(per, CursoPriv, 0, new Career(0, CursoPriv)), per, hora11, hora12));



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
    
}
