package entities;

import java.sql.Date;

public class annonce {
    int id_annonce;
    String titre;
    String categorie;
    String nom_societé;
    Date date_debut;
    Date date_fin;
    String description;
    String type_contrat;

    public annonce(int id_annonce, String titre, String categorie, String nom_societé, Date date_debut, Date date_fin, String description, String type_contrat) {
        this.id_annonce = id_annonce;
        this.titre = titre;
        this.categorie = categorie;
        this.nom_societé = nom_societé;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.type_contrat = type_contrat;
    }
    public annonce(int id_annonce, String titre, String categorie, String nom_societé) {
        this.id_annonce = id_annonce;
        this.titre = titre;
        this.categorie = categorie;
        this.nom_societé = nom_societé;

    }
    public annonce(int id_annonce) {
        this.id_annonce = id_annonce;

    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom_societé() {
        return nom_societé;
    }

    public void setNom_societé(String nom_societé) {
        this.nom_societé = nom_societé;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
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
}
