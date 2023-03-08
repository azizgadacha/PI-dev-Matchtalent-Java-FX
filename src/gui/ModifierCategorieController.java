/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class ModifierCategorieController implements Initializable {

public void setNameField(String Nom_categorie) {
    nameField.setText(Nom_categorie);
}

public String getNameField() {
    return nameField.getText();
}

    @FXML
    private TextField nameField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

  
    }    

    @FXML
    private void savecategorie(ActionEvent event) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void annulermodification(ActionEvent event) {
        nameField.setText(null);
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
    }
    
}
