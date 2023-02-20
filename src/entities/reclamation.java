/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;
import java.time.LocalDate;






/**
 *
 * @author Hend
 */
public class reclamation {
    private int id_reclamation, id_utilisateur;
    private String description,titre,type,statut;
    private LocalDate date;

    public reclamation() {
    }
   
    public reclamation(int id_utilisateur,String description, String titre, String type, LocalDate date, String statut) {
        
        this.id_utilisateur= id_utilisateur;
        this.description = description;
        this.titre = titre;
        this.type = type;
        this.date = date;
        this.statut = statut;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    
    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", id_utilisateur=" + id_utilisateur + ", description=" + description + ", titre=" + titre + ", type=" + type + ", date=" + date +  ", statut=" + statut +  '}';
    }
}
