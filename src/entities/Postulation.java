/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Istabrak
 */
public class Postulation {
    private Annonce annonce;
    private Utilisateur utilisateur;
    private String etat;
   // private enum etat {accepter, refuser, enCours};  
    private entities.File file;
    private Date date;
    private int id ;
    public Postulation() {
    }

    public Postulation(Annonce id_annonce,Utilisateur utilisateur, String etat, entities.File id_file, Date date) {
        this.annonce = id_annonce;
        this.utilisateur = utilisateur;
        this.etat= etat;
        this.file = id_file;
        this.date = date;
    }

    public Postulation(Annonce id_annonce, Utilisateur utilisateur, String etat, File e) {
        this.annonce=id_annonce;
        this.utilisateur=getIdUtilisateur();
        this.etat=etat;
        this.file=e;
    }

    public Annonce getIdAnnonce() {
        return annonce;
    }

    public void setIdAnnonce(Annonce id_annonce) {
        this.annonce = id_annonce;
    }

    public Utilisateur getIdUtilisateur() {
        return utilisateur;
    }public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setIdUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    } public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public entities.File getIdFile() {
        return file;
    }

    public void setIdFile(entities.File id_file) {
        this.file = id_file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Postulation{" + "id_annonce=" + annonce + ", utilisateur=" + utilisateur + ", etat=" + etat + ", id_file=" + file + ", date=" + date + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
   

    
}
