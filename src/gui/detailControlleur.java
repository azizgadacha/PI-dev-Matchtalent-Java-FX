package gui;

import entities.candidature;
import entities.utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
    @FXML
    private GridPane grid;

candidature c;
    public void setDialogPane(candidature u){
        this.c=u;
    name.setText(u.getUtilisateur().getUsername());
    email.setText(u.getUtilisateur().getEmail());
    note.setText(String.valueOf(u.getNote()));
    contact.setText(u.getUtilisateur().getContact());
        int longeur =0;

        try {
            for(int i=0;i<c.getReponse().length();i++){

                grid.add(new Label(String.valueOf(c.getReponse().charAt(i))), longeur, 0);
            longeur++;

            grid.add(new Label("      "), longeur,0);
            }
    }catch (Exception e){
        }
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

}
}
