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
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import static services.QuestionCRUD.selectQuestionsByQuiz;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class QuizCRUD implements EntityCRUD<Quiz> {
    
    //ajouter un quiz
        public void addEntity1(Quiz Q) {
        String requete = "INSERT INTO Quiz(id_Quiz, sujet_Quiz, nombre_questions, bareme) VALUES('" + Q.getId_quiz() + "', '" + Q.getSujet_quiz() + "', " + Q.getNb_question() + ", '" + Q.getBareme() + "')"; 
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        
    }
        //supprimer un quiz en mentionnant son id
        public void deleteQuiz(int id_quiz) {
        String requete = "DELETE FROM Quiz WHERE id_Quiz='" + id_quiz + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
        //selectionner un quiz par son id
        public Quiz selectQuiz(int id_quiz) {
        Quiz quiz = new Quiz();
        String requete = "SELECT * FROM Quiz WHERE id_Quiz='" + id_quiz + "'";
       
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                quiz.setId_quiz(rs.getInt("id_Quiz"));
                quiz.setSujet_quiz(rs.getString("sujet_Quiz"));
                quiz.setNb_question(rs.getInt("nombre_questions"));
                quiz.setBareme(rs.getString("bareme"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return quiz;
    }
        
        //update quiz
        public void updateQuiz(Quiz Q) {
        String requete = "UPDATE Quiz SET sujet_Quiz='" + Q.getSujet_quiz() + "', nombre_questions=" + Q.getNb_question() + ", bareme='" + Q.getBareme() + "' WHERE id_Quiz='" + Q.getId_quiz() + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz mis à jour");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
        
        
        //afficher les quiz disponibles dans la table quiz
        public static List<Quiz> selectQuizzes() {
    List<Quiz> quizzes = new ArrayList<>();
    String query = "SELECT * FROM Quiz";
    try {
        Statement statement = MyConnection.getInstance().getCnx().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            Quiz quiz = new Quiz(
                result.getInt("id_Quiz"),
                result.getInt("nombre_questions"),
                result.getString("sujet_Quiz"),
                result.getString("bareme")
            );
            quizzes.add(quiz);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return quizzes;
}
        

        // rafraichir le nombre de question d'un quiz sur la table question 
        //cette fonction est exécuté à chaque ajout ou suppression d'une question
        public static void updateQuizQuestionCounts() {
    String query = "UPDATE Quiz SET nombre_questions = (" +
                   "SELECT COUNT(*) FROM Questions WHERE Questions.id_Quiz = Quiz.id_Quiz" +
                   ")";
    try {
        Statement statement = MyConnection.getInstance().getCnx().createStatement();
        statement.executeUpdate(query);
        System.out.println("Quiz question counts updated successfully.");
    } catch (SQLException ex) {
        System.out.println("Error updating quiz question counts: " + ex.getMessage());
    }
        
}

        
}