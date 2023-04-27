/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Annonce;
import entities.categorie;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.MyDB;


/**
 *
 * @author acer
 */
public class AnnonceService implements IService<Annonce>{
    
    Connection cnx;

    public AnnonceService() {
      cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Annonce t) throws SQLException {
        Date sqlDate = new Date(t.getDateDebut().getTime());
        Date sqlDate1 = new Date(t.getDateFin().getTime());
       String req = "INSERT INTO annonce(id_utilisateur,id_categorie,id_quiz,titre,nom_societé,description,type_contrat,dateDebut,dateFin) VALUES(?, ?,?,?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, 1);
        ps.setInt(2 ,t.getQuiz().getId_quiz());
        ps.setInt(3 ,t.getCategorie().getId_categorie());
        ps.setString(4, t.getTitre());
        ps.setString(5, t.getNom_societe());
        ps.setString(6, t.getDescription());
        ps.setString(7, t.getType_contrat());
        ps.setDate(8,sqlDate );
        ps.setDate(9, sqlDate1);
        
        ps.executeUpdate();
        System.out.println("chrs"); }
    @Override
    public void modifier(Annonce t) throws SQLException {
         Date sqlDate = new Date(t.getDateDebut().getTime());
        Date sqlDate1 = new Date(t.getDateFin().getTime());
       String req = "UPDATE annonce  SET titre = ?,description= ?, quiz=?, categorie=?, dateDebut=?, dateFin=?, nom_societé=?, type_contrat=? where Id_utilisateur = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getTitre());
        ps.setString(2, t.getDescription());
        ps.setInt(3 ,t.getCategorie().getId_categorie());
        ps.setInt(4 ,t.getQuiz().getId_quiz());
        ps.setDate(5, sqlDate);
        ps.setDate(6, sqlDate1);
        ps.setString(7, t.getNom_societe());
        ps.setString(2, t.getType_contrat());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(Annonce t) throws SQLException {
        
        String req = "DELETE FROM annonce  WHERE id_annonce = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_annonce());
        ps.executeUpdate();
    }
    @Override
    public List<Annonce> recuperer() throws SQLException {
      
      
//    String query = "CREATE TRIGGER insert_and_delete\n" +
//        "AFTER INSERT ON annonce\n" +
//        "FOR EACH ROW\n" +
//        "BEGIN\n" +
//        "    IF NEW.dateFin = CURDATE() THEN\n" +
//        "        INSERT INTO archive (titre, nom_societe, description, type_contrat, categorie, id_utilisateur, id_categorie, dateDebut, dateFin)\n" +
//        "        VALUES ( NEW.titre, NEW.nom_societe, NEW.description, NEW.type_contrat, NEW.categorie, NEW.id_utilisateur, NEW.id_categorie, NEW.dateDebut, NEW.dateFin););\n" +
//        "        DELETE FROM annonce WHERE id_annonce = NEW.id_annonce;\n" +
//        "    END IF;\n" +
//        "END;";
//    try {
////  Connection cnx = DriverManager.getConnection(titre, description, nom_societe, type_contrat, categorie, dateDebut , dateFin);
//    Statement statement = cnx.createStatement();
//    statement.executeUpdate(query);
//    statement.close();
//    cnx.close();
//} catch (SQLException ex) {
//    System.err.println("Error creating trigger: " + ex.getMessage());
//}
    List<Annonce> annonces = new ArrayList<>();
        String s = "select * from annonce,categorie where categorie.id_categorie = annonce.id_categorie";
        
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
                    System.out.println("hhhhhhhhhhhh2");

        while(rs.next()){
                        System.out.println("hhhhhhhhhhhh1");

            Annonce a = new Annonce();
            a.setDescription(rs.getString("description"));
            a.setNom_societe(rs.getString("nom_societé"));
            a.setTitre(rs.getString("titre"));
            a.setType_contrat(rs.getString("type_contrat"));
            a.setCategorie(new categorie(rs.getInt("id_categorie"),rs.getString("nom_categorie")));
            // a.setCategorie(new quiz(rs.getInt("id_quiz"),rs.getObject(quiz)));
           a.setDateDebut(rs.getDate("dateDebut"));
            a.setDateFin(rs.getDate("dateFin"));
            a.setId_annonce(rs.getInt("id_annonce"));
            
            
            annonces.add(a);
//            System.out.println("hhhhhhhhhhhh"+a);
//            // Check if the announcement's end date matches the current date
//        LocalDate currentDate = LocalDate.now();
//        java.sql.Date sqlDate = (java.sql.Date) a.getDateFin();
//        Date utilDate = new Date(sqlDate.getTime());
//        LocalDate endDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        if (endDate.equals(currentDate)) {
//            // Insert a new record into the archive table
//            String insertQuery = "INSERT INTO archive (titre, nom_societe, description, type_contrat, categorie, id_utilisateur, id_categorie, dateDebut, dateFin) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement insertStatement = cnx.prepareStatement(insertQuery);
//            insertStatement.setString(1, a.getTitre());
//            insertStatement.setString(2, a.getNom_societe());
//            insertStatement.setString(3, a.getDescription());
//            insertStatement.setString(4, a.getType_contrat());
//            insertStatement.setInt(5, a.getCategorie().getId_categorie());
//            insertStatement.setInt(6, a.getId_utilisateur());
//            insertStatement.setInt(7, a.getId_categorie());
//            insertStatement.setDate(8, (Date) a.getDateDebut());
//            insertStatement.setDate(9, (Date) a.getDateFin());
//            insertStatement.executeUpdate();
//
//            // Delete the announcement from the annonces table
//            String deleteQuery = "DELETE FROM annonce WHERE id_annonce = ?";
//            PreparedStatement deleteStatement = cnx.prepareStatement(deleteQuery);
//            deleteStatement.setInt(1, a.getId_annonce());
//            deleteStatement.executeUpdate(); 
//
//          }
    }
        return annonces;
        
        
    }

public List<Annonce> getAnnoncesByCategorie(String categorie) throws SQLException {
    List<Annonce> annonces = new ArrayList<>();
    String s = "SELECT * FROM annonce WHERE categorie=?";
    PreparedStatement ps = cnx.prepareStatement(s);
    ps.setString(1, categorie);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Annonce a = new Annonce();
        a.setDescription(rs.getString("description"));
        a.setNom_societe(rs.getString("nom_societé"));
        a.setTitre(rs.getString("titre"));
        a.setType_contrat(rs.getString("type_contrat"));
       // a.setCategorie(rs.getString("categorie"));
       a.setCategorie(new categorie(rs.getInt("id_categorie"),rs.getString("nom_categorie")));
        a.setDateDebut(rs.getDate("dateDebut"));
        a.setDateFin(rs.getDate("dateFin"));
        a.setId_annonce(rs.getInt("id_annonce"));
        annonces.add(a);
    }
    return annonces;
}

public List<Annonce> getAnnoncesByTypeContrat(String typeContrat) throws SQLException {
    List<Annonce> annonces = new ArrayList<>();
    String s = "SELECT * FROM annonce WHERE type_contrat=?";
    PreparedStatement ps = cnx.prepareStatement(s);
    ps.setString(1, typeContrat);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
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
