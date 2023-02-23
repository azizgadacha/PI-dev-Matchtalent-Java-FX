package entities;

public class candidature {
    private  int id_candidature;
    private utilisateur utilisateur;
    private annonce annonce;
    private float note;
    private String reponse;
    public candidature() {

    }
    public candidature(int id_candidature, entities.utilisateur utilisateur, entities.annonce annonce, float note, String reponse) {
        this.id_candidature = id_candidature;
        this.utilisateur = utilisateur;
        this.annonce = annonce;
        this.note = note;
        this.reponse = reponse;
    }
    public candidature(int id_candidature) {
        this.id_candidature = id_candidature;

    }

    public candidature(entities.utilisateur utilisateur, entities.annonce annonce, float note, String reponse) {
        this.utilisateur = utilisateur;
        this.annonce = annonce;
        this.note = note;
        this.reponse = reponse;
    }

    public int getId_candidature() {
        return id_candidature;
    }

    public void setId_candidature(int id_candidature) {
        this.id_candidature = id_candidature;
    }

    public entities.utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(entities.utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public entities.annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(entities.annonce annonce) {
        this.annonce = annonce;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
