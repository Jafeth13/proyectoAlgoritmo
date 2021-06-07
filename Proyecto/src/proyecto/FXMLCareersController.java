/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import domain.Career;
import domain.DoublyLinkedList;
import domain.ListException;
import domain.Security;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLSecurityController.cL;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLCareersController implements Initializable {
  public  static DoublyLinkedList list = new DoublyLinkedList();
    TextInputDialog id = new TextInputDialog("");
    TextInputDialog descripcion = new TextInputDialog("");
    
    static SinglyLinkedList list2 = new SinglyLinkedList();
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
    @FXML
    private TableColumn<Career, Integer> tcID;
    @FXML
    private Label txtErrorMessage;
    @FXML
    private Label txtMessage;
    @FXML
    private Label txtMessage1;
    @FXML
    private TableView<Career> tvCareers;
    @FXML
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
    private TableColumn<Student, Integer> tcIDStu;
    @FXML
    private TableColumn<Student, String> tcLast;
    @FXML
    private Button btnAddStudent;
    @FXML
    private Button btnRemoveStudent;
    @FXML
    private Button btnModifyStudent;
    @FXML
    private Button btnMostrarEstudiantes;
    @FXML
   public static  ComboBox<String> combo1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//    try {
//            if(!list.isEmpty()){
//            
//            for (int i = 1; i <= list.size(); i++) {
//                System.out.println("El elemento en la posicion " + i + " es " + list.getNode(i).data);
//                combo1.getItems().addAll((""+list.getNode(i).data));
////                combo1.getItems().addAll((DoublyLinkedList[]) list.getNode(i).getData());
//            }}else{
//                combo1.getItems().add("No hay carreras registradas");
//            }
//        } catch (ListException ex) {
//            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
//            }

    }    
    private int idcurso;
    private String des;
    @FXML
    private void Add(ActionEvent event) throws IOException, ListException {
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

        util.Utility.file(list, "Carrera");
        btnMostrar(event);
    }
    private int idcursoRE;
    private String desRE;
    @FXML
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
          btnMostrar(event);
    }
    private int idcursoMod;
    private boolean comp;
    private String desc2;
    @FXML
    private void Modify(ActionEvent event) throws ListException {
         id.setTitle("DoublyLinkedList");
        id.setHeaderText("Ingrese el ID de la carrera a modificar:");
        id.setContentText("");
        
        Optional<String> result3 = id.showAndWait();
        if (result3.isPresent()) {
            
            try {
                this.idcursoMod = Integer.parseInt(result3.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        comp=list.contains(new Career(idcursoMod, ""));
        if(comp==true){
            list.remove(new Career(idcursoMod, ""));
                   descripcion.setTitle("DoublyLinkedList");
        descripcion.setHeaderText("Ingrese la descripcion de la carerra a modificar:");
        descripcion.setContentText("");
        Optional<String> resulXt = descripcion.showAndWait();
        if (resulXt.isPresent()) {
            
            try {
                this.desc2 = resulXt.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list.add(new Career(idcursoMod, desc2));
        }else{
            
            
        }
        btnMostrar(event);
    }
    @FXML
    private void btnMostrar(ActionEvent event) {
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
    private String idER;
    
         
    
     @FXML
    private void AddStudent(ActionEvent event) throws IOException, ListException {
          
//       
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
        idCarrera.setHeaderText("Ingrese la carrera a añadir");
        idCarrera.setContentText("");
        
        Optional<String> result2918727 = idCarrera.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idER = result2918727.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
       
        list2.add(new Student(idE, carne, last, first, d, phone, correo, casa,new Career(0, idER)));
        util.Utility.file(list2, "Estudiantes");
        cL.add(new Student(idE, carne, last, first, d, phone, correo, casa,new Career(0, idER)));
        btnMostrarEstudiantes(event);
    }
    private String idEstudianteBorrar;
     @FXML
    private void RemoveStudent(ActionEvent event) throws ListException {
         idStudent.setTitle("SinglyLinkedList");
        idStudent.setHeaderText("Ingrese el Carnet del estudiante a borrar:");
        idStudent.setContentText("");
        
        Optional<String> result5 = idStudent.showAndWait();
        if (result5.isPresent()) {
            
            try {
                this.idEstudianteBorrar = result5.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        list2.remove(new Student(0, idEstudianteBorrar, "", "", d, phone, last, des, new Career(idE, desRE)));
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
          btnMostrarEstudiantes(event);
    }
private String estuBuscar;
private int idl;
private boolean compa2;
   @FXML
    private void ModifyStudent(ActionEvent event) throws ListException {
        idStudent.setTitle("SinglyLinkedList");
        idStudent.setHeaderText("Ingrese el Carnet del estudiante a buscar:");
        idStudent.setContentText("");

        Optional<String> result55 = idStudent.showAndWait();
        if (result55.isPresent()) {

            try {
                this.estuBuscar = result55.get();

            } catch (NumberFormatException ex) {

            }
        }
        compa2 = list2.contains(new Student(0, estuBuscar, "", "", d, phone, last, des, new Career(idE, desRE)));
        if (compa2 == true) {
            list2.remove(new Student(0, estuBuscar, "", "", d, phone, last, des, new Career(idE, desRE)));
            carnet.setTitle("SinglyLinkedList");
            carnet.setHeaderText("Ingrese el ID del estudiante:");
            carnet.setContentText("");

            Optional<String> result9 = carnet.showAndWait();
            if (result9.isPresent()) {

                try {
                    this.idl =Integer.parseInt(result9.get());

                } catch (NumberFormatException ex) {

                }
            }
            lastName.setTitle("SinglyLinkedList");
            lastName.setHeaderText("Ingrese el apellido del estudiante :");
            lastName.setContentText("");

            Optional<String> result29 = lastName.showAndWait();
            if (result29.isPresent()) {

                try {
                    this.last = result29.get();

                } catch (NumberFormatException ex) {

                }
            }
            firstName.setTitle("SinglyLinkedList");
            firstName.setHeaderText("Ingrese el nombre del estudiante :");
            firstName.setContentText("");

            Optional<String> result292 = firstName.showAndWait();
            if (result292.isPresent()) {

                try {
                    this.first = result292.get();

                } catch (NumberFormatException ex) {

                }
            }
            NumeroTelfono.setTitle("SinglyLinkedList");
            NumeroTelfono.setHeaderText("Ingrese el numero de telefono del estudiante :");
            NumeroTelfono.setContentText("");

            Optional<String> result111 = NumeroTelfono.showAndWait();
            if (result111.isPresent()) {

                try {
                    this.phone = result111.get();

                } catch (NumberFormatException ex) {

                }
            }
            email.setTitle("SinglyLinkedList");
            email.setHeaderText("Ingrese el correo del estudiante:");
            email.setContentText("");

            Optional<String> result66 = email.showAndWait();
            if (result66.isPresent()) {

                try {
                    this.correo = result66.get();

                } catch (NumberFormatException ex) {

                }
            }
            dirrecion.setTitle("SinglyLinkedList");
            dirrecion.setHeaderText("Ingrese la dirrecion del estudiante :");
            dirrecion.setContentText("");

            Optional<String> result1234 = dirrecion.showAndWait();
            if (result1234.isPresent()) {

                try {
                    this.casa = result1234.get();

                } catch (NumberFormatException ex) {

                }
            }
            idCarrera.setTitle("SinglyLinkedList");
            idCarrera.setHeaderText("Ingrese la carrera ");
            idCarrera.setContentText("");

            Optional<String> result999 = idCarrera.showAndWait();
            if (result999.isPresent()) {

                try {
                    this.idER = result999.get();

                } catch (NumberFormatException ex) {

                }
            }

            list2.add(new Student(idl, estuBuscar, last, first, d, phone, correo, casa, new Career(0, idER)));
            btnMostrarEstudiantes(event);
        }
    }
 
    @FXML
    private void btnMostrarEstudiantes(ActionEvent event) {
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
