/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Quiz;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.QuizCRUD;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CreerQuizController implements Initializable {

    @FXML
    private TextField sujetnouveauquiz;
    @FXML
    private Button ajouterquizbouton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void ajoutduquiz(ActionEvent event) {
        QuizCRUD qr= new QuizCRUD();
        Quiz q = new Quiz();
        String s = sujetnouveauquiz.getText();
        qr.addEntity1(new Quiz(0,s));
        
    }
    
    
}
