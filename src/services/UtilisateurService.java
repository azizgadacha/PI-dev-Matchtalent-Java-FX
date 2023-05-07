/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Role;
import entities.Utilisateur;
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
public class UtilisateurService implements IService<Utilisateur> {
    
    Connection cnx;
    
ObservableList<Utilisateur>obList = FXCollections.observableArrayList();

    public UtilisateurService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Utilisateur t) throws SQLException {
         String req = "INSERT INTO Utilisateur(id_role,username,"
                 + "mot_de_passe,email,contact,"
                 + "address,biographie,nom_societe) "
                 + "VALUES"
                 + "("
                   + t. getRole().getId_role()
                 + ",'" 
                 + t.getUsername() 
                 + "','" 
                 + t.getMot_de_passe() 
                 + "','" 
                 +t.getEmail()
                 + "','" 
                 + t.getContact()
                 + "','" 
                 +t.getAddress() 
                 + "','"
                 + t.getBiographie() 
                 + "','" 
                 +t.getNom_societe()
                 + "')" ;
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        
       
    }
    

    @Override
    public void modifier(Utilisateur t) throws SQLException {
      
       String req = "UPDATE Utilisateur SET id_role = ?,username = ?,mot_de_passe = ?,email = ?,contact = ?,address = ? ,biographie = ?,nom_societe = ? where id = ?" ;
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId());
        ps.setInt(2, t.getRole().getId_role());
        
        ps.setString(3, t.getUsername());
        ps.setString(4, t.getMot_de_passe());
        ps.setString(5, t.getEmail());
        ps.setString(6, t.getContact());
        ps.setString(7, t.getAddress());
        ps.setString(8, t.getBiographie());
        ps.setString(9, t.getNom_societe());
        ps.executeUpdate();
    }


    @Override
    public void supprimer(Utilisateur t) throws SQLException {
         String req = "DELETE FROM Utilisateur WHERE id = "+t.getId();
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();
            
        
    }
  
       
    @Override
    public ObservableList<Utilisateur>  recuperer() throws SQLException {
        List<Utilisateur> Utilisateur = new ArrayList<>();
        String s = "select * from Utilisateur,role where Utilisateur.id_role= role.id_role";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            if(!rs.getString("username").equals("admin" )) {
                 Utilisateur u = new Utilisateur();
            u.setId(rs.getInt("id"));
            u.setRole(new Role(rs.getInt("id_role"),rs.getString("nom_role")));
            u.setUsername(rs.getString("username"));
            u.setMot_de_passe(rs.getString("mot_de_passe"));
            u.setEmail(rs.getString("email"));
            u.setContact(rs.getString("contact"));
            u.setAddress(rs.getString("address"));
            u.setBiographie(rs.getString("biographie"));
            u.setNom_societe(rs.getString("nom_societe"));
            
            obList.add(u);
            }
           

        }
        return obList;
    }
    
    
    public List<Utilisateur> recupererUser(Utilisateur t) throws SQLException {
        System.out.println("");
        List<Utilisateur> Utilisateur_list = new ArrayList<>();
        String s = "select * from Utilisateur,role where role.id_role=Utilisateur.id_role  and email = ? and mot_de_passe = ?";
       
        PreparedStatement ps = cnx.prepareStatement(s);
       
        System.out.println("test1 "+t.getEmail());
        System.out.println("test2 "+t.getMot_de_passe());
        ps.setString(1, t.getEmail());
        ps.setString(2, t.getMot_de_passe());
       
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Role r=new Role();
            r.setId_role(rs.getInt("id_role"));
            r.setNom_role(rs.getString("nom_role"));
            
            

            Utilisateur u = new Utilisateur();
            u.setRole(r);
            u.setId(rs.getInt("id"));
            u.setRole(r);
            u.setUsername(rs.getString("username")); 
            u.setMot_de_passe(rs.getString("mot_de_passe"));
            u.setEmail(rs.getString("email"));
            u.setContact(rs.getString("contact"));
            u.setAddress(rs.getString("address"));
            u.setBiographie(rs.getString("biographie"));
            u.setNom_societe(rs.getString("nom_societe"));
            
            Utilisateur_list.add(u);

        }
        return Utilisateur_list;
    } public List<Utilisateur> recupererUser1(Utilisateur t) throws SQLException {
        System.out.println("");
        List<Utilisateur> Utilisateur_list = new ArrayList<>();
        String s = "select * from user where  email = ? ";

        PreparedStatement ps = cnx.prepareStatement(s);

        System.out.println("test1 "+t.getEmail());
        System.out.println("test2 "+t.getMot_de_passe());
        ps.setString(1, t.getEmail());


        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Role r=new Role();
        //    r.setId_role(rs.getInt("id_role"));
        //    r.setNom_role(rs.getString("nom_role"));

String role=rs.getString("roles");

           String leftOfColon = role.split(":")[1];

            // Remove the first and last characters from the leftOfColon string
            String processedString = leftOfColon.substring(1, leftOfColon.length() - 2);
            if(processedString.equals("Offreur"))
             r.setId_role(3);
            else  if(processedString.equals("admin"))
                r.setId_role(1);
            else                 r.setId_role(2);


            r.setNom_role(processedString);

            Utilisateur u = new Utilisateur();
           u.setRole(r);
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("name"));
            u.setMot_de_passe (rs.getString("password"));
            u.setEmail(rs.getString("email"));
            u.setContact(rs.getString("contact"));
            u.setAddress(rs.getString("address"));
            u.setBiographie(rs.getString("biographie"));
            u.setNom_societe(rs.getString("nom_societe"));

            Utilisateur_list.add(u);

        }
        return Utilisateur_list;
    }

       public int getIdbyEmail(String mail) {
int result =-1;
        try {
            PreparedStatement st = cnx.prepareStatement("select * from Utilisateur where email=?");
            st.setString(1, mail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result=rs.getInt(1);
                return result;
            }
        } catch (SQLException ex) {ex.printStackTrace();
        }
        return result;

    }

            public void setNewMotPass(int idUser ,String pass){
       PreparedStatement st;
        try {
            String req = "UPDATE `Utilisateur` SET `mot_de_passe` ='" + pass + "' WHERE `Utilisateur`.`id` = "+idUser;
            st = cnx.prepareStatement(req);
            st.executeUpdate(req);
             System.out.println(req);
               } catch (SQLException ex) {ex.printStackTrace();

        }  
        
    }

    public ObservableList<Utilisateur> recupererRole() {
        return null;
    }
    
    
    public int getTotalOffreur() throws SQLException {
         String sql ="SELECT count(*) from Utilisateur WHERE id_role="+3;
            
              PreparedStatement ps = cnx.prepareStatement(sql);
       
        
      
        ResultSet rs = ps.executeQuery();
          
            if (rs.next()){
                return Integer.parseInt(rs.getString("count(*)"));
            }
            return 0;
        
    }
    
    public int getTotalDemandeur() throws SQLException {
          String sql ="SELECT count(*) from Utilisateur WHERE id_role="+2;
            
              PreparedStatement ps = cnx.prepareStatement(sql);
       
        
      
        ResultSet rs = ps.executeQuery();
          
            if (rs.next()){
                System.out.println(rs.getString("count(*)"));
                return Integer.parseInt(rs.getString("count(*)"));
                
            }
            return 0;
        
    }
   
}
