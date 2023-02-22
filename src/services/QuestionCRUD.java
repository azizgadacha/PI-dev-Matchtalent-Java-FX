/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Questions;
import entities.Quiz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.Q;
import static services.QuizCRUD.updateQuizQuestionCounts;
import utils.MyConnection;


public class QuestionCRUD implements EntityCRUD<Questions> {
    
    
    //ajouter question
    public void addEntity(Questions Q) {
        String requete = "INSERT INTO Questions(id_Question,id_Quiz,Question,PropositionA,PropositionB,PropositionC,id_BonneReponse)" +
                 "VALUES('" + Q.getId_Question() + "', '" + Q.getId_Quiz() + "', '" + Q.getQuestion() + "', '" + Q.getPropositionA() +"', '" + Q.getPropositionB() +"', '" + Q.getPropositionC() +"', '" + Q.getId_BonneReponse() + "')";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question ajoutée");       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
            updateQuizQuestionCounts();   
    }
    
    //ajouter question lié à l'interface
    
    public void addEntity2(Questions Q) {
        String requete = "INSERT INTO Questions(id_Quiz,Question,PropositionA,PropositionB,PropositionC,id_BonneReponse)" +
                 "VALUES( '" + 0 + "', '" + Q.getQuestion() + "', '" + Q.getPropositionA() +"', '" + Q.getPropositionB() +"', '" + Q.getPropositionC() +"', '" + Q.getId_BonneReponse() + "')";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question ajoutée");     
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
            updateQuizQuestionCounts(); 
    }
    
    
    
    //supprimer question par id_question
    public void deleteQuestion(int id_Question) {
        String requete = "DELETE FROM Questions WHERE id_Question='" + id_Question + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        updateQuizQuestionCounts();
        
        
    } 
  
    //mettre a jour question
    public void updateQuestion(Questions Q) {
        String requete = "UPDATE Questions SET id_Quiz='" + Q.getId_Quiz() + "', Question='" + Q.getQuestion() + "', PropositionA='" + Q.getPropositionA() + "', PropositionB='" + Q.getPropositionB() + "', PropositionC='" + Q.getPropositionC() + "', id_BonneReponse='" + Q.getId_BonneReponse() + "' WHERE id_Question='" + Q.getId_Question() + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question mise à jour");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
    
    //selectionner question par id question
    public Questions selectQuestion(int id_Question) {
        Questions question = new Questions();
        String requete = "SELECT * FROM Questions WHERE id_Question='" + id_Question + "'";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                question.setId_Question(rs.getInt("id_Question"));
                question.setId_Quiz(rs.getInt("id_Quiz"));
                question.setQuestion(rs.getString("Question"));
                question.setPropositionA(rs.getString("PropositionA"));
                question.setPropositionB(rs.getString("PropositionB"));
                question.setPropositionC(rs.getString("PropositionC"));
                question.setId_BonneReponse(rs.getString("id_BonneReponse"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return question;
    }
    
    
    //selectionner les questions appartenant a un quiz en mentionnant l'id quiz
    public static List<Questions> selectQuestionsByQuiz(int quizId) {
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

    
   
}
