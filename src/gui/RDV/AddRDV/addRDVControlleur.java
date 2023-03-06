package gui.RDV.AddRDV;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import entities.candidature;
import entities.rendez_vous;
import entities.utilisateur;
import gui.RDV.Modify_RDV.ModifyRDVControlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Mailer;
import services.Rendez_vous_service;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
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
    public interface AddListener {
        void onInfoSentAdd( Boolean var) throws SQLException;
    }
    private AddListener listener;

    public void setAddListner(AddListener listener) {
        this.listener = listener;
    }
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
        System.out.println("kkk");
        System.out.println(date_Picker.getValue()==null);
        if(date_Picker.getValue()==null){
            erroraria.setText("entrez une date s'il vous plait");
        }else{
       Date res=Date.from(date_Picker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        String time=(CB1.getValue())+":"+(CB2.getValue()).toString();

      if((((date_Picker).getValue()).isAfter(localDate))&&(rs.getSpecified(new rendez_vous(res,time,c.getAnnonce())).size()==0)){
rs.ajouter(new rendez_vous( new utilisateur(c.getUtilisateur().getId()),res,time,c.getAnnonce()));
          if (listener != null) {
              listener.onInfoSentAdd(true);
          }
          Mailer mailer=new Mailer();
          Mailer.send("validation.message@gmail.com","fttpjdgxydfvfrui","aziz.gadacha@esprit.tn","hello javatpoint","How r u?");


        /*  String to = "aziz.gadacha@esprit.tn";
          String from = "validation.message@gmail.com";
          String host = "smtp.example.com";
          String port = "587"; // SMTP port for your mail provider
          String username = "validation message";
          String password = "fttpjdgxydfvfrui";
          String subject = "Test Email";
          String body = "This is a test email sent from Java.";

          Properties props = new Properties();
          props.put("mail.smtp.host", host);
          props.put("mail.smtp.port", port);
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");

          Session session = Session.getInstance(props, new javax.mail.Authenticator() {
              protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                  return new javax.mail.PasswordAuthentication(username, password);
              }
          });


          try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(from));
              message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
              message.setSubject(subject);
              message.setText(body);

              Transport.send(message);

              System.out.println("Email sent successfully!");

          } catch (MessagingException e) {
              throw new RuntimeException(e);
          }
*/

          Stage stage = (Stage) buttonok.getScene().getWindow();
          stage.close();


        }else erroraria.setText("vous avez entrez une date deja existant");}
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
        System.out.println("test1"+c.getUtilisateur().getId());
        System.out.println("test2"+c.getUtilisateur().getUsername());
        }



}
