/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Quiz;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import services.QuizCRUD;


public class AfficherlistedesquizController implements Initializable {

    @FXML
    private ListView<Quiz> idlistequiz;
    
    ObservableList<Quiz> Quiz = FXCollections.observableArrayList();
    @FXML
    private Button supp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //System.out.println("quizlist");
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherlistedesquizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void afficher() throws SQLException{
        QuizCRUD sr = new QuizCRUD();
        Quiz=FXCollections.observableArrayList(sr.Affichertout());
        
        idlistequiz.setItems(Quiz);
    }

    @FXML
    private void list(MouseEvent event) {
    
    }

    @FXML
    private void suppression(ActionEvent event) throws SQLException {
        QuizCRUD qr = new QuizCRUD();
        Quiz p = new Quiz();
        qr.Supprimer(idlistequiz.getSelectionModel().getSelectedItem().getId_quiz());
        afficher();
    }

    
}
