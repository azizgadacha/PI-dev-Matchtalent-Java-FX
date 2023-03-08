
package entities;

import java.sql.Date;

/**
 *
 * @author Istabrak
 */
public class EtatPostulation {
      private int id_annonce;
    private int id_utilisateur;
    private String etat;
   private int id_postulation; 
    private Date date;

    public EtatPostulation(int id_annonce, int id_utilisateur, String etat, int id_postulation, Date date) {
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
        this.etat = etat;
        this.id_postulation = id_postulation;
        this.date = date;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId_postulation() {
        return id_postulation;
    }

    public void setId_postulation(int id_postulation) {
        this.id_postulation = id_postulation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EtatPostulation{" + "id_annonce=" + id_annonce + ", id_utilisateur=" + id_utilisateur + ", etat=" + etat + ", id_postulation=" + id_postulation + ", date=" + date + '}';
    }
    
    
    
    
}
