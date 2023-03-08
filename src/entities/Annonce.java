/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author acer
 */
public class Annonce {
   private int id_annonce,id_utilisateur,id_categorie;
   private String titre ,nom_societe,description,type_contrat,categorie; 
      private Date dateDebut;
    private Date dateFin;

    public Annonce() {
    }

    public Annonce(int id_utilisateur, int id_categorie, String titre, String nom_societe, String description, String type_contrat, String categorie, Date dateDebut, Date dateFin) {
        this.id_utilisateur = id_utilisateur;
        this.id_categorie = id_categorie;
        this.titre = titre;
        this.nom_societe = nom_societe;
        this.description = description;
        this.type_contrat = type_contrat;
        this.categorie = categorie;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }



 
    

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    
    

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", id_utilisateur=" + id_utilisateur + ", id_categorie=" + id_categorie + ", titre=" + titre + ", nom_societe=" + nom_societe + ", description=" + description + ", type_contrat=" + type_contrat + ", categorie=" + categorie + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }



 
    

}