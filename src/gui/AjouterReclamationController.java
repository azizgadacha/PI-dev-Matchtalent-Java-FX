/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ReclamationService;
import utils.Enum.TypeReclamation;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private TextField ch_title;
    @FXML
    private DatePicker ch_date;
    @FXML
    private ComboBox combo;
    @FXML
    private TextField ch_desc;
    //@FXML
    //private TextField ch_type;
    @FXML
    private TextField ch_id;
    
     @FXML
    private Button btn_btn;
    
    ReclamationService ps = new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<String> objetList = FXCollections.observableArrayList();
        objetList.addAll("Contentrelatedissues", "TechnicalIssues", "SecurityIssues");
        combo.setItems(objetList);

    }    

    @FXML
    private void select(ActionEvent event) {
        String selectedObject = combo.getSelectionModel().getSelectedItem().toString();
    }
    /*@Override
public void initialize(URL url, ResourceBundle rb) {
    ObservableList<TypeReclamation> typesList = FXCollections.observableArrayList();
    try {
        // Retrieve the types from the database
        Connection conn = MyDB.getInstance().getCnx();
        String query = "SELECT DISTINCT type FROM reclamation";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        // Add the types to the list
        while (rs.next()) {
            TypeReclamation type = TypeReclamation.valueOf(rs.getString("type"));
            typesList.add(type);
        }
        
        // Set the items of the ComboBox
        combo.setItems(typesList);
    } catch (SQLException ex) {
        Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@FXML
private void select(ActionEvent event) {
    TypeReclamation selectedType = (TypeReclamation) combo.getSelectionModel().getSelectedItem();
}*/
    
      @FXML
    private void affiche(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReclamation.fxml"));
            Parent root = loader.load();
           // ListReclamationController controller = loader.getController();
            //controller.setData(ch_title.getText() + " " + ch_desc.getText()
            //+ " " + ch_date.getValue().atStartOfDay() + " " + combo.getSelectionModel().getSelectedItem().toString());
            Scene currentScene = btn_btn.getScene();
            currentScene.setRoot(root);
            
       
        
    }
    
    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
               reclamation p = new reclamation();
            p.setTitre(ch_title.getText());
            p.setDescription(ch_desc.getText());
           // p.setId_utilisateur(Integer.parseInt(ch_id.getText()));
            p.setUtilisateur(new utilisateur(1));
            //p.setType(TypeReclamation.valueOf(ch_type.getText()));
            p.setType(TypeReclamation.valueOf(combo.getSelectionModel().getSelectedItem().toString()));
            p.setDate(new Date());
            ps.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Reclamation added successfully!");
            alert.showAndWait();

            System.out.println("Reclamation added successfully!");
       
    }
    
}
