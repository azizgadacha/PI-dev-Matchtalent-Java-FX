/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author Istabrak
 */
public class PostulationController implements Initializable{
    
    @FXML
    private Label mySelectLabel;
    
   @FXML
   private ChoiceBox<String> myChoiceBox;
   
   private final String[] Type = { "cv", "lettre_de_motivation"," diplome"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            myChoiceBox.getItems().addAll(Type);
    }
    public void getType(ActionEvent event){
    String MyType= myChoiceBox.getValue();
    mySelectLabel.setText(MyType);
    } 
}
