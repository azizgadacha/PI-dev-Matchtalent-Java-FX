/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reponse_reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import services.Reponse_ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ReponseOneItemController implements Initializable {

    @FXML
    private Label label_rep;
    @FXML
    private Label label_date;
    @FXML
    private Button btn_supp;
    
    
    private reponse_reclamation reponse_reclamation;
    private Reponse_ReclamationService service = new Reponse_ReclamationService();

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void SetReponseItem(reponse_reclamation r, GridPane parent) {
        reponse_reclamation = r;
        label_rep.setText(String.valueOf(r.getReponse()));
        label_date.setText(r.getDate().toString());
    }
    
    @FXML
    private void delete(ActionEvent event) {
    }
    
}
