/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class ItemcatController implements Initializable {

    @FXML
    private Label nomcat;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    
    public void  SetValue  (categorie c){
        nomcat.setText(c.getNom_categorie());
    }

    @FXML
    private void modifiercategorie(ActionEvent event) throws IOException {
       categorie c = new categorie();
    c.setNom_categorie(nomcat.getText());
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ModifierCategorie.fxml"));
  
        Parent root = loader.load();
        ModifierCategorieController modifiercategoriecontroller = loader.getController();
        modifiercategoriecontroller.setNameField(c.getNom_categorie());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Modifier la catégorie");
        stage.initOwner(nomcat.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
        String newName = modifiercategoriecontroller.getNameField();
        if (newName != null) {
            c.setNom_categorie(newName);
            c.updatecategorie();
            SetValue(c);
        }
   
    }
    

    @FXML
    private void supprimercategorie(ActionEvent event) {
       categorie c = new categorie();
    c.setNom_categorie(nomcat.getText());
    c.supprimercategorie();
    }



}
