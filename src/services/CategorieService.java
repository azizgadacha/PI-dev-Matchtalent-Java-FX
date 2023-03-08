/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author acer
 */
public class CategorieService implements IService<categorie>{
    
   Connection cnx;

    public CategorieService() {
      cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(categorie t) throws SQLException {
        String req = "INSERT INTO categorie(nom_categorie) VALUES(?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getNom_categorie());
        ps.executeUpdate();
    }

    @Override
    public void modifier(categorie t) throws SQLException {
       String req = "UPDATE categorie  SET nom_categorie = ? ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getNom_categorie());
        ps.executeUpdate();
    }


    @Override
    public void supprimer(categorie t) throws SQLException {
        String req = "DELETE FROM categorie  WHERE id_categorie = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_categorie());
        ps.executeUpdate();
    }

    @Override
    public List<categorie> recuperer() throws SQLException {
        ObservableList<categorie> categories = FXCollections.observableArrayList();
        String s = "select * from categorie";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            categorie c = new categorie();
            c.setNom_categorie(rs.getString("nom_categorie"));
c.setId_categorie(rs.getInt("id_categorie"));
            categories.add(c);
            
        }
        return categories;
    }
   
   

    
}
