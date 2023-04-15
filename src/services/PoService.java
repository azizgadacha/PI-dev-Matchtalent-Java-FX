package services;

import entities.File;
import entities.Postulation;
import entities.annonce;
import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PoService {
    Connection cnx;
    public PoService() {
        cnx = MyDB.getInstance().getCnx();
    }
    public List<Postulation> getSpecified(annonce Annonce) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from postulation,utilisateur,annonce,file  where postulation.id_annonce=annonce.id_annonce and postulation.id_utilisateur=utilisateur.id and annonce.id_annonce =? and postulation.etat= 'en cours' and file.id_utilisateur =utilisateur.id");
       s.setInt(1,5);

        ResultSet resultat = s.executeQuery();
        ObservableList<Postulation> ListePostulation= FXCollections.observableArrayList();

        while (resultat.next()) {

            File e = new File();
            e.setIdFile(resultat.getInt("id_file"));
            e.setIdUtilisateur(resultat.getInt("id_utilisateur"));
            e.setCv(resultat.getBytes("cv"));
            e.setDeplome(resultat.getBytes("deplome"));
            e.setLettremotivation(resultat.getBytes("lettermotivation"));
            e.setNameCV(resultat.getString("nameCv"));
            e.setNamedeplome(resultat.getString("nameDeplome"));
            e.setNamelettreMotivation(resultat.getString("nameMotivation"));
            ListePostulation.add(new Postulation(new annonce(resultat.getInt("id_annonce")),new Utilisateur(resultat.getInt("id"),resultat.getString("username"),resultat.getString("email"),resultat.getString("contact"),resultat.getString("address")),resultat.getString("etat"),e));
        }
        return ListePostulation;
    }
    public int supprimer(Postulation postulation) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("delete from postulation  where postulation.id_anonce=? and postulation.id_demandeur=? ");
       s.setInt(1,postulation.getAnnonce().getId_annonce());
       s.setInt(2,postulation.getUtilisateur().getId());
         s.executeUpdate();

        return s.executeUpdate();
    }
    public int modifier(Postulation postulation,String etat) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("update postulation  set postulation.etat=? where id_annonce=? and id_demandeur=? ");
       s.setString(1,etat);
       s.setInt(2,postulation.getAnnonce().getId_annonce());
       s.setInt(3,postulation.getUtilisateur().getId());
         s.executeUpdate();

        return s.executeUpdate();
    }

}

