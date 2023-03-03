/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.Reponse_ReclamationService;
import entities.reponse_reclamation;
import entities.utilisateur;
import java.sql.SQLException;
import java.util.Date;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class AjouterReponseController implements Initializable {

    @FXML
    private Button but;
    @FXML
    private TextField rep;

    /**
     * Initializes the controller class.
     */
    Reponse_ReclamationService ps = new Reponse_ReclamationService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException{
        reponse_reclamation r = new reponse_reclamation();
        r.setReponse(rep.getText());
        
         r.setReclamation(new reclamation(1));
           
            r.setDate(new Date());
            ps.ajouter(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Reponse added successfully!");
            alert.showAndWait();

            System.out.println("Reclamation added successfully!");
       
    }
    
}
