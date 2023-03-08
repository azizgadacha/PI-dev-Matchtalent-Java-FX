package entities;

public class Postulation {

private annonce annonce;
private utilisateur utilisateur;
private String etat ;
private String file ;

    public Postulation(entities.annonce annonce, entities.utilisateur utilisateur, String etat, String file) {
        this.annonce = annonce;
        this.utilisateur = utilisateur;
        this.etat = etat;
        this.file=file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }





}
