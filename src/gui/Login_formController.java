 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import services.UtilisateurService;
import utils.SendMail;
import utils.User_Connected;


/**
 * FXML Controller class
 *
 * @author nawelhammami
 */
public class Login_formController implements Initializable {

    private TextField username;
    @FXML
    private PasswordField mot_de_passe;
    @FXML
    private Button btn_login;
    @FXML
    private Button MotpassOublieeBtn;
    @FXML
    private Button btn_signup;
       public static String emailUser;
    public static String motpass;
    
        public static int  codem;
    @FXML
    private TextField email;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
    
    
    
    
    PreparedStatement pr; 
    ResultSet res;
    
    @FXML
    private void Login(ActionEvent event) throws SQLException, IOException {
        
       
         emailUser = email.getText();
         motpass = mot_de_passe.getText();
            Alert alert;
            if (emailUser.isEmpty() || motpass.isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("les champs sont vides");
                alert.showAndWait();
            } else {
               UtilisateurService us =  new UtilisateurService();
               List<Utilisateur> utilisateur_list = new ArrayList<>();
               System.out.println(email.getText());
               utilisateur_list=us.recupererUser(new Utilisateur(email.getText(),mot_de_passe.getText()));
                if (utilisateur_list.size()==1) {
                    
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("successfully Login");
                        alert.showAndWait();
                        User_Connected.setU(utilisateur_list.get(0));
                        //  ADMIN login:
                        
                        if(email.getText().equals("admin@match.tn") && mot_de_passe.getText().equals("admin")) {
                                
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ListUsers.fxml"));
                        Parent root = loader.load();
                        Scene sc = new Scene(root);
                        Stage primaryStage=(Stage) btn_login.getScene().getWindow();
                        primaryStage.setScene(sc);
                        primaryStage.setTitle("List Utilisateurs");
                        primaryStage.show();
                        }
                        else{
                            System.out.println("3aslema 1 "+email.getText().equals("admin@match.tn"));
                                                        System.out.println("3aslema 1 "+email.getText());

                            System.out.println("3aslema 2 "+mot_de_passe.getText().equals("admin"));
                            System.out.println("3aslema 2 "+mot_de_passe.getText());
                        }
                        
                        
                        
                   
                    
                        
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect email or password");
                    alert.showAndWait();
                }
            }
       
    }

    private void GoInsc(ActionEvent event) throws IOException {
        
           FXMLLoader loader = new FXMLLoader();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("SignUpUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
    }

    @FXML
    private void MotpassOubliee(ActionEvent event) throws IOException, MessagingException {
       /* UtilisateurService sc = new UtilisateurService();
   		
        Random r = new Random ();
      codem =r.nextInt(9999-1000+1);
                System.out.println(codem);
                //sc.setCodepass(sc.getIdbymail(t1.getText()), codem);

        //System.out.println(sc.getPassbyId(sc.getIdbymail(t1.getText())));
        if(isValidEmailAddress(email.getText())){
   //     SendMail.send(t1.getText(), sc.getPassbyId(sc.getIdbymail(t1.getText())));
   SendMail.send(email.getText(), codem);
          FXMLLoader loader = new FXMLLoader();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();}
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Adresse Email Non Valide !!!");
            alert.showAndWait();
        }
       */
         FXMLLoader loader = new FXMLLoader();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();}

    @FXML
    private void GoSignup(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
        Stage prStage = new Stage();
        loader.setLocation(getClass().getResource("SignUpUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);
        prStage.show();
        
    }


    
}
