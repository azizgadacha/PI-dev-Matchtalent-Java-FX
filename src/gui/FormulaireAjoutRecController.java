/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class FormulaireAjoutRecController implements Initializable {

    @FXML
    private TextField ch_title;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField ch_desc;
    @FXML
    private Button btn_list;
    
    ReclamationService ps = new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> objetList = FXCollections.observableArrayList();
        objetList.addAll("C", "T", "S");
        combo.setItems(objetList);
    }   
    
     @FXML
    private void select(ActionEvent event) {
        String selectedObject = combo.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        reclamation p = new reclamation();
            p.setTitre(ch_title.getText());
            p.setDescription(ch_desc.getText());
           // p.setId_utilisateur(Integer.parseInt(ch_id.getText()));
            p.setUtilisateur(new utilisateur(1));
            //p.setType(TypeReclamation.valueOf(ch_type.getText()));
            //p.setType(TypeReclamation.valueOf(combo.getSelectionModel().getSelectedItem().toString()));
            //p.setType(TypeReclamation.SecurityIssues);
            p.setDate(new Date());
            ps.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Reclamation added successfully!");
            alert.showAndWait();

            System.out.println("Reclamation added successfully!");
       
        
    }

    @FXML
    private void Lister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReponse.fxml"));
            Parent root = loader.load();
           // ListReclamationController controller = loader.getController();
            //controller.setData(ch_title.getText() + " " + ch_desc.getText()
            //+ " " + ch_date.getValue().atStartOfDay() + " " + combo.getSelectionModel().getSelectedItem().toString());
            Scene currentScene = btn_list.getScene();
            currentScene.setRoot(root);
    }
    
}
