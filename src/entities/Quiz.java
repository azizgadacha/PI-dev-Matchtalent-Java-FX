/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;


public class Quiz {
    private int id_quiz;
    int nb_question;
    public String sujet_quiz;
    public String bareme;

    
    public Quiz(int id_quiz, int nb_question, String sujet_quiz, String bareme) {
        this.id_quiz = id_quiz;
        this.nb_question = nb_question;
        this.sujet_quiz = sujet_quiz;
        this.bareme = bareme;
    }
    
        public Quiz(String sujet_quiz) {
        this.sujet_quiz = sujet_quiz;

    }
        
        public Quiz() {}
    
    

    public int getId_quiz() {
        return id_quiz;
    }

    public int getNb_question() {
        return nb_question;
    }

    public String getSujet_quiz() {
        return sujet_quiz;
    }

    public String getBareme() {
        return bareme;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public void setNb_question(int nb_question) {
        this.nb_question = nb_question;
    }

    public void setSujet_quiz(String sujet_quiz) {
        this.sujet_quiz = sujet_quiz;
    }

    public void setBareme(String bareme) {
        this.bareme = bareme;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id_quiz=" + id_quiz + ", nb_question=" + nb_question + ", sujet_quiz=" + sujet_quiz + ", bareme=" + bareme + '}';
    }
    
    
    
    
}
