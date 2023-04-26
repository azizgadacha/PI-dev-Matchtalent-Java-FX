 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Login;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import services.UtilisateurService;
import test.NewFXMain;
import utils.SendMail;
import utils.UserConnect;


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

     @FXML
     private BorderPane Borderpane;
    
    
    
    
    PreparedStatement pr; 
    ResultSet res;
    
    @FXML
    private void Login(ActionEvent event) throws SQLException, Exception {
        
       
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
               utilisateur_list=us.recupererUser(new Utilisateur(emailUser,motpass));
                if (utilisateur_list.size()==1) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("successfully Login");
                        alert.showAndWait();
                      //  System.out.println("ffff  "+utilisateur_list.get(0).getRole().getNom_role());
                        //  ADMIN login:
                        System.out.println("est "+utilisateur_list.get(0).getRole().getNom_role());
                    new UserConnect(utilisateur_list.get(0));
                        if(utilisateur_list.get(0).getRole().getNom_role().equals("admin")) {
                            NewFXMain M=new NewFXMain();
                            Stage primaryStage=(Stage) btn_login.getScene().getWindow();

                            M.start(primaryStage);
                            /*     System.out.println("sssssss");
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Admin/ListUsers.fxml"));
                            Parent root = loader.load();
                            Scene sc = new Scene(root);
                            Stage primaryStage=(Stage) btn_login.getScene().getWindow();
                            primaryStage.setScene(sc);
                            primaryStage.setTitle("List Utilisateurs");
                            primaryStage.show();
                                */
                    /*   NewFXMain M=new NewFXMain();
                                                     Stage primaryStage=(Stage) btn_login.getScene().getWindow();

                             M.start(primaryStage);
                      */  }else if(true) {
                             NewFXMain M=new NewFXMain();
                                                     Stage primaryStage=(Stage) btn_login.getScene().getWindow();

                             M.start(primaryStage);
                        
                          /* //  Parent root = FXMLLoader.load(getClass().getResource("/gui/SideBar/SideBar.fxml"));
                          FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/SideBar/SideBar.fxml"));
                        Parent root = loader.load();
                       
                        Scene sc = new Scene(root);
                        Stage primaryStage=(Stage) btn_login.getScene().getWindow();
                        primaryStage.setScene(sc);
                        primaryStage.setTitle("List Utilisateurs");
                        
                        primaryStage.show();*/
                            
                        }
                        
                        
                        
                   

                    
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect email or password");
                    alert.showAndWait();
                    /*
                     NewFXMain M=new NewFXMain();
                                                     Stage primaryStage=(Stage) btn_login.getScene().getWindow();

                             M.start(primaryStage);*/
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

        Stage primaryStage=(Stage) btn_login.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/ForgetPassword/Motpasseoublie.fxml"));
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
     private double x, y;

    @FXML
    private void GoSignup(ActionEvent event) throws IOException {

        Stage primaryStage=(Stage) btn_login.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/SignUp/SignUpUser.fxml"));
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
         Stage stage = (Stage) btn_login.getScene().getWindow();
         stage.close();
     }

    
}
