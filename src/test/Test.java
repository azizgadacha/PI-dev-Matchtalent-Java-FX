/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Postulaion;
import entities.annonce;
import entities.utilisateur;
import services.CondudatureService;
import utils.MyDB;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hend
 */
public class Test {
    
    
    
    public static void main(String[] args) throws SQLException {
       // (new CondudatureService()).ajouter(new Postulaion(new annonce(5),new utilisateur(5),"accepter","cv","lettre"));
        ArrayList<Postulaion> p= (ArrayList<Postulaion>) (new CondudatureService()).recuperer();
        for (Postulaion l : p){
            System.out.println(l.getCv());
        }
    }
}

