/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Annonce;
import entities.Archive;
import entities.categorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author acer
 */
public class ArchiveService implements IService<Archive>{
    
    
        Connection cnx;

    public ArchiveService() {
      cnx = MyDB.getInstance().getCnx();
    }



   /* @Override
    public List<Archive> recuperer() throws SQLException {
      List<Archive> archives = new ArrayList<>();
        String s = "select * from annonceE";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Archive ar = new Archive();
            ar.setDescription(rs.getString("description"));
            ar.setDescription(rs.getString("nom-societe"));
            ar.setTitre(rs.getString("titre"));
            ar.setType_contrat(rs.getString("type-contrat"));
            ar.setTitre(rs.getString("titre"));
            ar.setDate_fin(rs.getDate("date_fin"));
            ar.setId_annonce(rs.getInt("id_annonce"));
            
            
            archives.add(ar);
            
        }
        return archives;
    }*/

    @Override
    public void ajouter(Archive t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Archive t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Archive t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Archive> recuperer() throws SQLException {
        List<Archive> archives = new ArrayList<Archive>();
        ArchiveService ps = new ArchiveService();
        AnnonceService annonces = new AnnonceService();
        String s = "select * from annonce  " ;
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);

        while(rs.next()){
            Annonce a = new Annonce();
            a.setDescription(rs.getString("description"));
            a.setDescription(rs.getString("nom-societe"));
            a.setTitre(rs.getString("titre"));
            a.setType_contrat(rs.getString("type-contrat"));
            a.setTitre(rs.getString("titre"));
            rs.getObject("dateDebut", LocalDateTime.class);
            rs.getObject("dateFin", LocalDateTime.class);
            a.setId_annonce(rs.getInt("id_annonce"));
             System.out.println(annonces);}return null;
}
public List<Annonce> getArchivedAnnonces() throws SQLException {
    List<Annonce> annonces = new ArrayList<>();
    String s = "SELECT * FROM archive";
    Statement st = cnx.createStatement();
    ResultSet rs =  st.executeQuery(s);
    while(rs.next()){
        Annonce a = new Annonce();
        a.setDescription(rs.getString("description"));
        a.setNom_societe(rs.getString("nom_societe"));
        a.setTitre(rs.getString("titre"));
        a.setType_contrat(rs.getString("type_contrat"));
       a.setCategorie(new categorie(rs.getInt("id_categorie"),rs.getString("nom_categorie")));
        a.setDateDebut(rs.getDate("dateDebut"));
        a.setDateFin(rs.getDate("dateFin"));
        a.setId_annonce(rs.getInt("id_annonce"));
        annonces.add(a);
    }
    return annonces;
}


}
            
            
        
 
    
    

