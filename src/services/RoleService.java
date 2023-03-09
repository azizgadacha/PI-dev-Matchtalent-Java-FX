/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import entities.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import utils.MyDB;


/**
 *
 * @author nawelhammami
 */
public class RoleService implements IService<Role>{
    
     Connection cnx;
ObservableList<Role>obList = FXCollections.observableArrayList();

    public RoleService() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(Role t) throws SQLException {
        
        String req = "INSERT INTO role (nom_role,description) VALUES "
                + "('"+t.getNom_role()+"','"+t.getDescription()+"');";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Role t) throws SQLException {
        String req = "UPDATE role SET nom_role = ?,description = ? where id_role = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_role());
        ps.setString(2, t.getNom_role());
        ps.setString(3, t.getDescription());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(Role t) throws SQLException {
        String req = "DELETE FROM role WHERE id_role = "+t.getId_role();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public ObservableList<Role> recupererRole() throws SQLException {
        System.out.println("helllllllllllllllll");
       List<Role> role = new ArrayList<>();
        String s = "select * from role";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        
        while(rs.next()) {
            Role r = new Role();
            r.setId_role(rs.getInt("id_role"));
            r.setNom_role(rs.getString("nom_role"));
            r.setDescription(rs.getString("description"));
            obList.add(r);
        }
        return obList;
    }

    @Override
    public int getIdbyEmail(String mail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setNewMotPass(int idUser, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ObservableList<Role> recuperer() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    
        
    

   
    
