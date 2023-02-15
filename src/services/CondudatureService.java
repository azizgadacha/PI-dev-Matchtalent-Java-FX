package services;

import entities.Postulaion;
import entities.annonce;
import entities.utilisateur;
import utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CondudatureService implements IService{
    Connection cnx;
    public CondudatureService() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(Object o) throws SQLException {
        if (o.getClass() == Postulaion.class) {
            Postulaion p = (Postulaion) o;
            PreparedStatement s = cnx.prepareStatement("INSERT INTO postulation(id_annonce,id_demandeur,etat,cv,lettre_motivation) VALUES(?,?,?,?,?)");
            s.setInt(1, p.getAnnonce().getId_annonce());
            s.setInt(2, p.getUtilisateur().getId());
            s.setString(3, p.getEtat());
            s.setString(4, p.getCv());
            s.setString(5, p.getLettre_motivation());
             s.executeUpdate();
            System.out.println("succesful ");

        }else {
            System.out.println("desoler  vous aveze entrer un type invalide ");
        }
    }
    @Override
    public void modifier(Object o) throws SQLException {
        if (o.getClass() == Postulaion.class) {
            Postulaion p = (Postulaion) o;
            PreparedStatement s = cnx.prepareStatement("update  postulation set etat=? where  id_annonce=? and id_demandeur=? ");
            s.setString(1, p.getEtat());
            s.setInt(2, p.getAnnonce().getId_annonce());
            s.setInt(3, p.getUtilisateur().getId());
             s.executeUpdate();
            System.out.println("succesful ");

        }else {
            System.out.println("desoler  vous aveze entrer un type invalide ");
        }
    }

    @Override
    public void supprimer(Object o) throws SQLException {
        if (o.getClass() == Postulaion.class) {
            Postulaion p = (Postulaion) o;
            PreparedStatement s = cnx.prepareStatement("delete from postulation where  id_annonce=? and id_demandeur=?");
            s.setInt(1, p.getAnnonce().getId_annonce());
            s.setInt(2, p.getUtilisateur().getId());
            s.executeUpdate();
            System.out.println("succesful ");

        }else {
            System.out.println("desoler  vous aveze entrer un type invalide ");
        }
    }

    @Override
    public List recuperer() throws SQLException {
        PreparedStatement s = cnx.prepareStatement("select * from annonce,postulation,utilisateur where etat ='accepter' and postulation.id_annonce=annonce.id_annonce and postulation.id_demandeur=utilisateur.id ");
        ArrayList <Postulaion> PostulationListe=new ArrayList<>();
        ResultSet resultat = s.executeQuery();
        while (resultat.next()) {
       //         public Postulaion(entities.annonce annonce, entities.utilisateur utilisateur, String etat, String cv, String lettre_motivation) {
            resultat.getInt("id_annonce");

                PostulationListe.add(new Postulaion(new annonce(resultat.getInt("id_annonce")),new utilisateur(resultat.getInt("id")),null,resultat.getString("cv"),resultat.getString("lettre_motivation")));
        }

        return PostulationListe;

    }
}
