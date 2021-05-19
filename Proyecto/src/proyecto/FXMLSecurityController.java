/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.ListException;
import domain.SinglyLinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLSecurityController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Label lbImage;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSignIn;
    @FXML
    private Label txtMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
//this.TEXTAREA.setText(list.toString());

    }    
 private String[] show;
    @FXML
   
    private void SignIn(ActionEvent event) {
       
        if(this.txtUser.getText().equals("Admin")&&this.txtPassword.getText().equals("1234")){
        this.loadpage("FXMLMenuPrincipal");
        }else
            this.txtMessage.setText("Usuario no válido");
         
        
    }
    private void loadpage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bp.setCenter(root);
    }
}
