/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Annonce;
import entities.File;
import entities.Postulation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author Istabrak
 */
public class PostulationService{
        Connection cnx;

    public PostulationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    public void ajouter(Postulation t) throws SQLException {


        String req = "INSERT INTO `postulation`(`id_annonce`, `id_utilisateur`, `etat`, `id_file`, `date`) VALUES(?,?,?,?,?)";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, t.getIdAnnonce());
        st.setInt(2, t.getIdUtilisateur());
        st.setString(3, "En attent");
        st.setInt(4, t.getIdFile());
        st.setDate(5, t.getDate());
        st.executeUpdate();
    }

    public boolean modifier(Postulation t) throws SQLException {
        java.sql.Date sqlDate2 = new java.sql.Date(t.getDate().getTime());
      String req = "UPDATE postulation  SET etat= ?,id_file=?, date=? where id = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setObject(1, t.getEtat());
        st.setInt(2, t.getIdFile());
        st.setDate(3, sqlDate2);
        st.setInt(4, t.getId());
        st.executeUpdate(); 
        return true ;
    }

     
    public boolean supprimer(int id) throws SQLException {
               try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM postulation WHERE id="+id ;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Postulation> recuperer(Postulation t) throws SQLException {
      List<Postulation> postulations = new ArrayList<>();
        String s = "select * from postulation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Postulation p = new Postulation();
////        p.setEtat(rs.getEtat());
            p.setIdAnnonce(rs.getInt("id_annonce"));
            p.setIdUtilisateur(rs.getInt("id_utilisateur"));
            p.setIdFile(rs.getInt("id_file"));
//            p.setDate(rs.getDate("date");
            
            
            postulations.add(p);
            
        }
        return postulations;
    }
    
    
    
    
        public ObservableList<Postulation> getAllPostulationUser( int idu) throws SQLDataException {

        
        List<Postulation> list =new ArrayList<Postulation>();
        int count =0;
        
        String requete="select * from postulation where id_utilisateur="+idu;
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Postulation p = new Postulation();
            p.setEtat(rs.getString("etat"));
            p.setId(rs.getInt("id"));
            p.setIdAnnonce(rs.getInt("id_annonce"));
            p.setIdUtilisateur(rs.getInt("id_utilisateur"));
            p.setIdFile(rs.getInt("id_file"));
            p.setDate(rs.getDate("date"));
                
                list.add(p);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
        
        
        
   public ObservableList<Postulation> getAllPostulation() throws SQLDataException {

        
        List<Postulation> list =new ArrayList<Postulation>();
        int count =0;
        
        String requete="select * from postulation ";
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                Postulation p = new Postulation();
            p.setEtat(rs.getString("etat"));
            p.setId(rs.getInt("id"));
            p.setIdAnnonce(rs.getInt("id_annonce"));
            p.setIdUtilisateur(rs.getInt("id_utilisateur"));
            p.setIdFile(rs.getInt("id_file"));
            p.setDate(rs.getDate("date"));

                
                list.add(p);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
   
   
       public boolean Accepter(Postulation f) throws SQLException {
        
                       
                String query = "UPDATE `postulation` SET `etat`=? WHERE `id` = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setString(1,"Accepter");
                st.setInt(2,f.getId());

                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             

    }
       
       
       
              public boolean Refuser(Postulation f) throws SQLException {
        
                       
                String query = "UPDATE `postulation` SET `etat`=? WHERE `id` = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                    st.setString(1,"Réfuser");
                st.setInt(2,f.getId());

                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             

    }
              
              
              
              
   public Postulation get_PostulationById(int i) {
        Postulation p = new Postulation();
        int nombre = 0;
        String requete = "select * from postulation where id="+i;
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            p.setEtat(rs.getString("etat"));
            p.setIdAnnonce(rs.getInt("id_annonce"));
            p.setIdUtilisateur(rs.getInt("id_utilisateur"));
            p.setIdFile(rs.getInt("id_file"));
            p.setDate(rs.getDate("date"));
                nombre++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;

    }
   
   
   
   
      public Annonce get_AnnonceById(int i) {
        Annonce p = new Annonce();
        int nombre = 0;
        String requete = "select * from annonce where id_annonce="+i ;
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            p.setNom_societe(rs.getString("nom_societé"));
            p.setTitre(rs.getString("titre"));

                nombre++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;

    }
      
      
      
      public int MaxIdFile() {
        int nombre = 0;
        String requete = "select Max(id_file) from file";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             nombre =rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return nombre;

    }
      
      
      
  
}
