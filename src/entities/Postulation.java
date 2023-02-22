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
    private int id_annonce;
    private int id_utilisateur;
    private String etat;
   // private enum etat {accepter, refuser, enCours};  
    private int id_file;
    private Date date;
    

    public Postulation() {
    }

    public Postulation(int id_annonce, int id_utilisateur, String etat, int id_file, Date date) {
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
        this.etat= etat;
        this.id_file = id_file;
        this.date = date;
    }

    public int getIdAnnonce() {
        return id_annonce;
    }

    public void setIdAnnonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getIdUtilisateur() {
        return id_utilisateur;
    }

    public void setIdUtilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getIdFile() {
        return id_file;
    }

    public void setIdFile(int id_file) {
        this.id_file = id_file;
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
        return "Postulation{" + "idAnnonce=" + id_annonce + ", idUtilisateur=" + id_utilisateur + ", etat=" + etat + ", idFile=" + id_file + ", date=" + date + '}';
    }

    
}
