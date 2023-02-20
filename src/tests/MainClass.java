/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import entities.Questions;
import entities.Quiz;
import services.QuestionCRUD;
import services.QuizCRUD;
import utils.MyConnection;


public class MainClass {
    
    public static void main(String[] args) {

        MyConnection conn = new MyConnection();
        Quiz test = new Quiz(1,3,"awel quiz","bien bien bien");
        QuizCRUD pc= new QuizCRUD();
        //pc.addEntity1(test);
        //pc.deleteQuiz(12);
        //String a = pc.selectQuiz(1).toString();
        //System.out.println(a);
        //test.setNb_question(8);
        //pc.updateQuiz(test);
        
        
        //Questions test2 = new Questions(1,1,"win jet rades?","ariana","tounes","ben arous","C");
        //QuestionCRUD pc2= new QuestionCRUD();
        //pc2.addEntity(test2);
        //pc2.deleteQuestion(12);
        //test2.setPropositionB("beja");
        //pc2.updateQuestion(test2);
        //String b = pc2.selectQuestion(1).toString();
        //System.out.println(b);
        
        
        //Questions test = new Questions("chneya esmk");
        //QuestionCRUD pcd= new QuestionCRUD();
        //System.out.println(pcd.entitiesList());

    
    
    
    
    
    }
    

    
}
