package entities;

import entities.annonce;
import entities.utilisateur;

import java.util.Date;

public class rendez_vous {
    private int id_rendez_vous;
    private utilisateur user ;
    private Date date_rendez_vous;
    private String Heure_rendez_vous;
    private entities.annonce annonce;

    public rendez_vous(utilisateur user, Date date_rendez_vous, String heure_rendez_vous, entities.annonce annonce) {
        this.user = user;
        this.date_rendez_vous = date_rendez_vous;
        Heure_rendez_vous = heure_rendez_vous;
        this.annonce = annonce;
    }

    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public utilisateur getUser() {
        return user;
    }

    public void setUser(utilisateur user) {
        this.user = user;
    }

    public Date getDate_rendez_vous() {
        return date_rendez_vous;
    }

    public void setDate_rendez_vous(Date date_rendez_vous) {
        this.date_rendez_vous = date_rendez_vous;
    }

    public String getHeure_rendez_vous() {
        return Heure_rendez_vous;
    }

    public void setHeure_rendez_vous(String heure_rendez_vous) {
        Heure_rendez_vous = heure_rendez_vous;
    }

    public entities.annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(entities.annonce annonce) {
        this.annonce = annonce;
    }
}
