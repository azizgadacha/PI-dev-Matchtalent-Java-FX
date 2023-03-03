/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reponse_reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ItemController implements Initializable {

   
    @FXML
    private Label date;

    @FXML
    private Label titre;

    @FXML
    private Label username;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void SetLabel(reponse_reclamation r){
        System.out.println("ghcgftrsd" + r.getReponse());
        System.out.println("ghcgftrsd" + r.getDate().toString());
        //username.setText(r.getUtilisateur().getUsername());
        
         date.setText(r.getDate().toString());
    }
}
