/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Questions;
import entities.Quiz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import services.QuestionCRUD;
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
    @FXML
    private Button pdfbotton;

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

/*@FXML
private void telechargerpdf(ActionEvent event) {
    Quiz selectedQuiz = idlistequiz.getSelectionModel().getSelectedItem();
    if (selectedQuiz != null) {
        int selectedQuizId = selectedQuiz.getId_quiz();
        List<Questions> questions = QuestionCRUD.selectQuestionsByQuiz(selectedQuizId);

        // code pour générer le PDF en utilisant la bibliothèque de votre choix
        // par exemple, vous pouvez utiliser iText ou PDFBox pour générer le PDF
        // ci-dessous se trouve un exemple utilisant iText

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("questionduquiz.pdf"));
            document.open();

            for (Questions question : questions) {
                document.add(new Paragraph(question.getQuestion()));
                document.add(new Paragraph("A) " + question.getPropositionA()));
                document.add(new Paragraph("B) " + question.getPropositionB()));
                document.add(new Paragraph("C) " + question.getPropositionC()));
                document.add(new Paragraph("Réponse : " + question.getId_BonneReponse()));
                document.add(new Paragraph("\n"));
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No quiz selected.");
    }
} */
        @FXML
private void telechargerpdf(ActionEvent event) {
    Quiz selectedQuiz = idlistequiz.getSelectionModel().getSelectedItem();
    if (selectedQuiz != null) {
        int selectedQuizId = selectedQuiz.getId_quiz();
        List<Questions> questions = QuestionCRUD.selectQuestionsByQuiz(selectedQuizId);

        // code pour générer le PDF en utilisant la bibliothèque de votre choix
        // par exemple, vous pouvez utiliser iText ou PDFBox pour générer le PDF
        // ci-dessous se trouve un exemple utilisant iText

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("questionsavectitre.pdf"));
            document.open();

            // Ajouter le titre du quiz
            Paragraph title = new Paragraph("Quiz: " + selectedQuiz.getSujet_quiz());
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            // Ajouter chaque question
            for (Questions question : questions) {
                document.add(new Paragraph(question.getQuestion()));
                document.add(new Paragraph("A) " + question.getPropositionA()));
                document.add(new Paragraph("B) " + question.getPropositionB()));
                document.add(new Paragraph("C) " + question.getPropositionC()));
                document.add(new Paragraph("Réponse : " + question.getId_BonneReponse()));
                document.add(new Paragraph("\n"));
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No quiz selected.");
    }
}


}
