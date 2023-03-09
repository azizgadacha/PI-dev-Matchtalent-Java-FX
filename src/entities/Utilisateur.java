/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author nawelhammami
 */
public class Utilisateur {

    
    
    private int id,id_role;
    private String username,mot_de_passe,email,contact,address,biographie,nom_societe;

    public Utilisateur() {
    }

 
    public Utilisateur(int id, int id_role, String username, String mot_de_passe, String email, String contact, String address, String biographie, String nom_societe) {
        this.id = id;
        this.id_role = id_role;
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.biographie = biographie;
        this.nom_societe = nom_societe;
    }

    public Utilisateur(int id_role, String username, String mot_de_passe, String email, String contact, String address, String biographie, String nom_societe) {
        this.id_role = id_role;
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.biographie = biographie;
        this.nom_societe = nom_societe;
    }
    
    
    

    public Utilisateur(String email, String mot_de_passe) {
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }
    
    
    
   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", id_role=" + id_role + ", username=" + username + ", mot_de_passe=" + mot_de_passe + ", email=" + email + ", contact=" + contact + ", address=" + address + ", biographie=" + biographie + ", nom_societe=" + nom_societe + '}';
    }
    
    
    
}
    