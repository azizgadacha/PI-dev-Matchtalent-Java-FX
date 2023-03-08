package entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import services.AnnonceService;
import utils.MyDB;

public class Archive implements Runnable {

    private List<Annonce> annonces;
    private AnnonceService annonceService;
    private Connection cnx;

    public Archive(List<Annonce> annonces) {
        this.annonces = annonces;
        this.annonceService = new AnnonceService();
        this.cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void run() {
        try {
            // Archive each expired announcement
            for (Annonce annonce : annonces) {
                Date dateFin = (Date) annonce.getDateFin();
                if (dateFin != null && dateFin.toLocalDate().isBefore(LocalDate.now())) {
                    archiveAnnonce(annonce);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void archiveAnnonce(Annonce annonce) throws SQLException {
        // Copy the announcement to the archive table and delete it from the main table
        String req = "INSERT INTO archive(id_annonce, titre, categorie, nom_societe, description, type_contrat, dateDebut, dateFin)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
       // ps.setInt(1, annonce.getId_utilisateur());
       // ps.setInt(2, annonce.getId_categorie());
       ps.setInt(1, annonce.getId_annonce());
        ps.setString(2, annonce.getTitre());
        //ps.setString(4, annonce.getCategorie());
        ps.setString(3, annonce.getNom_societe());
        ps.setString(4, annonce.getDescription());
        ps.setString(4, annonce.getType_contrat());
        ps.setDate(5, (Date) annonce.getDateDebut());
        ps.setDate(6, (Date) annonce.getDateFin());
        
        ps.executeUpdate();

        annonceService.supprimer(annonce);
    }

}
