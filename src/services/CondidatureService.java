package services;

import entities.Annonce;
import entities.Postulation;
import entities.candidature;
import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CondidatureService  {
    Connection cnx;
    public CondidatureService() {
        cnx = MyDB.getInstance().getCnx();
    }




    public void ajouter(candidature o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("INSERT INTO candidature(id_annonce,id_demandeur,note,reponse) VALUES(?,?,?,?)");
            s.setInt(1, o.getAnnonce().getId_annonce());
            s.setInt(2, o.getUtilisateur().getId());
            s.setFloat(3, o.getNote());
            s.setString(4, o.getReponse());
             s.executeUpdate();
            System.out.println("succesful ");

        }
        public void ajouter_from_postulation(Postulation o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("INSERT INTO candidature(id_annonce,id_demandeur,note,reponse) VALUES(?,?,?,?)");
            s.setInt(1, o.getIdAnnonce().getId_annonce());
            s.setInt(2, o.getUtilisateur().getId());
            s.setFloat(3, 0);
            s.setString(4, "");
             s.executeUpdate();
            System.out.println("succesful ");

        }


    public void modifier(candidature o) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("update  candidature set note=?,reponse=? where  id_annonce=? and id_candidature=? ");
            s.setFloat(1, o.getNote());
            s.setString(2, o.getReponse());
            s.setInt(3, o.getAnnonce().getId_annonce());
            s.setInt(4, o.getId_candidature());
             s.executeUpdate();
            System.out.println("succesful ");

    }


    public void supprimer( candidature p) throws SQLException {

            PreparedStatement s = cnx.prepareStatement("delete from candidature where  id_candidature=?");
            s.setInt(1, p.getId_candidature());
            s.executeUpdate();
            System.out.println("succesful ");
    }





    public List recupererSuivantannance(Annonce an) throws SQLException {
        System.out.println("salem"+an.getId_annonce());
        PreparedStatement s = cnx.prepareStatement("select * from candidature,utilisateur,annonce where candidature.id_annonce=annonce.id_annonce and candidature.id_demandeur=utilisateur.id and candidature.id_annonce=? and candidature.id_demandeur not in(select id_user from rendez_vous where id_annonce=?)");
        s.setInt(1,5);
        s.setInt(2, 5);

        ObservableList<candidature> candidatureListe= FXCollections.observableArrayList();

        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            candidatureListe.add(new candidature( resultat.getInt("id_candidature"), new Utilisateur(resultat.getInt("id_demandeur"),resultat.getString("username"),resultat.getString("email"),resultat.getString("contact"),resultat.getString("address"),resultat.getString("biographie"),resultat.getString("nom_societé")),new Annonce(resultat.getInt( "id_annonce")),resultat.getInt("note"),resultat.getString("reponse")));
        }
        return candidatureListe;
    }
}
