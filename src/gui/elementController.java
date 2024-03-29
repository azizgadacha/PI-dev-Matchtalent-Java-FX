/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Annonce;
import entities.Postulation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class elementController implements Initializable {

    @FXML
    private Label etat_pos;
    @FXML
    private Label date_id;
    
        PostulationService ps = new PostulationService();
    @FXML
    private Pane pane_id;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
     public elementController(){
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Candidature.TableElement/Item.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
    }
     
     
    
}
     
     
    
    