/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import entities.Questions;
import entities.Quiz;
import java.util.List;
import services.QuestionCRUD;
import static services.QuestionCRUD.selectQuestionsByQuiz;
import services.QuizCRUD;
import utils.MyConnection;


public class MainClass {
    
    public static void main(String[] args) {

        MyConnection conn = new MyConnection();
       
       // creation et fonctionalités liés aux quiz
       
       
        //Quiz test = new Quiz(6," quiz","");
        //Quiz test=new Quiz();
        //QuizCRUD pc= new QuizCRUD();
        //test =pc.selectQuiz(0);
        //pc.updateQuiz(test);
        //System.out.println(test);
        
        //pc.addEntity1(test);
        //pc.deleteQuiz(9);
        //pc.updateQuiz(test);
        
        
        // creation et fonctionalités liés aux question
        
        //Questions test2 = new Questions(3,"pidev ?","proposition lowla","proposition thenya","proposition theltha","A");
        //QuestionCRUD pc2= new QuestionCRUD();
        //Questions 
        //pc2.addEntity(test2);
        
        //pc2.deleteQuestion(18);
        //test2.setPropositionB("beja");
        //pc2.updateQuestion(test2);
        //Questions b = pc2.selectQuestion(15);
        //System.out.println(b);
        
        
        //Questions test = new Questions("chneya esmk");
        //QuestionCRUD pcd= new QuestionCRUD();
        //System.out.println(pcd.entitiesList());
        
        // select all quizzes
        
        
    //List<Quiz> quizzes = pc.Affichertout() ;
     //print out the details of each quiz
    //for (Quiz quiz : quizzes) {
       //System.out.println("ID: " + quiz.getId_quiz());
       // System.out.println("Subject: " + quiz.getSujet_quiz());
       // System.out.println("Number of questions: " + quiz.getNb_question());
       // System.out.println("Scoring system: " + quiz.getBareme());
       // System.out.println("-------------------------"); 
    
      // System.out.println(quizzes);
    
    
    //List<Questions> questions = selectQuestionsByQuiz(0);
    //for (Questions question : questions) {
    //System.out.println(question);}
 
    
    /*
    List<Questions> questions = selectQuestionsByQuiz(8);
    String bareme = "";
    for (Questions question : questions) {
    bareme += question.id_BonneReponse;
    }
    System.out.println(bareme);  
    test.setBareme(bareme);
    pc.updateQuiz(test);  */
 
}
      
//}


}
