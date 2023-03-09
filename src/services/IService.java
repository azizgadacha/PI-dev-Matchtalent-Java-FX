/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import entities.Role;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author nawelhammami
 */
public interface IService<T> {
    
    public void ajouter(T t) throws SQLException;
    public void modifier(T t) throws SQLException;
    public void supprimer(T t) throws SQLException;
    public ObservableList<T> recuperer() throws SQLException;
    
   public  ObservableList<T> recupererRole() throws SQLException;
   
    public int getIdbyEmail(String mail) ;
                public void setNewMotPass(int idUser ,String pass);
                
    
                
                

}
