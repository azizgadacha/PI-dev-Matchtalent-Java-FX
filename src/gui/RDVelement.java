package gui;

import entities.candidature;
import entities.rendez_vous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.Rendez_vous_service;

import java.sql.SQLException;
import java.util.Optional;

public class RDVelement {

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
    @FXML
    private Label username;
    @FXML
    private Label date;
    @FXML
    private Label heure;
    rendez_vous Rendez_vousInstance;
    Rendez_vous_service rs=new Rendez_vous_service();
    public  void  setValues(rendez_vous c){
        System.out.println("hello "+c.getUser().getUsername());
        this.Rendez_vousInstance=c;
        name.setText(c.getAnnonce().getTitre());
        date.setText(String.valueOf(c.getDate_rendez_vous()));
        heure.setText(String.valueOf(c.getHeure_rendez_vous()));
        username.setText(c.getUser().getUsername());
    }
    @FXML
    void supprimerAnnonce(ActionEvent event) throws SQLException {

  rs.supprimer(Rendez_vousInstance);


    }
   /* @FXML
    void AddRdv(ActionEvent event) {
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../gui/RDVPopup.fxml"));
            DialogPane detailPage=loader.load();
            addRDVControlleur detailControlleur =loader.getController();
            detailControlleur.setValues(Rendez_vousInstance);

            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");



        }catch (Exception e){
        }
    }


*/

}
