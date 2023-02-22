package gui;

import entities.candidature;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class elementController  {

    @FXML
    private Label contact;

    @FXML
    private HBox itemC;

    @FXML
    private Label mail;
    @FXML
    private Label address;
    @FXML
    private Label name;


    @FXML
    private Label note;
    candidature candidatureInstance;
public  void  setValues(candidature c){
    this.candidatureInstance=c;
    name.setText(c.getUtilisateur().getUsername());
    note.setText(String.valueOf(c.getNote()));
}
    @FXML
    void AddRdv(ActionEvent event) {
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../gui/RDVPopup.fxml"));
            DialogPane  detailPage=loader.load();
            RDVControlleur detailControlleur =loader.getController();
            //detailControlleur.setDialogPane(candidatureInstance);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");

        }catch (Exception e){
        }
    }


    @FXML
    void onClick(ActionEvent event) {
        System.out.println("jefefef");
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../gui/popup.fxml"));
            DialogPane  detailPage=loader.load();
            detailControlleur detailControlleur =loader.getController();
            detailControlleur.setDialogPane(candidatureInstance);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");

        }catch (Exception e){
        }
    }


}