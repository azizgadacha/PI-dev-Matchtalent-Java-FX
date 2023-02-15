package entities;

import java.util.Objects;

public class Postulaion {

private annonce annonce;
private utilisateur utilisateur;
private String etat ;
    private String cv ;
    private String lettre_motivation  ;

    public Postulaion(entities.annonce annonce, entities.utilisateur utilisateur, String etat, String cv, String lettre_motivation) {
        this.annonce = annonce;
        this.utilisateur = utilisateur;
        this.etat = etat;
        this.cv = cv;
        this.lettre_motivation = lettre_motivation;
    }

    public entities.annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(entities.annonce annonce) {
        this.annonce = annonce;
    }

    public entities.utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(entities.utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettre_motivation() {
        return lettre_motivation;
    }

    public void setLettre_motivation(String lettre_motivation) {
        this.lettre_motivation = lettre_motivation;
    }



}
