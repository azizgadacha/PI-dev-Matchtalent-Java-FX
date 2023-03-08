/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Hend
 */
public class reponse_reclamation {
    private reclamation reclamation;
    private int id_reponse, id_reclamation;
    private String reponse;
    private Date date;
    private reclamation reclamtion;

    public reponse_reclamation(int id_reclamation, String reponse, Date date) {
        this.id_reclamation = id_reclamation;
        this.reponse = reponse;
        this.date = date;
    }

    public reponse_reclamation(int id_reclamation, String reponse, reclamation reclamation) {
        this.id_reclamation = id_reclamation;
        this.reponse = reponse;
        this.reclamation = reclamation;
    }
    
    public reponse_reclamation(reclamation reclamation, String reponse, Date date) {
        this.reclamation = reclamation;
        this.reponse = reponse;
        this.date = date;
    }

    
    
    public reponse_reclamation() {
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public reclamation getReclamation() {
        return reclamation;
    }

    public void setReclamation(reclamation reclamation) {
        this.reclamation = reclamation;
    }

    @Override
    public String toString() {
        return "reponse_reclamation{" + "id_reponse=" + id_reponse + ", id_reclamation=" + id_reclamation + ", reponse=" + reponse + ", date=" + date + '}';
    }
    
    
    
}
