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
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class QuizCRUD implements EntityCRUD<Quiz> {
        public void addEntity1(Quiz Q) {
        String requete = "INSERT INTO Quiz(id_Quiz, sujet_Quiz, nombre_questions, bareme) VALUES('" + Q.getId_quiz() + "', '" + Q.getSujet_quiz() + "', " + Q.getNb_question() + ", '" + Q.getBareme() + "')"; 
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        
    }
        
        public void deleteQuiz(int id_quiz) {
        String requete = "DELETE FROM Quiz WHERE id_Quiz='" + id_quiz + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
        
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
        public void updateQuiz(Quiz Q) {
        String requete = "UPDATE Quiz SET sujet_Quiz='" + Q.getSujet_quiz() + "', nombre_questions=" + Q.getNb_question() + ", bareme='" + Q.getBareme() + "' WHERE id_Quiz='" + Q.getId_quiz() + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Quiz mis à jour");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
        
        
    
}
