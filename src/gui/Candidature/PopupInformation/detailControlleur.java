package gui.Candidature.PopupInformation;

import entities.Postulation;
import entities.candidature;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
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

        String destination = "../" + p.getIdFile().getNamedeplome(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(p.getIdFile().getDeplome());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void UploadLettre(MouseEvent event) {

        String destination = "../" + p.getIdFile().getNamelettreMotivation(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(p.getIdFile().getLettremotivation());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void uploadCV(MouseEvent event) {

        String destination = "../" + p.getIdFile().getNameCV(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(p.getIdFile().getCv());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
