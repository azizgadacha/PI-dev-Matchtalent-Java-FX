package gui.Decision_Passer_Quiz.table_Element_Decision;

import entities.Postulation;
import gui.Decision_Passer_Quiz.PopupInformation.detailControlleur;
import gui.RDV.AddRDV.addRDVControlleur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.CondidatureService;
import services.PoService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class Item_Decision {

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
    private Label addesress;
    Postulation PostulationInstance;
    PoService ps=new PoService();
    public interface PopupListener {
        void onInfoSentChange( Boolean var) throws SQLException;
    }
    private PopupListener listener;

    public void setChangeListener(PopupListener listener) {
        this.listener = listener;
    }

public  void  setValues(Postulation c){
    this.PostulationInstance=c;
    name.setText(c.getUtilisateur().getUsername());
    addesress.setText(c.getUtilisateur().getAddress());
}
    @FXML
    void AddCandidature(MouseEvent event) throws SQLException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Refus Postulation");

        alert.setHeaderText("etes vous sure que cette utilisateur peut passer le quiz ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            {
                CondidatureService cs=new CondidatureService();
                cs.ajouter_from_postulation(PostulationInstance);
                ps.modifier(PostulationInstance,"passer quiz");
                if (listener != null) {
                    listener.onInfoSentChange(true);
                }

            }}
    }


    @FXML
    void RefuserPostulation() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Refus Postulation");

       // alert.setContentText("etes vous sure vous voulez refuser l'annonce ");
        alert.setHeaderText("etes vous sure vous voulez refuser la postulation ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            {
                ps.modifier(PostulationInstance,"refuser");

                if (listener != null) {
                    listener.onInfoSentChange(true);
                }

            }}}



    @FXML
    void ViewDetail(MouseEvent event) throws IOException {
        Stage detail =(Stage) ((Node)event.getSource()).getScene().getWindow();
        double x=detail.getX();
        double y=detail.getY();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../PopupInformation/popup_User_Info.fxml"));
            DialogPane  detailPage=loader.load();

            detailControlleur detailControlleur =loader.getController();
            detailControlleur.setDialogPane(PostulationInstance);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.initStyle(StageStyle.UNDECORATED);

            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");


    }


}