/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Annonce.ElementOfViewAnnonce;

import entities.Annonce;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import gui.Annonce.InfoAnnonce.InformationAnnonceController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.UserConnect;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AnnonceSeuleController implements Initializable {

    @FXML
    private Button postlationbutton;
    private Text getIdText;
    @FXML
    private Label getTitre;
    @FXML
    private Button plsInfoButton;
    
    private Annonce annonce;
    @FXML
    private Label getNomSociete;

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

        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/gui/Annonce/InfoAnnonce/InformationAnnonce.fxml"));
            DialogPane detailPage=loader.load();


            InformationAnnonceController detailControlleur =loader.getController();
            detailControlleur. infoAnnonce(annonce);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.initStyle(StageStyle.UNDECORATED);

            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");

        }catch (Exception e){
        }

    }

    @FXML
    void postulationAction(ActionEvent event) {
if (UserConnect.getUser().getRole().getNom_role().equals("DEMANDEUR")){

}

    }
    
}
