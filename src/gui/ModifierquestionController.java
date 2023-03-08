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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.QuestionCRUD;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierquestionController implements Initializable {

    @FXML
    private TextField propA;
    @FXML
    private TextField question;
    @FXML
    private TextField propB;
    @FXML
    private TextField propC;
    @FXML
    private TextField idbonnereponse;
    @FXML
    private Button boutonannuler;
    @FXML
    private Button boutonconfirmer;



    /**
     * Initializes the controller class.
     */
    private Questions selectedItemId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            if (selectedItemId != null) {
            question.setText(selectedItemId.getQuestion());
            propA.setText(selectedItemId.getPropositionA());
            propB.setText(selectedItemId.getPropositionB());
            propC.setText(selectedItemId.getPropositionC());
            idbonnereponse.setText(selectedItemId.getId_BonneReponse());
        }
    }    
        void initialize(Questions selectedItemId) {
        System.out.println(selectedItemId);
        this.selectedItemId = selectedItemId;
        initialize(null, null);
    }

    @FXML
    private void annulermodif(ActionEvent event) {
      boutonannuler.getScene().getWindow().hide();
    }

    @FXML
    private void modifierquestion(ActionEvent event) {
            // Check that all fields are filled
        if (question.getText().isEmpty() || propA.getText().isEmpty()
                || propB.getText().isEmpty() || propC.getText().isEmpty() || idbonnereponse.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs doivent être remplis.");
            alert.showAndWait();
        } else if (!idbonnereponse.getText().matches("[A-C]")) { // Check that the correct answer is A, B, or C
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("La bonne réponse doit être A, B ou C en majuscules.");
            alert.showAndWait();
        } else {
            // Create a new Questions object with the new values
            Questions newQuestion = new Questions(question.getText(), propA.getText(), propB.getText(), propC.getText(), idbonnereponse.getText());
            newQuestion.setId_Question(selectedItemId.getId_Question());
            // Update the question in the database
            QuestionCRUD questionCRUD = new QuestionCRUD();
            questionCRUD.updateQuestion(newQuestion);
            // Show a success message and close the window
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("La question a été modifiée avec succès.");
            alert.showAndWait();
        }
    } 
    }
    

