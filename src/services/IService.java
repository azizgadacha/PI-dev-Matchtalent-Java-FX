/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Istabrak
 * @param <T>
 */
public interface IService<T> {
    public void ajouter(T t) throws SQLException;
    public boolean modifier(T t) throws SQLException;
    public boolean supprimer(int id) throws SQLException;
    public List<T> recuperer(T t) throws SQLException;
}
