/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Questions;
import entities.Quiz;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.QuizCRUD;


public class AfficherlistedesquizController implements Initializable {

    @FXML
    private ListView<Quiz> idlistequiz;
    
    ObservableList<Quiz> Quiz = FXCollections.observableArrayList();
    @FXML
    private Button supp;
    @FXML
    private Button boutonajouterquiz;
    @FXML
    private Button boutonmodifierquiz;
    private Questions question;

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

    @FXML
    private void creerquiz(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("creerQuiz.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
}

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Quiz selectedItem = idlistequiz.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int selectedItemId = selectedItem.getId_quiz();
            System.out.println(selectedItemId);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherquestions.fxml"));
            Parent root = loader.load();
            AffichagedesquestionparquizController affichagedesquestionparquizController = loader.getController();
            affichagedesquestionparquizController.initialize(selectedItemId);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("No item selected.");
        } 
    }

        public void setQuestion(Questions question) {
        this.question = question;
    }
}
