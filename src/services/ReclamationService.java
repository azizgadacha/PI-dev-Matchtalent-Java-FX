/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class ReclamationService implements IService<reclamation>{
    
     Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(reclamation t) throws SQLException {
        String req = "INSERT INTO reclamation(id_utilisateur,description,titre,type,date) VALUES(?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_utilisateur());
        ps.setString(2, t.getDescription());
        ps.setString(3, t.getTitre());
        ps.setString(4, t.getType());
        ps.setDate(5, t.getDate());
        ps.executeUpdate();
    }

    @Override
    public void modifier(reclamation t) throws SQLException {
       String req = "UPDATE reclamation  SET id_reclamation = ?,description= ?,titre = ?,type=?, date=? where Id_utilisateur = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_reclamation());
        ps.setString(2, t.getDescription());
        ps.setString(3, t.getTitre());
        ps.setString(4, t.getType());
        ps.setDate(5, t.getDate());
        ps.setInt(6, t.getId_utilisateur());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(reclamation t) throws SQLException {
        String req = "DELETE FROM reclamation  WHERE id_reclamation = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_reclamation());
        ps.executeUpdate();
    }

    @Override
    public List<reclamation> recuperer(reclamation t) throws SQLException {
       List<reclamation> reclamations = new ArrayList<>();
        String s = "select * from reclamation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            reclamation p = new reclamation();
            p.setDescription(rs.getString("description"));
            p.setTitre(rs.getString("titre"));
            p.setType(rs.getString("type"));
            p.setId_reclamation(rs.getInt("id_reclamation"));
            
            
            reclamations.add(p);
            
        }
        return reclamations;
    }

   
}
