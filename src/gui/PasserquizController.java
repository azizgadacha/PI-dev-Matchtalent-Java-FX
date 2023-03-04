package gui;

import entities.Questions;
import entities.Quiz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import java.util.List;
import static services.QuestionCRUD.selectQuestionsByQuiz;
import utils.MyConnection;

public class PasserquizController {
    
    private Quiz quiz;
    private List<Questions> questions;
    private int currentQuestionIndex;
    private String reponses;
    
    @FXML
    private Label questionLabel;
    
    @FXML
    private RadioButton optionARadioButton;
    
    @FXML
    private RadioButton optionBRadioButton;
    
    @FXML
    private RadioButton optionCRadioButton;
    
    @FXML
    private ToggleGroup optionsToggleGroup;
    
    @FXML
    private Button nextQuestionButton;
    
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        this.questions = selectQuestionsByQuiz(quiz.getId_quiz());
        this.currentQuestionIndex = 0;
        this.reponses = "";
        showCurrentQuestion();
    }
    
    private List<Questions> selectQuestionsByQuiz(int quizId) {
        List<Questions> questions = new ArrayList<>();
        String query = "SELECT * FROM Questions WHERE id_Quiz = '" + quizId + "'";
        try {
            Statement statement = MyConnection.getInstance().getCnx().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Questions question = new Questions(
                        result.getInt("id_Question"),
                        result.getInt("id_Quiz"),
                        result.getString("Question"),
                        result.getString("PropositionA"),
                        result.getString("PropositionB"),
                        result.getString("PropositionC"),
                        result.getString("id_BonneReponse")
                );
                questions.add(question);
            }
        } catch (SQLException ex) {
            System.out.println("Error selecting questions: " + ex.getMessage());
        }
        return questions;
    }
    

    
    @FXML
   public void onNextQuestionButtonClicked() {
    String selectedOption = "";
    if (optionARadioButton.isSelected()) {
        selectedOption = "A";
    } else if (optionBRadioButton.isSelected()) {
        selectedOption = "B";
    } else if (optionCRadioButton.isSelected()) {
        selectedOption = "C";
    }
    reponses += selectedOption.toUpperCase();
    currentQuestionIndex++;
    if (currentQuestionIndex >= questions.size()) {
        // All questions have been answered
        // Show quiz results
       // App.setRoot("quizResultat");
       // QuizResultatController quizResultatController = App.getQuizResultatController();
       // quizResultatController.setQuiz(quiz, reponses);
    } else {
        showCurrentQuestion();
    }
}

    private void showCurrentQuestion() {
        Questions currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestion());
        optionARadioButton.setText(currentQuestion.getPropositionA());
        optionBRadioButton.setText(currentQuestion.getPropositionB());
        optionCRadioButton.setText(currentQuestion.getPropositionC());
        optionsToggleGroup.selectToggle(null); // clear selection
    }
    
}
