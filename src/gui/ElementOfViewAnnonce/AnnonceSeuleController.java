/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ElementOfViewAnnonce;

import entities.Annonce;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.InfoAnnonce.InformationAnnonceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AnnonceSeuleController implements Initializable {

    private Text getIdText;
    @FXML
    private Label getTitre;
    @FXML
    private Button plsInfoButton;
    
    private Annonce annonce;
    @FXML
    private Text getNomSociete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void infoAnnonce(Annonce a) {
        annonce = a;
     getNomSociete.setText(String.valueOf(a.getNom_societe()));   
     getTitre.setText(String.valueOf(a.getTitre()));   
}

    @FXML
    private void plusInfo(ActionEvent event) {
        try {
            Node node = getNomSociete; // the node to navigate from
FXMLLoader newInterface = new FXMLLoader(getClass().getResource("InformationAnnonce.fxml"));
Parent content = newInterface.load();
Scene newScene = new Scene(content);
Scene currentScene = node.getScene();
Stage currentStage = (Stage) currentScene.getWindow();
currentStage.setScene(newScene);
currentStage.show();
            InformationAnnonceController controller = newInterface.getController();
            controller.infoAnnonce(annonce);
        } catch (IOException ex) {
            Logger.getLogger(AnnonceSeuleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
