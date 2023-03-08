/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class UserService implements IUserService{
Connection cnx;
PreparedStatement ps;
    public UserService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    public int getIdUser(String username, String email) {
      
    ResultSet rs;
        int nb = 0;
        int id_utilisateur = -1;
        try {
            String req = "SELECT id_utilisateur FROM utilisateur where email_canonical = ? AND email = ? AND username_canonical = ? AND username = ?";
            ps = cnx.prepareStatement(req);
            ps.setString(1, email);
            ps.setString(2, email);
            ps.setString(3, username);
            ps.setString(4, username);
            rs = ps.executeQuery(req);
            while (rs.next()) {
                nb++;
                id_utilisateur = rs.getInt("id_utilisateur");
            }
            if (nb > 1) {
//                System.out.println("Il y'a plus qu'un user ayant ces informations !");
                return id_utilisateur;
            }
            if (nb < 1) {
//                System.out.println("Il y'a pas de user ayant ces informations !");
                return id_utilisateur;
            }
            return id_utilisateur; // nb == 1

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echech de récuperaton de l'ID !");
            return id_utilisateur;
        }
    }

    @Override
    public utilisateur getUserById(int id_utilisateur) {
       utilisateur u = null;
        try {
            String req = "SELECT * FROM `utilisateur` WHERE id_utilisateur = '" + id_utilisateur + "'";
            ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
                u = new utilisateur(id_utilisateur, rs.getString("username"), rs.getString("email"));     

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec get User");
            return u;
        }
        return u;
    }

    @Override
    public utilisateur getUserByUsername(String username) {
          utilisateur u = null;
        try {
            String req = "SELECT * FROM `utilisateur` WHERE username = '" + username + "'";
            ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (rs.first()) {
                u = new utilisateur(rs.getInt("id_utilisateur"),rs.getString("username"), rs.getString("email"));
                        }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Echec get User");
            return u;
        }
        return u;
    }

    }

   
    

