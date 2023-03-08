/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import entities.notification;
import entities.reclamation;
import entities.reponse_reclamation;
import entities.utilisateur;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import services.NotificationService;
import services.ReclamationService;
import services.Reponse_ReclamationService;
import services.UserService;
import utils.Enum.TypeReclamation;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class MainReclamation {
    
    
    
    public static void main(String[] args){
         TypeReclamation type1 = TypeReclamation.T;
        TypeReclamation type2 = TypeReclamation.S;
        TypeReclamation type3 = TypeReclamation.C;
        utilisateur utilisateur ;
        //UserService us = new UserService();
        //utilisateur = us.getUserById(1);
              try {
             /*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");*/
         reclamation p = new reclamation(new utilisateur(1), "desc", "titre",type1, new Date());
        ReclamationService ps = new ReclamationService();
        System.out.println("h01");
            ps.ajouter(p);
           System.out.println("h02");
           ps.modifier(p);
            System.out.println("h03");
            ps.supprimer(p);
            System.out.println("h04");
            System.out.println(ps.recuperer());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
              try {
             /*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");*/
             
            notification n = new notification(1,"description", new Date());
        NotificationService nt = new NotificationService();
        System.out.println("h001");
          nt.ajouter(n);
           System.out.println("h002");
           nt.modifier(n);
           System.out.println("h003");
           nt.supprimer(n);
           System.out.println("h004");
           System.out.println(nt.recuperer(n));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
          try {
             /*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");*/
             //LocalDateTime dateTime = LocalDateTime.of(2023, Month.FEBRUARY, 20, 12, 30);
            reponse_reclamation r = new reponse_reclamation(new reclamation(1),"reponse", new Date());
        Reponse_ReclamationService rp = new Reponse_ReclamationService();
        System.out.println("h0001");
            rp.ajouter(r);
            System.out.println("h0002");
            rp.modifier(r);
            System.out.println("h0003");
            rp.supprimer(r);
            System.out.println("h0004");
            System.out.println(rp.recuperer());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             
       
    }
}
             
      

