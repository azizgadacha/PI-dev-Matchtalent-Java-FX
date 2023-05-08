package gui.Decision_Passer_Quiz.PopupInformation;

import entities.File;
import entities.Postulation;
import entities.candidature;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class detailControlleur implements Initializable {



    @FXML
    private Label email;

    @FXML
    private Label id;
    @FXML
    private Label contact;
    @FXML
    private Label name;
    @FXML
    private Label note;
    private candidature u;


candidature c=null;
Postulation p=null;
    public void setDialogPane(Object u){
        if (u instanceof Postulation)
        this.p= (Postulation) u;
        else
            this.c= (candidature) u;

        name.setText(p==null? c.getUtilisateur().getUsername():p.getUtilisateur().getUsername());
    email.setText(p==null? c.getUtilisateur().getEmail():p.getUtilisateur().getEmail());
    contact.setText(p==null? c.getUtilisateur().getContact():p.getUtilisateur().getContact());
        int longeur =0;



}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

}
    @FXML
    void UploadDiplome(MouseEvent event) {
        File f = p.getIdFile();

        String destination = "../" + f.getNamedeplome(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(f.getDeplome());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "diplome uploaded ", ButtonType.OK); ///
            alert.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void UploadLettre(MouseEvent event) {
        File f = p.getIdFile();

        String destination = "../" + f.getNamelettreMotivation(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(f.getLettremotivation());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "lettre uploaded ", ButtonType.OK); ///
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void uploadCV(MouseEvent event) {
        File f = p.getIdFile();

        String destination = "../" + f.getNameCV(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(f.getCv());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "cv uploaded ", ButtonType.OK); ///
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
