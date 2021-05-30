/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.CircularDoublyLinkedList;
import domain.Course;
import domain.ListException;
import domain.Student;
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
import static proyecto.FXMLCareersController.list2;

/**
 * FXML Controller class
 *
 * @author Matamoros Cordero
 */
public class FXMLCourseController implements Initializable {
    static  CircularDoublyLinkedList list =new CircularDoublyLinkedList();
    TextInputDialog idCourse = new TextInputDialog("");
    TextInputDialog name = new TextInputDialog("");
    TextInputDialog credits = new TextInputDialog("");
    TextInputDialog Carrera = new TextInputDialog("");
    TextInputDialog busc = new TextInputDialog("");
    
    @FXML
    private TableView<Course> twCourse;
    @FXML
    private TableColumn<Course, String> icCode;
    @FXML
    private TableColumn<Course, String> icName;
    @FXML
    private TableColumn<Course, Integer> icCredits;
    @FXML
    private TableColumn<Course, Career> icCarrers;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
private String elim;
    @FXML
    private void Remove(ActionEvent event) throws ListException {
         busc.setTitle("CircularDoublyLinkedList");
        busc.setHeaderText("Ingrese el ID del curso a borrar:");
        busc.setContentText("");
        
        Optional<String> result5 = busc.showAndWait();
        if (result5.isPresent()) {
            
            try {
                this.elim = result5.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.remove(new Course(elim, nombre, creditos, new Career(creditos, elim)));
             if (list.isEmpty()) {

             } else {
            try {
                Course r = new Course((Course) list.getNode(1).getData());
                for (int j = 0; j <= twCourse.getItems().size(); j++) {
                    this.twCourse.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    r = new Course((Course) list.getNode(i).getData());
                    this.twCourse.getItems().add(r);
                    this.icCode.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.icName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    this.icCredits.setCellValueFactory(new PropertyValueFactory<>("credtis"));
                    this.icCarrers.setCellValueFactory(new PropertyValueFactory<>("careerID"));
                }
                this.twCourse.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
        
    }
private boolean compa;
private String d;
    @FXML
    private void Modify(ActionEvent event) throws ListException {
         busc.setTitle("CircularDoublyLinkedList");
        busc.setHeaderText("Ingrese el ID del curso a modificar:");
        busc.setContentText("");
        
        Optional<String> result = busc.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.d = result.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
          compa = list.contains(new Course(d, nombre, creditos, new Career(creditos, d)));
          if (compa == true) {
            list.remove(new Course(d, nombre, creditos, new Career(creditos, d)));
              name.setTitle("CircularDoublyLinkedList");
        name.setHeaderText("Ingrese el nombre del curso :");
        name.setContentText("");
        
        Optional<String> result9 = name.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.nombre = result9.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        credits.setTitle("CircularDoublyLinkedList");
        credits.setHeaderText("Ingrese los creditos del curso :");
        credits.setContentText("");
        
        Optional<String> result29 = credits.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.creditos = Integer.parseInt(result29.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        Carrera.setTitle("CircularDoublyLinkedList");
        Carrera.setHeaderText("Ingrese la carrera del curso ");
        Carrera.setContentText("");
        
        Optional<String> result291 = Carrera.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.carrer = result291.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.add(new Course(d, nombre, creditos, new Career(0,carrer)));
            
          }
    }

    @FXML
    private void btnMostrar(ActionEvent event) {
            if (list.isEmpty()) {

        } else {
            try {
                Course r = new Course((Course) list.getNode(1).getData());
                for (int j = 0; j <= twCourse.getItems().size(); j++) {
                    this.twCourse.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    r = new Course((Course) list.getNode(i).getData());
                    this.twCourse.getItems().add(r);
                    this.icCode.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.icName.setCellValueFactory(new PropertyValueFactory<>("name"));
                    this.icCredits.setCellValueFactory(new PropertyValueFactory<>("credtis"));
                    this.icCarrers.setCellValueFactory(new PropertyValueFactory<>("careerID"));
                }
                this.twCourse.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
        
        
    }
    private String id;
    private String nombre;
    private int creditos;
    private String carrer;
    @FXML
    private void Add(ActionEvent event) {
        idCourse.setTitle("CircularDoublyLinkedList");
        idCourse.setHeaderText("Ingrese el ID del curso a añadir:");
        idCourse.setContentText("");
        
        Optional<String> result = idCourse.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.id = result.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        name.setTitle("CircularDoublyLinkedList");
        name.setHeaderText("Ingrese el nombre del curso a añadir:");
        name.setContentText("");
        
        Optional<String> result9 = name.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.nombre = result9.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        credits.setTitle("CircularDoublyLinkedList");
        credits.setHeaderText("Ingrese los creditos del curso a añadir:");
        credits.setContentText("");
        
        Optional<String> result29 = credits.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.creditos = Integer.parseInt(result29.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        Carrera.setTitle("CircularDoublyLinkedList");
        Carrera.setHeaderText("Ingrese la carrera del curso añadido");
        Carrera.setContentText("");
        
        Optional<String> result291 = Carrera.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.carrer = result291.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.add(new Course(id, nombre, creditos, new Career(0, carrer)));
    }
    
}
