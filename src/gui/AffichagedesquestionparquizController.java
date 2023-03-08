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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.QuestionCRUD;
import services.QuizCRUD;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AffichagedesquestionparquizController implements Initializable {

    @FXML
    private TableColumn<Questions, String> colquestion;
    @FXML
    private TableColumn<Questions, String> colpropA;
    @FXML
    private TableColumn<Questions, String> colpropB;
    @FXML
    private TableColumn<Questions, String> colpropC;
    @FXML
    private TableColumn<Questions, String> colbonnereponse;
    @FXML
    private Button boutonsupprimerquestion;
    @FXML
    private Button boutonmodifierquestion;
    @FXML
    private Button boutonajouterquestion;
    @FXML
    private TableView<Questions> tablequestions;
    
    private int selectedItemId;
    @FXML
    private Button refresh;
    private int quizID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.selectedItemId = selectedItemId;
        quizID = selectedItemId;
        QuizCRUD qr = new QuizCRUD();
        
       // Initialize the columns with the property values from the Questions entity
        colquestion.setCellValueFactory(new PropertyValueFactory<>("question"));
        colpropA.setCellValueFactory(new PropertyValueFactory<>("propositionA"));
        colpropB.setCellValueFactory(new PropertyValueFactory<>("propositionB"));
        colpropC.setCellValueFactory(new PropertyValueFactory<>("propositionC"));
        colbonnereponse.setCellValueFactory(new PropertyValueFactory<>("id_BonneReponse"));
        
        // Get the data for the table from the QuestionCRUD service
        ObservableList<Questions> questionList = FXCollections.observableArrayList();
        System.out.println(this.selectedItemId);
        questionList.addAll(QuestionCRUD.selectQuestionsByQuiz(this.selectedItemId));
        
        // Set the data for the table view  
        tablequestions.setItems(questionList);
        
    }
    
        public int getQuizID() {
        return quizID;
        }   

    void initialize(int selectedItemId) {
        System.out.println(selectedItemId);
        this.selectedItemId = selectedItemId;
        initialize(null, null);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        Questions selectedItem = tablequestions.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            System.out.println(selectedItemId);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierquestion.fxml"));
            Parent root = loader.load();
            ModifierquestionController modifierquestionController = loader.getController();
            modifierquestionController.initialize(selectedItem);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("No item selected.");
        } 
        
    }

    @FXML
    private void refresh(ActionEvent event) {
        this.selectedItemId = selectedItemId;
        
        QuizCRUD qr = new QuizCRUD();
        
       // Initialize the columns with the property values from the Questions entity
        colquestion.setCellValueFactory(new PropertyValueFactory<>("question"));
        colpropA.setCellValueFactory(new PropertyValueFactory<>("propositionA"));
        colpropB.setCellValueFactory(new PropertyValueFactory<>("propositionB"));
        colpropC.setCellValueFactory(new PropertyValueFactory<>("propositionC"));
        colbonnereponse.setCellValueFactory(new PropertyValueFactory<>("id_BonneReponse"));
        
        // Get the data for the table from the QuestionCRUD service
        ObservableList<Questions> questionList = FXCollections.observableArrayList();
        System.out.println(this.selectedItemId);
        questionList.addAll(QuestionCRUD.selectQuestionsByQuiz(this.selectedItemId));
        
        // Set the data for the table view  
        tablequestions.setItems(questionList);
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
              QuestionCRUD qr = new QuestionCRUD();
        Questions q = new Questions();
        qr.Supprimer(tablequestions.getSelectionModel().getSelectedItem().getId_Question());
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutQuestion.fxml"));
            Parent root = loader.load();
            
            AjoutQuestionController ajoutQuestionController = loader.getController();
            ajoutQuestionController.initialize(quizID);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
    }
}
