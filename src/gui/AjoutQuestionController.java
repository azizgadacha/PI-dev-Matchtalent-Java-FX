/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Questions;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import services.QuestionCRUD;


public class AjoutQuestionController implements Initializable {

    @FXML
    private TextField propA;
    @FXML
    private TextField question;
    @FXML
    private TextField propB;
    @FXML
    private TextField propC;

    @FXML
    private Button boutonannuler;
    @FXML
    private Button boutonajouter;
    @FXML
    private TextField idbonnereponse;

    private int quizID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.quizID = quizID;
    } 

    @FXML
    private void annulerajout(ActionEvent event) {
        boutonannuler.getScene().getWindow().hide();
        
    }
        void initialize(int quizID) {
        System.out.println(quizID);
        this.quizID = quizID;
        initialize(null, null);
    }

    @FXML
    private void ajouterquestion(ActionEvent event) {
    if (question.getText().isEmpty() || propA.getText().isEmpty()
            || propB.getText().isEmpty() || propC.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Tous les champs doivent être remplis.");
        alert.showAndWait();
    } else if (!idbonnereponse.getText().matches("[A-C]")) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("La bonne réponse doit être A, B ou C en majuscules.");
        alert.showAndWait();
    } else {
        
        Questions q = new Questions(question.getText(), propA.getText(), propB.getText(), propC.getText(),idbonnereponse.getText());
        System.out.println(q);
        QuestionCRUD pc2= new QuestionCRUD();
        pc2.addEntity2(q,6);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("La question a été ajoutée avec succès.");
        alert.showAndWait();
        question.clear();
        propA.clear();
        propB.clear();
        propC.clear();
        idbonnereponse.clear();
        
    }
}

   
}
