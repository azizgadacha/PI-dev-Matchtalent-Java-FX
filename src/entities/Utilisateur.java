/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author acer
 */
public class Utilisateur {
     private int id_utlisateur;
    private String userName; 
    private String mdp;
    private String nom;
    private String prenom;
    //private LocalDate dateNaissance;
    private String Sexe;
    private String email;
    private String adresse;
    private String tel;

    public Utilisateur(String userName, String mdp, String nom, String prenom, String Sexe, String email, String adresse, String tel) {
        this.userName = userName;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.Sexe = Sexe;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
    }
    public Utilisateur(int id_utlisateur) {
        this.id_utlisateur=id_utlisateur;
    }

    public int getId_utlisateur() {
        return id_utlisateur;
    }

    public void setId_utlisateur(int id_utlisateur) {
        this.id_utlisateur = id_utlisateur;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utlisateur=" + id_utlisateur + ", userName=" + userName + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + ", Sexe=" + Sexe + ", email=" + email + ", adresse=" + adresse + ", tel=" + tel + '}';
    }


    
    
    
}
