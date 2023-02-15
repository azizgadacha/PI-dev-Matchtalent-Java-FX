/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author nawelhammami
 */
public class utilisateur {



    private int id;
    private String username,mot_de_passe,email;

    public utilisateur() {
    }

    public utilisateur(int id, String username, String mot_de_passe, String email) {
        this.id = id;
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
    } public utilisateur(int id) {
        this.id = id;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", username=" + username + ", mot_de_passe=" + mot_de_passe + ", email=" + email + '}';
    }





}