/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Postulation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Istabrak
 */
public class PostulationService implements IService<Postulation>{
        Connection cnx;

    public PostulationService() {
        cnx = MyDB.getInstance().getCnx();
    }

     @Override
    public void ajouter(Postulation t) throws SQLException {
         String req = "INSERT INTO `postulation`(`id_annonce`, `id_utilisateur`, `etat`, `id_file`, `date`) VALUES(?,?,?,?,?)";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, t.getIdAnnonce());
        st.setInt(2, t.getIdUtilisateur());
        st.setString(3, t.getEtat());
        st.setInt(4, t.getIdFile());
        st.setDate(5, t.getDate());
        st.executeUpdate();
    }

     @Override
    public void modifier(Postulation t) throws SQLException {
      String req = "UPDATE postulation  SET etat= ?,id_file=?, date=? where Id_utilisateur = ? and Id_annonce = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setString(1, t.getEtat());
        st.setInt(2, t.getIdFile());
        st.setDate(3, t.getDate());
        st.setInt(4, t.getIdUtilisateur());
        st.setInt(5, t.getIdAnnonce());
        st.executeUpdate();  }

     @Override
    public void supprimer(Postulation t) throws SQLException {
        String req = "DELETE FROM postulation  WHERE id_annonce = ? and id_utilisateur = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, t.getIdAnnonce());
        st.setInt(2, t.getIdUtilisateur());
        st.executeUpdate();  }

        @Override
    public List<Postulation> recuperer(Postulation t) throws SQLException {
      List<Postulation> postulations = new ArrayList<>();
        String s = "select * from postulation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Postulation p = new Postulation();
            p.setEtat(rs.getString("etat"));
            p.setIdAnnonce(rs.getInt("id_annonce"));
            p.setIdUtilisateur(rs.getInt("id_utilisateur"));
            p.setIdFile(rs.getInt("id_file"));
            p.setDate(Date.valueOf(LocalDate.MAX));
            
            
            postulations.add(p);
            
        }
        return postulations;
    }
}
