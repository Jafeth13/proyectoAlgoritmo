/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import domain.Career;
import domain.DoublyLinkedList;
import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLCareersController implements Initializable {
    DoublyLinkedList list = new DoublyLinkedList();
    TextInputDialog id = new TextInputDialog("");
    TextInputDialog descripcion = new TextInputDialog("");
    
    SinglyLinkedList list2 = new SinglyLinkedList();
    TextInputDialog idStudent = new TextInputDialog("");
    TextInputDialog carnet = new TextInputDialog("");
    TextInputDialog lastName = new TextInputDialog("");
    TextInputDialog firstName = new TextInputDialog("");
    TextInputDialog NumeroTelfono = new TextInputDialog("");
    TextInputDialog email = new TextInputDialog("");
    TextInputDialog dirrecion = new TextInputDialog("");
    TextInputDialog idCarrera = new TextInputDialog("");
    
    @FXML
    private Label lbImage;
    private TableColumn<Career, Integer> tcID;
    @FXML
    private Label txtErrorMessage;
    @FXML
    private Label txtMessage;
    @FXML
    private Label txtMessage1;
    private TableView<Career> tvCareers;
    private TableColumn<Career, String> tcDescription;
    
    @FXML
    private TableView<Student> tvStudents;
    @FXML
    private TableColumn<Student, String> tcCarnet;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student,String> tcPhone;
    @FXML
    private TableColumn<Student, String> tcDirection;
    @FXML
    private TableColumn<Student, String> tcEmail;
    @FXML
    private TableColumn<Student, Career> tcCareer;
    @FXML
    private Button btnAddStudent;
    @FXML
    private Button btnRemoveStudent;
    @FXML
    private Button btnModifyStudent;
    @FXML
    private TableColumn<Student, Integer> tcIDStu;
    @FXML
    private TableColumn<Student, String> tcLast;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private int idcurso;
    private String des;
    private void Add(ActionEvent event) {
        id.setTitle("DoublyLinkedList");
        id.setHeaderText("Ingrese el ID de la carrera a añadir:");
        id.setContentText("");
        
        Optional<String> result = id.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idcurso = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        descripcion.setTitle("DoublyLinkedList");
        descripcion.setHeaderText("Ingrese la descripcion de la carerra a añadir:");
        descripcion.setContentText("");
        Optional<String> resulX = descripcion.showAndWait();
        if (resulX.isPresent()) {
            
            try {
                this.des = resulX.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.add(new Career(idcurso, des));
    }
    private int idcursoRE;
    private String desRE;
    private void Remove(ActionEvent event) throws ListException {
         id.setTitle("DoublyLinkedList");
        id.setHeaderText("Ingrese el ID de la carrera a borrar:");
        id.setContentText("");
        
        Optional<String> result = id.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idcursoRE = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.remove(new Career(idcursoRE, ""));
        if (list.isEmpty()) {

        } else {
            try {
                Career ep = new Career((Career) list.getNode(1).getData());
                for (int j = 0; j <= tvCareers.getItems().size(); j++) {
                    this.tvCareers.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    ep = new Career((Career) list.getNode(i).getData());
                    this.tvCareers.getItems().add(ep);
                    this.tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                }
                this.tvCareers.setVisible(false);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
          
    }

    private void Modify(ActionEvent event) {
        if (list.isEmpty()) {

        } else {
            try {
                Career ep = new Career((Career) list.getNode(1).getData());
                for (int j = 0; j <= tvCareers.getItems().size(); j++) {
                    this.tvCareers.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    ep = new Career((Career) list.getNode(i).getData());
                    this.tvCareers.getItems().add(ep);
                    this.tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                }
                this.tvCareers.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
    }
    private int idE;
    private String carne;
    private String last;
    private String first;
    private String phone;
    private String correo;
    private Date d;
    private String casa;
    private int idER;
    @FXML
    private void AddStudent(ActionEvent event) {
        idStudent.setTitle("SinglyLinkedList");
        idStudent.setHeaderText("Ingrese el ID del estudiante a añadir:");
        idStudent.setContentText("");
        
        Optional<String> result = idStudent.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idE = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        carnet.setTitle("SinglyLinkedList");
        carnet.setHeaderText("Ingrese el carnet del estudiante a añadir:");
        carnet.setContentText("");
        
        Optional<String> result9 = carnet.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.carne = result9.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        lastName.setTitle("SinglyLinkedList");
        lastName.setHeaderText("Ingrese el apellido del estudiante a añadir:");
        lastName.setContentText("");
        
        Optional<String> result29 = lastName.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.last = result29.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        firstName.setTitle("SinglyLinkedList");
        firstName.setHeaderText("Ingrese el nombre del estudiante a añadir:");
        firstName.setContentText("");
        
        Optional<String> result291 = firstName.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.first = result291.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
         NumeroTelfono.setTitle("SinglyLinkedList");
        NumeroTelfono.setHeaderText("Ingrese el numero de telefono del estudiante a añadir:");
        NumeroTelfono.setContentText("");
        
        Optional<String> result2918 = NumeroTelfono.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.phone = result2918.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        email.setTitle("SinglyLinkedList");
        email.setHeaderText("Ingrese el correo del estudiante a añadir:");
        email.setContentText("");
        
        Optional<String> result29187 = email.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.correo = result29187.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        dirrecion.setTitle("SinglyLinkedList");
        dirrecion.setHeaderText("Ingrese la dirrecion del estudiante a añadir:");
        dirrecion.setContentText("");
        
        Optional<String> result291872 = dirrecion.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.casa = result291872.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
                idCarrera.setTitle("SinglyLinkedList");
        idCarrera.setHeaderText("Ingrese el codigo de la carrera del estudiante a añadir:");
        idCarrera.setContentText("");
        
        Optional<String> result2918727 = idCarrera.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idER = Integer.parseInt(result2918727.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
       
        list2.add(new Student(idE, carne, last, first, d, phone, correo, casa,new Career(idER, "")));
        
    }
    private int idEstudianteBorrar;
    @FXML
    private void RemoveStudent(ActionEvent event) throws ListException {
         idStudent.setTitle("SinglyLinkedList");
        idStudent.setHeaderText("Ingrese el ID del estudiante a borrar:");
        idStudent.setContentText("");
        
        Optional<String> result5 = idStudent.showAndWait();
        if (result5.isPresent()) {
            
            try {
                this.idEstudianteBorrar = Integer.parseInt(result5.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list2.remove(new Student(idEstudianteBorrar, "", "", "", d, phone, last, des, new Career(idE, desRE)));
          if (list2.isEmpty()) {

        } else {
            try {
                Student r = new Student((Student) list2.getNode(1).getData());
                for (int j = 0; j <= tvStudents.getItems().size(); j++) {
                    this.tvStudents.getItems().clear();
                }
                for (int i = 1; i <= list2.size(); i++) {
                    r = new Student((Student) list2.getNode(i).getData());
                    this.tvStudents.getItems().add(r);
                    this.tcIDStu.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcCarnet.setCellValueFactory(new PropertyValueFactory<>("studentID"));
                    this.tcName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                    this.tcLast.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    this.tcPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
                    this.tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                    this.tcDirection.setCellValueFactory(new PropertyValueFactory<>("address"));
                    this.tcCareer.setCellValueFactory(new PropertyValueFactory<>("careerID"));
                }
                this.tvStudents.setVisible(false);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
    }

    @FXML
    private void ModifyStudent(ActionEvent event) {
         if (list2.isEmpty()) {

        } else {
            try {
                Student r = new Student((Student) list2.getNode(1).getData());
                for (int j = 0; j <= tvStudents.getItems().size(); j++) {
                    this.tvStudents.getItems().clear();
                }
                for (int i = 1; i <= list2.size(); i++) {
                    r = new Student((Student) list2.getNode(i).getData());
                    this.tvStudents.getItems().add(r);
                    this.tcIDStu.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcCarnet.setCellValueFactory(new PropertyValueFactory<>("studentID"));
                    this.tcName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                    this.tcLast.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    this.tcPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
                    this.tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                    this.tcDirection.setCellValueFactory(new PropertyValueFactory<>("address"));
                    this.tcCareer.setCellValueFactory(new PropertyValueFactory<>("careerID"));
                }
                this.tvStudents.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
        
    }
    
}
