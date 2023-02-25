package gui;

import entities.candidature;
import entities.rendez_vous;
import entities.utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Rendez_vous_service;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class addRDVControlleur implements Initializable {
private  Boolean succes=false ;
    @FXML
    private Text erroraria;
    @FXML
    private ChoiceBox<Integer> CB1;
    @FXML
    private Button buttonok;
    @FXML
    private ChoiceBox<Integer> CB2;

    @FXML
    private DatePicker date_Picker;
    private int[] a = IntStream.range(1, 30).toArray();
    candidature c;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=8;i<18;i++) {
            CB1.getItems().add(i);
        }
        for (int i=0;i<60;i++) {
            CB2.getItems().add(i);
        }
        CB2.setValue(9);
        CB1.setValue(8);
    }
    @FXML
    void clickAdd(ActionEvent event) throws SQLException {
        LocalDate localDate = LocalDate.now();
        Rendez_vous_service rs=new Rendez_vous_service();
       Date res=Date.from(date_Picker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        String time=(CB1.getValue())+":"+(CB2.getValue()).toString();

      if((((date_Picker).getValue()).isAfter(localDate))&&(rs.getSpecified(new rendez_vous(res,time,c.getAnnonce())).size()==0)){
rs.ajouter(new rendez_vous( new utilisateur(c.getId_candidature()),res,time,c.getAnnonce()));
          Stage stage = (Stage) buttonok.getScene().getWindow();
          stage.close();

        }else erroraria.setText("vous avez entrez une date deja existant");
  }

    @FXML
    void clickClose(ActionEvent event) {
        Stage stage = (Stage) buttonok.getScene().getWindow();
        stage.close();
    }
    @FXML
    void changedDate() {
        LocalDate localDate = LocalDate.now();
        if(((date_Picker).getValue()).isAfter(localDate)){
            erroraria.setText("");

            succes=true;
}else {            erroraria.setText("vous avez entrez une date invalid");
            succes=false;
    }}

    public void setValues(candidature candidatureInstance){
       c=candidatureInstance;
        }



}
