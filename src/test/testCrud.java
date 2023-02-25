package test;

import entities.annonce;
import entities.candidature;
import entities.rendez_vous;
import entities.utilisateur;
import services.CondidatureService;
import services.Rendez_vous_service;

import java.util.Date;
import java.sql.SQLException;

public class testCrud {

    public static void main(String[] args) throws SQLException {
        CondidatureService  rs= new CondidatureService();
                  //  public candidature(int id_candidature, entities.utilisateur utilisateur, entities.annonce annonce, float note, String reponse) {

        //    rs.ajouter(new candidature(new utilisateur(2,"test1"),new annonce(5),12,"aaaaaaaaaab"));
          //  rs.modifier(new candidature(1,new utilisateur(3,"test1"),new annonce(3),12,"aaaaaaaaaab"));
  //  rs.supprimer(new candidature(4));
        Rendez_vous_service rendezS=new Rendez_vous_service();
       // rendezS.modifier(new rendez_vous(5,new Date(),"8:16"));
        rendezS.supprimer(new rendez_vous(5));
    }
}
