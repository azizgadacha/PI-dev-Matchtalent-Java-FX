/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ArchiveService;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private Label lab1;
    @FXML
    private Label lab2;

    @FXML
    private TextField txt1;
    
    @FXML
    private Button b1;
        @FXML
    private Button btnaffiche;

    
        CategorieService ps = new CategorieService();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
      public void reset(){

        txt1.setText("");} 
    
          @FXML
    private void ajouterCategorie(ActionEvent event) throws SQLException {
                categorie c = new categorie();
                c.setNom_categorie(txt1.getText());

       
            ps.ajouter(c);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Categorie added successfully!");
            alert.showAndWait();
            reset();
        }
    
    
      @FXML
    void affichercategorie(ActionEvent event) throws IOException {
      
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
            txt1.getScene().setRoot(loader);
        
    }
    
}
