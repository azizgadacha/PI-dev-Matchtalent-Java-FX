/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Annonce;
import entities.categorie;
import java.sql.Date;
import java.sql.SQLException;
import services.AnnonceService;
import services.CategorieService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;


/**
 *
 * @author acer
 */
public class Test {
    
    
    
    public static void main(String[] args){
       try {
            categorie c = new categorie("informatique" );

            CategorieService ps = new CategorieService();
            ps.ajouter(c);
            System.out.println("add");
            ps.modifier(c);
            System.out.println("update");
            ps.supprimer(c);
            System.out.println("supprimer");
           System.out.println(ps.recuperer());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
//        try {
//Date d1=Date.valueOf("04/03/2023");
//Date d2=Date.valueOf("08/03/2023");
//            Annonce a = new Annonce( 1,1,"test", "iset","desc", "cdd","doc", d1, d2   );
//
//            AnnonceService ps = new AnnonceService();
//            ps.ajouter(a);
//            System.out.println("add");
////            ps.modifier(a);
////            System.out.println("update");
//           // ps.supprimer(a);
//           // System.out.println("supprimer");
//           System.out.println(ps.recuperer());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//categorie c = new categorie();
//Annonce a = new Annonce();
    }}