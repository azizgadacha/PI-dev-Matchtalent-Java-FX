/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Questions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.MyConnection;


public class QuestionCRUD implements EntityCRUD<Questions> {
    public void addEntity(Questions Q) {
        String requete = "INSERT INTO Questions(id_Question,id_Quiz,Question,PropositionA,PropositionB,PropositionC,id_BonneReponse)" +
                 "VALUES('" + Q.getId_Question() + "', '" + Q.getId_Quiz() + "', '" + Q.getQuestion() + "', '" + Q.getPropositionA() +"', '" + Q.getPropositionB() +"', '" + Q.getPropositionC() +"', '" + Q.getId_BonneReponse() + "')";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        
    }
    
    public void deleteQuestion(int id_Question) {
        String requete = "DELETE FROM Questions WHERE id_Question='" + id_Question + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
    
    public void updateQuestion(Questions Q) {
        String requete = "UPDATE Questions SET id_Quiz='" + Q.getId_Quiz() + "', Question='" + Q.getQuestion() + "', PropositionA='" + Q.getPropositionA() + "', PropositionB='" + Q.getPropositionB() + "', PropositionC='" + Q.getPropositionC() + "', id_BonneReponse='" + Q.getId_BonneReponse() + "' WHERE id_Question='" + Q.getId_Question() + "'";
        try {
            Statement st =  MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Question mise à jour");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
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
    
   
}
