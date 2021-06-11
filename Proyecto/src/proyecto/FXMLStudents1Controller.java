/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import com.sun.mail.smtp.SMTPAddressFailedException;
import domain.Career;
import domain.DoublyLinkedList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import mails.EnviarCorreos;
import static mails.EnviarCorreos.message;
import static mails.EnviarCorreos.multiParte;
import static proyecto.FXMLCareers1Controller.list;
import static proyecto.FXMLSecurityController.cL;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLStudents1Controller implements Initializable {
    
    Alert alert = new Alert(AlertType.ERROR);



    @FXML
    private Label txtMessage1;
    @FXML
    private TableView<Student> tvStudents;
    @FXML
    private TableColumn<Student, Integer> tcIDStu;
    @FXML
    private TableColumn<Student, String> tcCarnet;
    @FXML
    private TableColumn<Student, String> tcLast;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student,String> tcPhone;
    @FXML
    private TableColumn<Student, String> tcEmail;
    @FXML
    private TableColumn<Student, String> tcDirection;
    @FXML
    private TableColumn<Student, Career> tcCareer;
    @FXML
    private Button btnMostrarEstudiantes;
    @FXML
    private Button btnModifyStudent;
    @FXML
    private Button btnRemoveStudent;
    @FXML
    private Button btnAddStudent;
    @FXML
    private ComboBox<String> combo1s;
    @FXML
    private Label txtMessage;
    @FXML
    private Label txtErrorMessage;
    @FXML
    private Label lbImage;
    
    
    
    private int idE;
    private String carne;
    private String last;
    private String first;
    private String phone;
    private String correo;
    private Date d;
    private String casa;
    private String idER;
    
    public static SinglyLinkedList list2 = new SinglyLinkedList();
    TextInputDialog idStudent = new TextInputDialog("");
    TextInputDialog carnet = new TextInputDialog("");
    TextInputDialog lastName = new TextInputDialog("");
    TextInputDialog firstName = new TextInputDialog("");
    TextInputDialog NumeroTelfono = new TextInputDialog("");
    TextInputDialog email = new TextInputDialog("");
    TextInputDialog dirrecion = new TextInputDialog("");
    TextInputDialog idCarrera = new TextInputDialog("");

    FXMLCareers1Controller i=new FXMLCareers1Controller();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
            if(!list.isEmpty()){
            i.ty=2;
            for (int i = 1; i <= list.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + list.getNode(i).data);
               combo1s.getItems().addAll((""+list.getNode(i).data));
               // combo1s.getItems().addAll((DoublyLinkedList[]) list.getNode(i).getData());
            }}else{
                combo1s.getItems().add("No hay carreras registradas");
            }
        } catch (ListException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
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
    
 private String estuBuscar;
 private int idl;
 private boolean compa2;

    @FXML
    private void ModifyStudent(ActionEvent event) throws ListException, MessagingException {
        
          idStudent.setTitle("Agregar datos del estudiante");
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
            carnet.setTitle("Agregar datos del estudiante");
            carnet.setHeaderText("Ingrese el ID del estudiante:");
            carnet.setContentText("");

            Optional<String> result9 = carnet.showAndWait();
            if (result9.isPresent()) {

                try {
                    this.idl =Integer.parseInt(result9.get());

                } catch (NumberFormatException ex) {

                }
            }
            lastName.setTitle("Agregar datos del estudiante");
            lastName.setHeaderText("Ingrese el apellido del estudiante :");
            lastName.setContentText("");

            Optional<String> result29 = lastName.showAndWait();
            if (result29.isPresent()) {

                try {
                    this.last = result29.get();

                } catch (NumberFormatException ex) {

                }
            }
            firstName.setTitle("Agregar datos del estudiante");
            firstName.setHeaderText("Ingrese el nombre del estudiante :");
            firstName.setContentText("");

            Optional<String> result292 = firstName.showAndWait();
            if (result292.isPresent()) {

                try {
                    this.first = result292.get();

                } catch (NumberFormatException ex) {

                }
            }
            NumeroTelfono.setTitle("Agregar datos del estudiante");
            NumeroTelfono.setHeaderText("Ingrese el numero de telefono del estudiante :");
            NumeroTelfono.setContentText("");

            Optional<String> result111 = NumeroTelfono.showAndWait();
            if (result111.isPresent()) {

                try {
                    this.phone = result111.get();

                } catch (NumberFormatException ex) {

                }
            }
             int n1=0;
        
      do{
        email.setTitle("Agregar datos del estudiante");
        email.setHeaderText("Ingrese el correo del estudiante a añadir:");
        email.setContentText("");
       
        Optional<String> result291871 = email.showAndWait();
       
        if (result291871.isPresent()){
            
            try {
                this.correo = result291871.get();
                if(util.Utility.isCorreo(correo)){
                 n1=1;
                 
                }else{
                  alert.setHeaderText(null);
                 alert.setTitle("Error");
                    alert.setContentText("Correo no valido");
                    alert.showAndWait();  
                }
            } catch (NumberFormatException ex) {
                
        }
//        
        }
      }while(n1==0);
            dirrecion.setTitle("Agregar datos del estudiante");
            dirrecion.setHeaderText("Ingrese la dirrecion del estudiante :");
            dirrecion.setContentText("");

            Optional<String> result1234 = dirrecion.showAndWait();
            if (result1234.isPresent()) {

                try {
                    this.casa = result1234.get();

                } catch (NumberFormatException ex) {

                }
            }
                try {
                    this.idER = combo1s.getValue();

                } catch (NumberFormatException ex) {

                }

            list2.add(new Student(idl, estuBuscar, last, first, d, phone, correo, casa, new Career(0, idER)));
            txtMessage.setVisible(true);
            txtErrorMessage.setVisible(false);
            btnMostrarEstudiantes(event);
            EnviarCorreos.texto.setText("Felicidades por ingresar a la Universidad:\n Estos son sus datos:\n\n"+"Cédula: "+idE+"\nCarné asignado: "+carne+ 
                "\nNombre completo: "+first+" "+last+"\nNúmero telefónico: "+ phone+"\nCorreo: "+correo+"\nDirección: "+casa+"\nCarrera: "+idER);
        message.setContent(multiParte);
            EnviarCorreos enviarcorreos2 = new EnviarCorreos();
        enviarcorreos2.enviarCorreos(message.toString(),"Bienvenido a la Universidad de Costa Rica",correo);
        }else{
            txtMessage.setVisible(false);
            txtErrorMessage.setVisible(true);
        }
        
    }
    
     private String idEstudianteBorrar;
     private int idcursoRE;
     private String desRE;
     private String des;
    
    @FXML
    private void RemoveStudent(ActionEvent event) throws ListException {
        
         idStudent.setTitle("Eliminar datos del estudiante");
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
            txtMessage.setVisible(true);
            txtErrorMessage.setVisible(false);
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

    @FXML
    private void AddStudent(ActionEvent event) throws IOException, MessagingException {
        
        
        idStudent.setTitle("Agregar datos del estudiante");
        idStudent.setHeaderText("Ingrese el ID del estudiante a añadir:");
        idStudent.setContentText("");
        
        Optional<String> result = idStudent.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idE = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        carnet.setTitle("Agregar datos del estudiante");
        carnet.setHeaderText("Ingrese el carnet del estudiante a añadir:");
        carnet.setContentText("");
        
        Optional<String> result9 = carnet.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.carne = result9.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        lastName.setTitle("Agregar datos del estudiante");
        lastName.setHeaderText("Ingrese el apellido del estudiante a añadir:");
        lastName.setContentText("");
        
        Optional<String> result29 = lastName.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.last = result29.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
        firstName.setTitle("Agregar datos del estudiante");
        firstName.setHeaderText("Ingrese el nombre del estudiante a añadir:");
        firstName.setContentText("");
        
        Optional<String> result291 = firstName.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.first = result291.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
         NumeroTelfono.setTitle("Agregar datos del estudiante");
        NumeroTelfono.setHeaderText("Ingrese el numero de telefono del estudiante a añadir:");
        NumeroTelfono.setContentText("");
        
        Optional<String> result2918 = NumeroTelfono.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.phone = result2918.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
       int n=0;
        
      do{
        email.setTitle("Agregar datos del estudiante");
        email.setHeaderText("Ingrese el correo del estudiante a añadir:");
        email.setContentText("");
       
        Optional<String> result29187 = email.showAndWait();
       
        if (result.isPresent()){
            
            try {
                this.correo = result29187.get();
                if(util.Utility.isCorreo(correo)){
                 n=1;
                 
                }else{
                  alert.setHeaderText(null);
                 alert.setTitle("Error");
                    alert.setContentText("Correo no valido");
                    alert.showAndWait();  
                }
            } catch (NumberFormatException ex) {
                
        }
//        
        }
      }while(n==0);

        dirrecion.setTitle("Agregar datos del estudiante");
        dirrecion.setHeaderText("Ingrese la dirrecion del estudiante a añadir:");
        dirrecion.setContentText("");
        
        Optional<String> result291872 = dirrecion.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.casa = result291872.get();
                
            } catch (NumberFormatException ex) {
                
            }
        }
            
            try {
                this.idER = combo1s.getValue();
                
            } catch (NumberFormatException ex) {
                
            }
       
        list2.add(new Student(idE, carne, last, first, d, phone, correo, casa,new Career(0, idER)));
        util.Utility.file(list2, "Estudiantes");
        cL.add(new Student(idE, carne, last, first, d, phone, correo, casa,new Career(0, idER)));
        EnviarCorreos.texto.setText("Felicidades por ingresar a la Universidad:\n Estos son sus datos:\n\n"+"Cédula: "+idE+"\nCarné asignado: "+carne+ 
                "\nNombre completo: "+first+" "+last+"\nNúmero telefónico: "+ phone+"\nCorreo: "+correo+"\nDirección: "+casa+"\nCarrera: "+idER);
        message.setContent(multiParte);
        try{
        EnviarCorreos enviarcorreos = new EnviarCorreos();
        enviarcorreos.enviarCorreos(message.toString(),"Bienvenido a la Universidad de Costa Rica",correo);}
        catch(SMTPAddressFailedException e){
            alert.setTitle("Ha ocurrido un error");
        alert.setHeaderText("No se ha podido enviar correctamente el correo");
        alert.setContentText("Por favor revise que el correo electrónico sea valido y existente...");
        alert.showAndWait();
        }
        btnMostrarEstudiantes(event);
    }
    
}
