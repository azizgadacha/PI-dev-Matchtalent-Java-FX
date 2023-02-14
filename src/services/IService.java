/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author Hend
 */
public interface IService<T> {
    void Ajouter(T t);
    void Modifier(T t);
    void Supprimer(T t);
    List<T> Recuperer();
}
