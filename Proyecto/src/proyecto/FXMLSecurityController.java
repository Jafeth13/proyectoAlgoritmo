/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


import domain.Career;
import domain.CircularLinkedList;
import domain.ListException;
import domain.Security;
import domain.SinglyLinkedList;
import domain.Student;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import util.Utility;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    @FXML
    private Label lbEma;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Image image = new Image("images/LogoUCR.png");
         ImageView iv1 = new ImageView();
         iv1.setImage(image);
         this.lbImage.setGraphic(iv1);
         
         Image image2 = new Image("images/Ematricula.png");
         ImageView iv2 = new ImageView();
         iv2.setImage(image2);
         this.lbEma.setGraphic(iv2);
      
        try {
            cL.add(new Security("Admin",MD5("1234")));
            
//this.TEXTAREA.setText(list.toString());
        } catch (IOException ex) {
            Logger.getLogger(FXMLSecurityController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 public static CircularLinkedList cL = new CircularLinkedList();
 private Date date;
 private String[] show;
 public static int Type=0;
 
    @FXML  
    private void SignIn(ActionEvent event) throws NoSuchAlgorithmException, IOException, ListException {
       
      
        Utility.file(cL.toString(), "Security");
        if(cL.contains(new Security(this.txtUser.getText(), MD5(this.txtPassword.getText())))){
            Type=1;
        this.loadpage("FXMLMenuPrincipal");
        } 
        if(cL.contains(new Student(0, this.txtUser.getText(), "", "",date, "", "", "", new Career(0, "")))){
           Type=2;
           this.loadpage("FXMLMenuPrincipal");
        }
        else
            this.txtMessage.setText("Usuario no válido");
    }
    //cargar diferentes escenas
    private void loadpage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bp.setCenter(root);
    }
    // metodo de encriptacion de la contraseña
    public String MD5(String md5) throws IOException{
    
        try{
         java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
         byte[] array = md.digest(md5.getBytes());
         StringBuffer sb = new StringBuffer();
         
             for (int i = 0; i < array.length; i++) {
                 sb.append(Integer.toHexString((array[i]&0xFF)|0x100).substring(1,3));
             } 
             
            
             return sb.toString();
         
         }catch(java.security.NoSuchAlgorithmException e){   
         }
    return null;
    }
}
