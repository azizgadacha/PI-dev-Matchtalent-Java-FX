package services;

import entities.annonce;
import entities.candidature;
import entities.rendez_vous;
import entities.utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.*;
import java.util.List;

public class Rendez_vous_service implements IService<rendez_vous> {
    Connection cnx;
    public Rendez_vous_service() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(rendez_vous rendez_vous) throws SQLException {
       try {

           java.sql.Date sqlDate = new java.sql.Date(rendez_vous.getDate_rendez_vous().getTime());

        PreparedStatement s = cnx.prepareStatement("INSERT INTO rendez_vous(id_user,date_rendez_vous,Heure_rendez_vous,id_annonce) VALUES(?,?,?,?)");
        s.setInt(1, rendez_vous.getUser().getId());
        s.setDate(2,  sqlDate);
        s.setString(3, rendez_vous.getHeure_rendez_vous());
        s.setInt(4, rendez_vous.getAnnonce().getId_annonce());
        s.executeUpdate();
        System.out.println("succesful ");
    }catch (Exception e){
           System.out.println(e);
       }
    }

    @Override
    public void modifier(rendez_vous rendez_vous) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(rendez_vous.getDate_rendez_vous().getTime());

        PreparedStatement s = cnx.prepareStatement("update  rendez_vous set date_rendez_vous=?,Heure_rendez_vous=? where  id_rendez_vous=?  ");
        s.setDate(1, sqlDate);
        s.setString(2,rendez_vous.getHeure_rendez_vous());
        s.setInt(3, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");
    }

    @Override
    public void supprimer(rendez_vous rendez_vous) throws SQLException {
        try {
            System.out.println("hgr "+rendez_vous.getId_rendez_vous());
        PreparedStatement s = cnx.prepareStatement("delete from rendez_vous where  id_rendez_vous=?");
        s.setInt(1, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");
    }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
        public List<rendez_vous> recuperer() throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from rendez_vous,utilisateur,annonce where rendez_vous.id_user=utilisateur.id and annonce.id_annonce=rendez_vous.id_annonce  ");
        ObservableList<rendez_vous> rendez_vousListe= FXCollections.observableArrayList();
        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            System.out.println("d5alt mara");
            rendez_vousListe.add(new rendez_vous(resultat.getInt("id_rendez_vous"), new utilisateur(resultat.getInt("id_user"),resultat.getString("username")),resultat.getDate("date_rendez_vous"),resultat.getString("Heure_rendez_vous"),new annonce(resultat.getInt("id_annonce"),resultat.getString("titre"),resultat.getString("categorie"),resultat.getString("nom_societé"))));
        }
        return rendez_vousListe;
    }
    public List<rendez_vous> getSpecified(rendez_vous rdv) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from rendez_vous where date_rendez_vous=? and Heure_rendez_vous=? and  id_annonce=? ");

        java.sql.Date sqlDate = new java.sql.Date(rdv.getDate_rendez_vous().getTime());

        s.setDate(1, sqlDate);
        s.setString(2,rdv.getHeure_rendez_vous());
        s.setInt(3, rdv.getAnnonce().getId_annonce());




        ResultSet resultat = s.executeQuery();
        ObservableList<rendez_vous> rendez_vousListe= FXCollections.observableArrayList();

        while (resultat.next()) {
            rendez_vousListe.add(new rendez_vous(resultat.getInt("id_rendez_vous"),new utilisateur(resultat.getInt("id_user")),resultat.getDate("date_rendez_vous"),resultat.getString("Heure_rendez_vous"),new annonce(resultat.getInt("id_annonce"))));
        }
        return rendez_vousListe;
    }
}
