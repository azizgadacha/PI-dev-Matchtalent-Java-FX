package gui.Candidature.TableElement;

import entities.candidature;
import entities.rendez_vous;
import gui.RDV.AddRDV.addRDVControlleur;
import gui.Candidature.PopupInformation.detailControlleur;
import gui.RDV.Modify_RDV.ModifyRDVControlleur;
import gui.RDV.tableElement.RDVelement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.CondidatureService;

import java.sql.SQLException;
import java.util.Optional;

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
    private ImageView imgView;

    @FXML
    private Label note;
    candidature candidatureInstance;
    CondidatureService cs=new CondidatureService();
    public interface PopupListener {
        void onInfoSentChange( Boolean var) throws SQLException;
    }
    private PopupListener listener;

    public void setChangeListener(PopupListener listener) {
        this.listener = listener;
    }

public  void  setValues(candidature c){
    this.candidatureInstance=c;
    name.setText(c.getUtilisateur().getUsername());
    note.setText(String.valueOf(c.getNote()));
}
    @FXML
    void AddRdv(MouseEvent event) {
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();

        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../../RDV/AddRDV/RDVPopup.fxml"));
            DialogPane  detailPage=loader.load();
            addRDVControlleur AddRdvControlleur =loader.getController();
            AddRdvControlleur.setAddListner(new addRDVControlleur.AddListener() {
                @Override
                public void onInfoSentAdd( Boolean var) throws SQLException {
                    if (var) {
                        if (listener != null) {
                            listener.onInfoSentChange(true);
                        }                    }
                }

            });
            AddRdvControlleur.setValues(candidatureInstance);

            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.initStyle(StageStyle.UNDECORATED);

            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");


        }catch (Exception e){
        }
    }


    @FXML
    void supprimerCandidature() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Refus Candidature");
       // alert.setContentText("etes vous sure vous voulez refuser l'annonce ");
        alert.setHeaderText("etes vous sure vous voulez refuser l'annonce ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            {
                cs.supprimer(candidatureInstance);

                if (listener != null) {
                    listener.onInfoSentChange(true);
                }

            }}}



    @FXML
    void ViewDetail(MouseEvent event) {
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../PopupInformation/popup_User_Info.fxml"));
            DialogPane  detailPage=loader.load();

            detailControlleur detailControlleur =loader.getController();
            detailControlleur.setDialogPane(candidatureInstance);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.initStyle(StageStyle.UNDECORATED);

            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");

        }catch (Exception e){
        }
    }


}