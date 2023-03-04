/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Enum.Statut;
import utils.Enum.TypeReclamation;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class ReclamationService implements IReclamationService<reclamation>{
    
     Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //String dateString = sdf.format(t.getDate());

    @Override
    public void ajouter(reclamation t) throws SQLException {
        String req = "INSERT INTO reclamation(id_utilisateur,description,titre,type,date) VALUES(?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getUtilisateur().getId_utilisateur());
        //ps.setInt(1, t.getId_utilisateur());
        ps.setString(2, t.getDescription());
        System.out.println(" ummm ");
        ps.setString(3, t.getType().toString());
        System.out.println(" nooo ");
        ps.setString(4, t.getTitre());
       // ps.setString(4, t.getType().toString());
       // ps.setDate(5, t.getDate());
        //ps.setDate(4, java.sql.Date.valueOf(t.getDate()));
         ps.setObject(5, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        ps.executeUpdate();
    }
    
    @Override
    public void modifier(reclamation t) throws SQLException {
       String req = "UPDATE reclamation  SET id_reclamation = ?,description= ?,titre = ?, date=? where Id_utilisateur = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_reclamation());
        ps.setString(2, t.getDescription());
        ps.setString(3, t.getTitre());
        /*ps.setString(4, t.getType().toString());*/
        ps.setObject(4, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        //ps.setInt(5, t.getUtilisateur().getId_utilisateur());
        ps.setInt(5, t.getId_utilisateur());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(reclamation t) throws SQLException {
        String req = "DELETE FROM reclamation  WHERE id_reclamation = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_reclamation());
        ps.executeUpdate();
        System.out.println("ena nemchi");
    }

    @Override
    public List<reclamation> recuperer() throws SQLException {
       List<reclamation> reclamations = new ArrayList<>();
        String s = "select * from reclamation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            reclamation p = new reclamation();
            p.setDescription(rs.getString("description"));
            p.setTitre(rs.getString("titre"));
            //p.setType(TypeReclamation.TechnicalIssues);
            p.setDate(rs.getDate("date"));
            //p.setStatut(Statut.Solved);
            //p.setId_reclamation(rs.getInt("id_reclamation"));
            
            
            reclamations.add(p);
            
        }
        return reclamations;
    }
    
   
    /*public void BazTawTeslek(){
        
    }*/
    
    public ObservableList<reclamation> afficherReclamationList() throws SQLException
 { 
       ObservableList<reclamation> reclamation = FXCollections.observableArrayList();


       
    
    
            String query = "SELECT `titre`, `type`, `description`, `date`, `statut` FROM `reclamation`";
             PreparedStatement ps = cnx.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                reclamation r = new reclamation();
                System.out.println("heeeeend " + rs.getString(1) );
                r.setTitre(rs.getString(1));
                 System.out.println("heeeeend " + rs.getString(2) );
                r.setType(TypeReclamation.valueOf(rs.getString(2)));
                System.out.println("heeeeend " + rs.getString(3) );
                r.setDescription(rs.getString(3));
                System.out.println("heeeeend " + rs.getDate(4) );
                r.setDate(rs.getDate("date"));
                 //System.out.println("heeeeend " + rs.getString(5) );
                //r.setStatut(Statut.valueOf(rs.getString(5)));
                 try {
            r.setStatut(Statut.valueOf(rs.getString(5)));
        } catch (IllegalArgumentException e) {
            // handle unrecognized Statut values here, e.g.
            r.setStatut(Statut.NotYet);
        }
                

           reclamation.add(r);
            }

       
        return reclamation;
    }
 
}


