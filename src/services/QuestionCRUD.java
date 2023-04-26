/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static services.QuizCRUD.updateQuizQuestionCounts;
import utils.MyDB;


public class QuestionCRUD {
        private Connection c = MyDB.getInstance().getCnx();
        PreparedStatement ps;


     //ajouter question
    public void addEntity(Questions Q) {
        String requete = "INSERT INTO Questions(id_Question,id_Quiz,Question,PropositionA,PropositionB,PropositionC,id_BonneReponse)" +
                 "VALUES('" + Q.getId_Question() + "', '" + Q.getId_Quiz() + "', '" + Q.getQuestion() + "', '" + Q.getPropositionA() +"', '" + Q.getPropositionB() +"', '" + Q.getPropositionC() +"', '" + Q.getId_BonneReponse() + "')";
        try {
            Statement st =  MyDB.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question ajoutée");       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
            updateQuizQuestionCounts();   
    }
    
    //ajouter question lié à l'interface
    
    public void addEntity2(Questions Q,int quizId) {
 String requete = "INSERT INTO Questions(id_Quiz, Question, PropositionA, PropositionB, PropositionC, id_BonneReponse, state) VALUES (?, ?, ?, ?, ?, ?, 1)";
    try {
        ps = c.prepareStatement(requete);
        ps.setInt(1, quizId);
        ps.setString(2, Q.getQuestion());
        ps.setString(3, Q.getPropositionA());
        ps.setString(4, Q.getPropositionB());
        ps.setString(5, Q.getPropositionC());
        ps.setString(6, Q.getId_BonneReponse());
        ps.executeUpdate();
        System.out.println(Q); 
        System.out.println("Question ajoutée");    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
            updateQuizQuestionCounts(); 
    }
    
    
    
    //supprimer question par id_question
    /*public void deleteQuestion(int id_Question) {
        String requete = "DELETE FROM Questions WHERE id_Question='" + id_Question + "'";
        try {
            Statement st =  MyDB.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        updateQuizQuestionCounts();
        
        
    } */
           public void Supprimer(int id_Question) throws SQLException {
        PreparedStatement ps;

        String query = "UPDATE questions SET state=? WHERE id_Question='"+id_Question+"'";
  
        try {
            ps = c.prepareStatement(query);

            ps.setInt(1,0);
            ps.execute();

            System.out.println("suppression de question");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
  
    //mettre a jour question
    public void updateQuestion(Questions Q) {
        String requete = "UPDATE Questions SET  Question='" + Q.getQuestion() + "', PropositionA='" + Q.getPropositionA() + "', PropositionB='" + Q.getPropositionB() + "', PropositionC='" + Q.getPropositionC() + "', id_BonneReponse='" + Q.getId_BonneReponse() + "' WHERE id_Question='" + Q.getId_Question() + "'";
        try {
            Statement st =  MyDB.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question mise à jour");
            System.out.println(Q);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
    
    //selectionner question par id question
    public Questions selectQuestion(int id_Question) {
        Questions question = new Questions();
        String requete = "SELECT * FROM Questions WHERE id_Question='" + id_Question + "' AND state='1'";
        try {
            Statement st = MyDB.getInstance().getCnx().createStatement();
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
    String query = "SELECT * FROM Questions WHERE id_Quiz = '" + quizId + "'AND state='1'";
    try {
        Statement statement = MyDB.getInstance().getCnx().createStatement();
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
