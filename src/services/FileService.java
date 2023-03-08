/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.File;
//import entities.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author Istabrak
 */
public class FileService implements IService<File>{
    private final Connection cnx;

    public FileService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(File f) throws SQLException {
      
                 
         String query ="INSERT INTO file(`cv`,`deplome`,`lettermotivation`,`nameCv`,`nameDeplome`,`nameMotivation`, `id_utilisateur`) VALUES (?,?,?,?,?,?,?)";
 
         PreparedStatement st;
        
        try {
            st = cnx.prepareStatement(query);
                st.setBytes(1,f.getCv());
                st.setBytes(2,f.getDeplome());
                st.setBytes(3,f.getLettremotivation());
                st.setString(4, f.getNameCV());
                st.setString(5, f.getNamedeplome());
                st.setString(6, f.getNamelettreMotivation());
                st.setInt(7, f.getIdUtilisateur());
                st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
 
          
    }
    @Override
    public boolean modifier(File f) throws SQLException {
        
                       
                String query = "UPDATE `file` SET `cv`=?,`deplome`=?,`lettermotivation`=?,`nameCv`=?,`nameDeplome`=?,`nameMotivation`=? WHERE `id_file` = ?";
		PreparedStatement st;
        try {
                st = cnx.prepareStatement(query);
                st.setBytes(1,f.getCv());
                st.setBytes(2,f.getDeplome());
                st.setBytes(3,f.getLettremotivation());
                st.setString(4, f.getNameCV());
                st.setString(5, f.getNamedeplome());
                st.setString(6, f.getNamelettreMotivation());
                st.setInt(7, f.getIdFile());
                st.executeUpdate();
                return true;
                
        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             

    }

    @Override
    public boolean supprimer(int id) throws SQLException {
        
                try {
            
            Statement st=cnx.createStatement();
            String req= "DELETE FROM file WHERE id_file="+id;
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public List<File> recuperer(File f) throws SQLException {
        List<File> files = new ArrayList<>();

        return files;
    }
    
    
    public ObservableList<File> getAllFileByUser( int idu) throws SQLDataException {

        
        List<File> list =new ArrayList<File>();
        int count =0;
        
        String requete="select * from file where id_utilisateur="+idu;
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                File e = new File();
                e.setIdFile(rs.getInt("id_file"));
                e.setIdUtilisateur(rs.getInt("id_utilisateur"));
                e.setCv(rs.getBytes("cv"));
                e.setDeplome(rs.getBytes("deplome"));
                e.setLettremotivation(rs.getBytes("lettermotivation"));
                e.setNameCV(rs.getString("nameCv"));
                e.setNamedeplome(rs.getString("nameDeplome"));
                  e.setNamelettreMotivation(rs.getString("nameMotivation"));
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
    
    
        
    public ObservableList<File> getAllFile() throws SQLDataException {

        
        List<File> list =new ArrayList<File>();
        int count =0;
        
        String requete="select * from file";
         try{
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()){
                
                File e = new File();
                e.setIdFile(rs.getInt("id_file"));
                e.setIdUtilisateur(rs.getInt("id_utilisateur"));
                e.setCv(rs.getBytes("cv"));
                e.setDeplome(rs.getBytes("deplome"));
                e.setLettremotivation(rs.getBytes("lettermotivation"));
                e.setNameCV(rs.getString("nameCv"));
                e.setNamedeplome(rs.getString("nameDeplome"));
                  e.setNamelettreMotivation(rs.getString("nameMotivation"));
                
                list.add(e);
                
                count++;
            }
            if(count == 0){
                return null;
           }else{
             ObservableList lc_final = FXCollections.observableArrayList(list);

               return lc_final;
            
           
        }
         }
        catch (SQLException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
           
}
    
       public File get_FileById(int i) {
        File e = new File();
        int nombre = 0;
        String requete = "select * from file where id_file="+i;
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                e.setIdFile(rs.getInt("id_file"));
                e.setIdUtilisateur(rs.getInt("id_utilisateur"));
                e.setCv(rs.getBytes("cv"));
                e.setDeplome(rs.getBytes("deplome"));
                e.setLettremotivation(rs.getBytes("lettermotivation"));
                e.setNameCV(rs.getString("nameCv"));
                e.setNamedeplome(rs.getString("nameDeplome"));
                  e.setNamelettreMotivation(rs.getString("nameMotivation"));
                
                nombre++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;

    }
    
    
    
    
    
    

   
}
