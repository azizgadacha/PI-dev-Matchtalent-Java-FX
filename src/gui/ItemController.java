/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reponse_reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.Reponse_ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ItemController implements Initializable {
    @FXML
    private Label titre;

    private reponse_reclamation reponse;
    private ListReponseController parentController; // add a reference to the parent controller
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /*public void SetLabel(reponse_reclamation r){
        //username.setText(r.getUtilisateur().getUsername());
         titre.setText(r.getReponse());
    }*/

    /*void setLabel(reponse_reclamation get) {
        titre.setText(get.getReponse());
    }*/

    public void setLabel(reponse_reclamation r) {
        this.reponse = r;
        this.parentController = parentController; // save a reference to the parent controller
        titre.setText(r.getReponse());
    }
    
     @FXML
    private void handleDeleteButton(ActionEvent event) throws SQLException {
        Reponse_ReclamationService ps = new Reponse_ReclamationService();
        ps.supprimer(reponse);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

   

}
