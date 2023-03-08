package gui.Candidature.PopupInformation;

import entities.Postulation;
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

candidature c=null;
Postulation p=null;
    public void setDialogPane(Object u){
        if (u instanceof Postulation)
        this.p= (Postulation) u;
        else
            this.c= (candidature) u;

        name.setText(p==null? c.getUtilisateur().getUsername():p.getUtilisateur().getUsername());
    email.setText(p==null? c.getUtilisateur().getEmail():p.getUtilisateur().getEmail());
    note.setText(p==null?String.valueOf( c.getNote()):p.getUtilisateur().getUsername());
    contact.setText(p==null? c.getUtilisateur().getContact():p.getUtilisateur().getContact());
        int longeur =0;

      if (c!=null)
      {            for(int i=0;i<c.getReponse().length();i++) {

          grid.add(new Label(String.valueOf(c.getReponse().charAt(i))), longeur, 0);
          longeur++;

          grid.add(new Label("      "), longeur, 0);
      }     }

}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

}
}
