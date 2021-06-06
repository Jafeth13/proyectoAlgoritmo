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
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLCareersController.list;

/**
 * FXML Controller class
 *
 * @author Matamoros Cordero
 */
public class FXMLSchedulesController implements Initializable {
    static  SinglyLinkedList list =new SinglyLinkedList();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private String CursoPriv;
     private String per;
     private String hora11;
     private String hora12;
    @FXML
    private void addHorarios(ActionEvent event) {
    TextInputDialog Curso = new TextInputDialog("");
    TextInputDialog perio = new TextInputDialog("");
    TextInputDialog hora1 = new TextInputDialog("");
    TextInputDialog hora2 = new TextInputDialog("");   
    
        Curso.setTitle("SinglyLinkedList");
        Curso.setHeaderText("Ingrese el nombrel curso :");
        Curso.setContentText("");
        
        Optional<String> result = Curso.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.CursoPriv = result.get();
                
            } catch (NumberFormatException ex) {
                
            }
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
//        if(hora11.equalsIgnoreCase(hora12)){
//            
//        }else{
//            if(hora11.contains("Domingo")||hora12.contains("Domingo")||	hora11.contains("6am")||hora11.contains("5am")
//               ||hora11.contains("5am")||hora11.contains("4am")||hora11.contains("3am")||hora11.contains("2am")
//               ||hora11.contains("1am")||hora11.contains("12am")||hora11.contains("11pm")||hora11.contains("10pm")
//               ||hora12.contains("6am")||hora12.contains("5am")
//               ||hora12.contains("5am")||hora12.contains("4am")||hora12.contains("3am")||hora12.contains("2am")
//               ||hora12.contains("1am")||hora12.contains("12am")||hora12.contains("11pm")||hora12.contains("10pm")){               
//            
//            }else{
list.add(new TimeTable(new Course(per, CursoPriv, 0, new Career(0, CursoPriv)), per, hora11, hora12));
           if (list.isEmpty()) {

        } else {
            try {
                TimeTable ep = new TimeTable((TimeTable) list.getNode(1).getData());
                for (int j = 0; j <= twHorario.getItems().size(); j++) {
                    this.twHorario.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    ep = new TimeTable((TimeTable) list.getNode(i).getData());
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
//        }
//            }
            
        }
        
        
        
        
    }
    
}
