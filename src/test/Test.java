/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.File;
//import entities.Postulation;
import entities.Type;
//import java.sql.Date;
import java.sql.SQLException;
import services.FileService;
//import services.PostulationService;

/**
 *
 * @author Istabrak
 */
public class Test {
  
    public static void main(String[] args) throws SQLException{
         
          // Postulation p = new Postulation(2,2,"accepter",1,new Date(20-02-2023));
          // PostulationService ps = new PostulationService();
           // ps.ajouter(p);
           // ps.modifier(p);
           // ps.supprimer(p);
           //System.out.println(ps.recuperer(p));
       
           
           File f = new File(1,Type.lettre_de_motivation,1);
           FileService fs = new FileService();
          // fs.ajouter(f);
          // fs.modifier(f);
          // fs.supprimer(f);
          System.out.println(fs.recuperer(f));
          
           
    }
}
