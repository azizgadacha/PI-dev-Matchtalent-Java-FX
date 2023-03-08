/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.utilisateur;

/**
 *
 * @author Hend
 */
public interface IUserService <T>{
    
    public int getIdUser(String username, String email);

    public utilisateur getUserById(int id_utilisateur);

    public utilisateur  getUserByUsername(String username);
}
