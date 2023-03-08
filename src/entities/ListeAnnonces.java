/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Istabrak
 */
public class ListeAnnonces {
     private int id_annonce;
     private  String titre;
     private int  id_utilisateur;
     private int id_postulation;

    public ListeAnnonces(int id_annonce, String titre, int id_utilisateur, int id_postulation) {
        this.id_annonce = id_annonce;
        this.titre = titre;
        this.id_utilisateur = id_utilisateur;
        this.id_postulation = id_postulation;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_postulation() {
        return id_postulation;
    }

    public void setId_postulation(int id_postulation) {
        this.id_postulation = id_postulation;
    }

    @Override
    public String toString() {
        return "ListeAnnonces{" + "id_annonce=" + id_annonce + ", titre=" + titre + ", id_utilisateur=" + id_utilisateur + ", id_postulation=" + id_postulation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_annonce;
        hash = 79 * hash + Objects.hashCode(this.titre);
        hash = 79 * hash + this.id_utilisateur;
        hash = 79 * hash + this.id_postulation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListeAnnonces other = (ListeAnnonces) obj;
        if (this.id_annonce != other.id_annonce) {
            return false;
        }
        if (this.id_utilisateur != other.id_utilisateur) {
            return false;
        }
        if (this.id_postulation != other.id_postulation) {
            return false;
        }
        return Objects.equals(this.titre, other.titre);
    }

   
   
     
     
}
