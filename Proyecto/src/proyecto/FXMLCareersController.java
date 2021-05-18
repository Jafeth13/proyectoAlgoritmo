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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLCareersController implements Initializable {

    @FXML
    private Label lbImage;
    @FXML
    private TableColumn<?, ?> tcID;
    @FXML
    private TableColumn<?, ?> tcName;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnModify;
    @FXML
    private Label txtErrorMessage;
    @FXML
    private Label txtMessage;
    @FXML
    private Label txtMessage1;
    @FXML
    private TableView<?> tvCareers;
    @FXML
    private TableColumn<?, ?> tcDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add(ActionEvent event) {
    }

    @FXML
    private void Remove(ActionEvent event) {
    }

    @FXML
    private void Modify(ActionEvent event) {
    }
    
}
