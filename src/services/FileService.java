/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.File;
//import entities.Type;
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
 * @author Istabrak
 */
public class FileService implements IService<File>{
     Connection cnx;

    public FileService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(File f) throws SQLException {
        String req = "INSERT INTO `file`(`id_file`, `type`, `id_utilisateur`) VALUES("
                  + "'" + f.getIdFile() + "','" + f.getType() + "'," + f.getIdUtilisateur() + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
       // PreparedStatement st = cnx.prepareStatement(req);
       // st.setInt(1, f.getIdFile());
       // st.setObject(2,Type.cv);
       // st.setInt(3, f.getIdUtilisateur());
       // st.executeUpdate();
    }
    @Override
    public void modifier(File f) throws SQLException {
        String req = "UPDATE file  SET type = ? where id_file = ? and id_utilisateur = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setObject(1, f.getType());
        st.setInt(2, f.getIdFile());
        st.setInt(3, f.getIdUtilisateur());
        st.executeUpdate();
    }

    @Override
    public void supprimer(File f) throws SQLException {
        String req = "DELETE FROM file  WHERE id_file = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, f.getIdFile());
        st.executeUpdate();  }

    @Override
    public List<File> recuperer(File f) throws SQLException {
        List<File> files = new ArrayList<>();
        String s = "select * from file";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            File n = new File();
            n.setIdFile(rs.getInt("id_file"));
        //    n.setType(rs.getType());
            n.setIdUtilisateur(rs.getInt("id_utilisateur"));
            
            
            files.add(n);
            
        }
        return files;
    }
}
