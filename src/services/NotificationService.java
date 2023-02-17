/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Hend
 */
public class NotificationService implements IService<notification> {
    
     Connection cnx;

    public NotificationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(notification t) throws SQLException {
       String req = "INSERT INTO notification(id_utilisateur,description,date) VALUES(?,?,?)";
        PreparedStatement nt = cnx.prepareStatement(req);
        nt.setInt(1, t.getId_utilisateur());
        nt.setString(2, t.getDescription());
        nt.setDate(3, t.getDate());
        nt.executeUpdate();
    }

    @Override
    public void modifier(notification t) throws SQLException {
       String req = "UPDATE notification  SET id_notification = ?,description= ?, date=? where Id_utilisateur = ?";
        PreparedStatement nt = cnx.prepareStatement(req);
        nt.setInt(1, t.getId_notification());
        nt.setString(2, t.getDescription());
        nt.setDate(3, t.getDate());
        nt.setInt(4, t.getId_utilisateur());
        nt.executeUpdate();
    }

    @Override
    public void supprimer(notification t) throws SQLException {
        String req = "DELETE FROM notification  WHERE id_notification = ?";
        PreparedStatement nt = cnx.prepareStatement(req);
        nt.setInt(1, t.getId_notification());
        nt.executeUpdate();
    }

    @Override
    public List<notification> recuperer(notification t) throws SQLException {
      List<notification> notifications = new ArrayList<>();
        String s = "select * from notification";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            notification n = new notification();
            n.setDescription(rs.getString("description"));
            n.setId_notification(rs.getInt("id_notification"));
            
            
            notifications.add(n);
            
        }
        return notifications;
    }
 
}
