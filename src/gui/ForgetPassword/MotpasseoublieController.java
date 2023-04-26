/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.ForgetPassword;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import services.UtilisateurService;
import utils.SendMail;

/**
 * FXML Controller class
 *
 * @author nawelhammami
 */
public class MotpasseoublieController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Button btn_signup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        UtilisateurService sc = new UtilisateurService();
if ((sc.getIdbyEmail(email)==-1))
    return false;
    else
        return result;
    }
    
    

        public static int  codem;
        
        public static String emailll;
double x,y;
    @FXML
    private void MotpassOubliee(ActionEvent event) throws MessagingException, IOException {
           UtilisateurService sc = new UtilisateurService();
   		
        Random r = new Random ();
      codem =r.nextInt(9999-1000+1);
                System.out.println(codem);
                
                emailll = email.getText();
                
                //sc.setCodepass(sc.getIdbymail(t1.getText()), codem);

        //System.out.println(sc.getPassbyId(sc.getIdbymail(t1.getText())));
        if(isValidEmailAddress(emailll)){
   //     SendMail.send(t1.getText(), sc.getPassbyId(sc.getIdbymail(t1.getText())));
   SendMail.send(emailll, codem);
   
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

                          alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("Code de sécurité envoyé, veuillez vérifier votre email.");
        alert.showAndWait();

            Stage primaryStage=(Stage) btn_signup.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("NewPassword.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless

            //drag it here
            root.setOnMousePressed(event1 -> {
                x = event1.getSceneX();
                y = event1.getSceneY();
            });
            root.setOnMouseDragged(event1 -> {

                primaryStage.setX(event1.getScreenX() - x);
                primaryStage.setY(event1.getScreenY() - y);

            });
            primaryStage.show();}


        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Adresse Email Non Valide !!!");
            alert.showAndWait();
        }
       
    }
    @FXML
    void ReturnLogin(ActionEvent event) throws IOException {
        Stage primaryStage=(Stage) btn_signup.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/login_form.fxml"));
        primaryStage.setScene(new Scene(root));
        //set stage borderless

        //drag it here
        root.setOnMousePressed(event1 -> {
            x = event1.getSceneX();
            y = event1.getSceneY();
        });
        root.setOnMouseDragged(event1 -> {

            primaryStage.setX(event1.getScreenX() - x);
            primaryStage.setY(event1.getScreenY() - y);

        });
        primaryStage.show();
    }
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) btn_signup.getScene().getWindow();
        stage.close();
    }
}
