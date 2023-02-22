package services;

import entities.Postulaion;
import entities.annonce;
import entities.candidature;
import entities.utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CondidatureService implements IService<candidature> {
    Connection cnx;
    public CondidatureService() {
        cnx = MyDB.getInstance().getCnx();
    }




    @Override
    public void ajouter(candidature o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("INSERT INTO candidature(id_annonce,id_demandeur,note,reponse) VALUES(?,?,?,?)");
            s.setInt(1, o.getAnnonce().getId_annonce());
            s.setInt(2, o.getUtilisateur().getId());
            s.setFloat(3, o.getNote());
            s.setString(4, o.getReponse());
             s.executeUpdate();
            System.out.println("succesful ");

        }

    @Override
    public void modifier(candidature o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("update  candidature set note=?,reponse=? where  id_annonce=? and id_candidature=? ");
            s.setFloat(1, o.getNote());
            s.setString(2, o.getReponse());
            s.setInt(3, o.getAnnonce().getId_annonce());
            s.setInt(4, o.getId_candidature());
             s.executeUpdate();
            System.out.println("succesful ");

    }

    @Override
    public void supprimer( candidature p) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("delete from candidature where  id_candidature=?");
            s.setInt(1, p.getId_candidature());
            s.executeUpdate();
            System.out.println("succesful ");
    }

    @Override
    public List recuperer() throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from candidature,utilisateur where candidature.id_demandeur=utilisateur.id  ");
        ObservableList<candidature> candidatureListe= FXCollections.observableArrayList();
        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            //         public Postulaion(entities.annonce annonce, entities.utilisateur utilisateur, String etat, String cv, String lettre_motivation) {
            resultat.getInt("id_annonce");
            candidatureListe.add(new candidature( resultat.getInt("id_candidature"), new utilisateur(resultat.getInt("id_demandeur"),resultat.getString("username"),resultat.getString("email"),resultat.getString("contact"),resultat.getString("address"),resultat.getString("biographie"),resultat.getString("nom_societé"),resultat.getString("role")),new annonce(resultat.getInt( "id_annonce")),resultat.getInt("note"),resultat.getString("reponse")));
        }
        return candidatureListe;
    }
}
