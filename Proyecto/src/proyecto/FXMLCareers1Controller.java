/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.DoublyLinkedList;
import domain.ListException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLCareers1Controller implements Initializable {

    @FXML
    private TableView<Career> tvCareer;
    @FXML
    private TableColumn<Career, Integer> tcIDs;
    @FXML
    private TableColumn<Career, String> tcDescriptions;
    @FXML
    private Label lbImages;
    @FXML
    private Label txtMessages1;
    @FXML
    private Button btnMostrars;
    @FXML
    private Button btnModifys;
    @FXML
    private Button btnRemoves;
    @FXML
    private Button btnAdds;
    @FXML
    private Label txtMessages;
    @FXML
    private Label txtErrorMessages;
   public static int ty;
    public  static DoublyLinkedList list = new DoublyLinkedList();
    TextInputDialog id = new TextInputDialog("");
    TextInputDialog descripcion = new TextInputDialog("");

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("images/LogoUCR.png");
         ImageView iv1 = new ImageView();
         iv1.setImage(image);
         this.lbImages.setGraphic(iv1);
    }    

    @FXML
    private void btnMostrars(ActionEvent event) {
        
           if (list.isEmpty()) {

        } else {
            try {
                Career ep = new Career((Career) list.getNode(1).getData());
                for (int j = 0; j <= tvCareer.getItems().size(); j++) {
                    this.tvCareer.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    ep = new Career((Career) list.getNode(i).getData());
                    this.tvCareer.getItems().add(ep);
                    this.tcIDs.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcDescriptions.setCellValueFactory(new PropertyValueFactory<>("description"));
                }
                this.tvCareer.setVisible(true);
            } catch (ListException er) {
                System.out.println("Error");
            }
        }
    }

    private int idcursoMod;
    private boolean comp;
    private String desc2;
    
    @FXML
    private void Modifys(ActionEvent event) throws ListException {
        
         id.setTitle("Agregar datos");
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
                   descripcion.setTitle("Agregar datos");
        descripcion.setHeaderText("Ingrese la descripcion de la carerra a modificar:");
        descripcion.setContentText("");
        Optional<String> resulXt = descripcion.showAndWait();
        if (resulXt.isPresent()) {
            
            try {
                this.desc2 = resulXt.get();
                
            } catch (NumberFormatException ex) {
                
            }
        } 
        txtMessages.setVisible(true);
        txtErrorMessages.setVisible(false);
        list.add(new Career(idcursoMod, desc2));
        }else{
             txtMessages.setVisible(false);
        txtErrorMessages.setVisible(true);
            
        }
        btnMostrars(event);
       
    }
    
    private int idcursoRE;
    private String desRE;
    
    @FXML
    private void Removes(ActionEvent event) throws ListException {
        
        id.setTitle("Eliminar carrera");
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
                for (int j = 0; j <= tvCareer.getItems().size(); j++) {
                    this.tvCareer.getItems().clear();
                }
                for (int i = 1; i <= list.size(); i++) {
                    ep = new Career((Career) list.getNode(i).getData());
                    this.tvCareer.getItems().add(ep);
                    this.tcIDs.setCellValueFactory(new PropertyValueFactory<>("id"));
                    this.tcDescriptions.setCellValueFactory(new PropertyValueFactory<>("description"));
                }
                this.tvCareer.setVisible(false);
            } catch (ListException er) {
                System.out.println("Error");
            }
             txtMessages.setVisible(true);
        txtErrorMessages.setVisible(false);
        }
          btnMostrars(event);
        
    }

    private int idcurso;
    private String des;
    
    @FXML
    private void Adds(ActionEvent event) throws IOException {
        
        id.setTitle("Agregar datos");
        id.setHeaderText("Ingrese el ID de la carrera a añadir:");
        id.setContentText("");
        
        Optional<String> result = id.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idcurso = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        descripcion.setTitle("Agregar datos");
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
         txtMessages.setVisible(true);
        txtErrorMessages.setVisible(false);
        util.Utility.file(list, "Carrera");
        btnMostrars(event);
    }
    
}
