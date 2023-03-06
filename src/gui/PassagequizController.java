package gui;

import entities.Questions;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static services.QuestionCRUD.selectQuestionsByQuiz;

public class PassagequizController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private Button proposition1;
    @FXML
    private Button proposition2;
    @FXML
    private Button proposition3;
    @FXML
    private Label nbrquestionrestante;
    @FXML
    private TextField tempsrestant;
    
    private List<Questions> questions;
    private int currentQuestionIndex;
    private int nbReponsesCorrectes;
    private int nbReponsesIncorrectes;
    private String reponse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int quizId = 6; // l'id du quiz à afficher
        questions = selectQuestionsByQuiz(quizId);
        currentQuestionIndex = 0;
        reponse = "";
        try {
            afficherQuestionSuivante();
        } catch (IOException ex) {
            Logger.getLogger(PassagequizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static PassagequizController instance;

    public PassagequizController() {
        instance = this;
    }

    public static PassagequizController getInstance() {
        return instance;
    }
    
    private void afficherQuestionSuivante() throws IOException {
        if (currentQuestionIndex < questions.size()) {
            Questions currentQuestion = questions.get(currentQuestionIndex);
            question.setText(currentQuestion.getQuestion());
            proposition1.setText(currentQuestion.getPropositionA());
            proposition2.setText(currentQuestion.getPropositionB());
            proposition3.setText(currentQuestion.getPropositionC());
            nbrquestionrestante.setText("Questions restantes : " + (questions.size() - currentQuestionIndex));
            currentQuestionIndex++;
        } else {
            int nbQuestions = questions.size();
            double pourcentageScore = ((double) nbReponsesCorrectes / nbQuestions) * 100;
            System.out.println("Nombre de réponses correctes : " + nbReponsesCorrectes);
            System.out.println("Nombre de réponses incorrectes : " + nbReponsesIncorrectes);
            System.out.println("Pourcentage de score : " + pourcentageScore + "%");
            
            Stage stage = (Stage) question.getScene().getWindow();
            AnchorPane resultat = FXMLLoader.load(getClass().getResource("quizresultat.fxml"));
            stage.getScene().setRoot(resultat);
        }
    }

    @FXML
    private void reponsebouton1(ActionEvent event) throws IOException {
        Questions currentQuestion = questions.get(currentQuestionIndex - 1);
        if (currentQuestion.getId_BonneReponse().equals("A")) {
            nbReponsesCorrectes++;
        } else {
            nbReponsesIncorrectes++;
        }
        afficherQuestionSuivante();
    }

    @FXML
    private void reponsebouton2(ActionEvent event) throws IOException {
        Questions currentQuestion = questions.get(currentQuestionIndex - 1);
        if (currentQuestion.getId_BonneReponse().equals("B")) {
            nbReponsesCorrectes++;
        } else {
            nbReponsesIncorrectes++;
        }
        afficherQuestionSuivante();
    }

    @FXML
    private void reponsebouton3(ActionEvent event) throws IOException {
        Questions currentQuestion = questions.get(currentQuestionIndex - 1);
        if (currentQuestion.getId_BonneReponse().equals("C")) {
            nbReponsesCorrectes++;
        } else {
            nbReponsesIncorrectes++;
        }
        afficherQuestionSuivante();
    }
    
    public int getNbReponsesCorrectes() {
    return nbReponsesCorrectes;
}

public int getNbReponsesIncorrectes() {
    return nbReponsesIncorrectes;
}
    
}
