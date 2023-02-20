/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ReclamationService;

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
    
    ReclamationService ps = new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<String> objetList = FXCollections.observableArrayList();
        objetList.addAll("Content-related issues", "Technical issues", "Security issues");
        combo.setItems(objetList);

    }    

    @FXML
    private void select(ActionEvent event) {
        String selectedObject = combo.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    private void ajouter(ActionEvent event) {
        try {
            reclamation p = new reclamation();
            p.setTitre(ch_title.getText());
            p.setDescription(ch_desc.getText());
            ps.ajouter(p);
            System.out.println("reclamation ajouter avec succes");
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
