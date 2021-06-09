/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.ListException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static proyecto.FXMLCourseController.listp;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
