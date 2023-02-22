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
        PreparedStatement s = cnx.prepareStatement("INSERT INTO rendez_vous(id_user,date_rendez_vous,Heure_rendez_vous,id_annonce,) VALUES(?,?,?,?)");
        s.setInt(1, rendez_vous.getUser().getId());
        s.setDate(2, (Date) rendez_vous.getDate_rendez_vous());
        s.setString(3, rendez_vous.getHeure_rendez_vous());
        s.setInt(4, rendez_vous.getAnnonce().getId_annonce());
        s.executeUpdate();
        System.out.println("succesful ");
    }

    @Override
    public void modifier(rendez_vous rendez_vous) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("update  rendez_vous set date_rendez_vous=?,Heure_rendez_vous=? where  id_rendez_vous=?  ");
        s.setDate(1, (Date) rendez_vous.getDate_rendez_vous());
        s.setString(2,rendez_vous.getHeure_rendez_vous());
        s.setInt(3, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");
    }

    @Override
    public void supprimer(rendez_vous rendez_vous) throws SQLException {
        PreparedStatement s = cnx.prepareStatement("delete from candidature where  id_rendez_vous=?");
        s.setInt(1, rendez_vous.getId_rendez_vous());
        s.executeUpdate();
        System.out.println("succesful ");
    }

    @Override
        public List<rendez_vous> recuperer() throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from rendez_vous,utilisateur,annonce where rendez_vous.id_user=utilisateur.id and annonce.id_annonce=rendez_vous.id_annonce  ");
        ObservableList<rendez_vous> rendez_vousListe= FXCollections.observableArrayList();
        ResultSet resultat = s.executeQuery();

        while (resultat.next()) {
            rendez_vousListe.add(new rendez_vous(new utilisateur(resultat.getInt("id_user")),resultat.getDate("date_rendez_vous"),resultat.getString("Heure_rendez_vous"),new annonce(resultat.getInt("id_annonce"),resultat.getString("titre"),resultat.getString("categorie"),resultat.getString("nom_societé"))));
        }
        return rendez_vousListe;
    }
}
