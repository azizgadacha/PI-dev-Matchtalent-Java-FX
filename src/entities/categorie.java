/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.MyDB;

/**
 *
 * @author acer
 */
public class categorie {
    
     private int id_categorie;
    private String nom_categorie;

    public categorie() {
    }

    public categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
      
    }

    public categorie(int aInt, String string) {
        this.id_categorie = aInt;
        this.nom_categorie = string;


    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + '}';
    }

    public void updatecategorie() {
         try {
            Connection cnx = MyDB.getInstance().getCnx();
            String query = "UPDATE categorie SET nom_categorie = ? WHERE id_categorie = ?";
            PreparedStatement st = cnx.prepareStatement(query);
            st.setString(1, this.nom_categorie);
            st.setInt(2, this.id_categorie);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimercategorie() {
         try {
        Connection cnx = MyDB.getInstance().getCnx();
        String query = "DELETE FROM categorie WHERE nom_categorie = ?";
        PreparedStatement ps = cnx.prepareStatement(query);
        ps.setString(1, this.nom_categorie);
        ps.executeUpdate();
       
    } catch (SQLException ex) {
        System.err.println("Error deleting category: " + ex.getMessage());
    }
    }

    public void setNom(categorie categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

 






