/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLEnrollmentController implements Initializable {

    @FXML
    private Label txtMessage;
    @FXML
    private Label lbUCR;
    @FXML
    private ComboBox<?> cbxEnrollmentCourses;
    @FXML
    private ComboBox<?> cbxSchedules;
    @FXML
    private Label txtError;
    @FXML
    private Label txtStudent;
    @FXML
    private Button btnConfirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Confirm(ActionEvent event) {
    }
    
}
