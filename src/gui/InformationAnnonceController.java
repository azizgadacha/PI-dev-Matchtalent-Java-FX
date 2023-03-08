/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class InformationAnnonceController implements Initializable {

    @FXML
    private Label getcat;
    @FXML
    private Label gettire;
    @FXML
    private Label getnomsociete;
    @FXML
    private Label getdescription;
    @FXML
    private Label getdateDebut;
    @FXML
    private Label getdateFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void infoAnnonce(Annonce a) {
        
//           annonce = a;
     gettire.setText(String.valueOf(a.getTitre()));
     getnomsociete.setText(String.valueOf(a.getNom_societe()));   
     getdescription.setText(String.valueOf(a.getDescription()));   
     getcat.setText(String.valueOf(a.getCategorie()));
     getdateDebut.setText(String.valueOf(a.getDateDebut()));   
     getdateFin.setText(String.valueOf(a.getDateFin()));
     
}
    
}
