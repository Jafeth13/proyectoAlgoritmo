/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import domain.Career;
import domain.DoublyLinkedList;
import domain.ListException;
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

/**
 * FXML Controller class
 *
 * @author jodas
 */
public class FXMLCareersController implements Initializable {
    DoublyLinkedList list=new DoublyLinkedList ();
    TextInputDialog id = new TextInputDialog("");
    TextInputDialog descripcion = new TextInputDialog("");
    @FXML
    private Label lbImage;
    @FXML
    private TableColumn<Career, Integer> tcID;
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
    private TableView<Career> tvCareers;
    @FXML
    private TableColumn<Career, String> tcDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private int idcurso;
    private String des;
    @FXML
    private void Add(ActionEvent event) {
        id.setTitle("SinglyLinkedList");
        id.setHeaderText("Ingrese el ID de la carrera a añadir:");
        id.setContentText("");
        
        Optional<String> result = id.showAndWait();
        if (result.isPresent()) {
            
            try {
                this.idcurso = Integer.parseInt(result.get());
                
            } catch (NumberFormatException ex) {
                
            }
        }
        descripcion.setTitle("SinglyLinkedList");
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
    @FXML
    private void Remove(ActionEvent event) throws ListException {
         id.setTitle("SinglyLinkedList");
        id.setHeaderText("Ingrese el ID de la carrera a borrar: ");
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

    @FXML
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
    
}
