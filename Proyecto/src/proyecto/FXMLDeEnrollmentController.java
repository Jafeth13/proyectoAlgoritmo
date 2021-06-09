/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.Course;
import domain.Enrollment;
import domain.ListException;
import domain.Student;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static proyecto.FXMLCareers1Controller.list;
import static proyecto.FXMLCourseController.listp;
import static proyecto.FXMLEnrollmentController.listEnro;
import static proyecto.FXMLEnrollmentController.s;
import static proyecto.FXMLStudents1Controller.list2;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLDeEnrollmentController implements Initializable {

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
    private TextArea txtAreaName;
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

    @FXML
    private void btnDeEnrollment(ActionEvent event) {
        
    }
}
