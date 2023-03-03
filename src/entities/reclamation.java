/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import utils.Enum.Statut;
import utils.Enum.TypeReclamation;







/**
 *
 * @author Hend
 */
public class reclamation {
    private utilisateur utilisateur;
    private int id_utilisateur,id_reclamation;
    private String description,titre;
    //private LocalDate date;
    private TypeReclamation type;
    private Date date;
    private Statut statut;

    public reclamation() {
    }

    public reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }
   
    
    
    public reclamation(utilisateur utilisateur,String description, String titre, TypeReclamation type, Date date, Statut statut) {
        
        this.utilisateur= utilisateur;
        this.description = description;
        this.titre = titre;
        this.type= type;
        this.date = date;
        this.statut = statut;
    }
    
    
     public reclamation(int id_utilisateur, String description, String titre, TypeReclamation type, Date date) {

        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.titre = titre;
        this.type = type;
        this.date = date;
      
    }
     
     public reclamation(utilisateur utilisateur,String description, String titre, Date date) {
        
   
        this.utilisateur = utilisateur;
        this.description = description;
        this.titre = titre;
        this.date = date;
      
    }
     
      public reclamation(int id_utilisateur,String description, String titre, Date date) {
        
   
        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.titre = titre;
        this.date = date;
      
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
    
    

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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

    public TypeReclamation getType() {
        return type;
    }

    public void setType(TypeReclamation type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    
    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ",utilisateur=" + utilisateur + ", description=" + description + ", titre=" + titre + ", type=" + type + ", date=" + date +  ", statut=" + statut +  '}';
    }
}
