/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.notification;
import entities.reclamation;
import entities.reponse_reclamation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import services.NotificationService;
import services.ReclamationService;
import services.Reponse_ReclamationService;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class Test {
    
    
    
    public static void main(String[] args){
              try {
             /*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");*/
             LocalDate date = LocalDate.of(2023, Month.FEBRUARY, 20);
            reclamation p = new reclamation(1,"desc", "titre", "Technical issues", date, "Solved");
        ReclamationService ps = new ReclamationService();
        System.out.println("h01");
            ps.ajouter(p);
            System.out.println("h02");
            ps.modifier(p);
            System.out.println("h03");
            ps.supprimer(p);
            System.out.println("h04");
            System.out.println(ps.recuperer(p));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /*MyDB db = MyDB.getInstance();
        MyDB db2 = MyDB.getInstance();
        System.out.println(db);
        System.out.println(db2);*/
         try {
             /*SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");*/
             
            notification n = new notification(1,"description", new Date(17-02-2023));
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
             
            reponse_reclamation r = new reponse_reclamation(1,"reponse", new Date(20-01-2023));
        Reponse_ReclamationService rp = new Reponse_ReclamationService();
        System.out.println("h0001");
            rp.ajouter(r);
            System.out.println("h0002");
            rp.modifier(r);
            System.out.println("h0003");
            rp.supprimer(r);
            System.out.println("h0004");
            System.out.println(rp.recuperer(r));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
}

