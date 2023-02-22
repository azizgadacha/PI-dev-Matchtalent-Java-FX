package services;

import entities.rendez_vous;
import utils.MyDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        s.setInt(3, o.getAnnonce().getId_annonce());
        s.setInt(4, o.getId_candidature());
        s.executeUpdate();
        System.out.println("succesful ");
    }

    @Override
    public void supprimer(rendez_vous rendez_vous) throws SQLException {

    }

    @Override
    public List<rendez_vous> recuperer() throws SQLException {
        return null;
    }
}
