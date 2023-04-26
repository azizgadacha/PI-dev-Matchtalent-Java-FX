
package gui.SignUp;

import entities.Role;
import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.RoleService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author nawelhammami
 */
public class SignUpUserController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private Button btn_login;
    @FXML
    private TextField addresse;
    @FXML
    private PasswordField mot_de_passe;
    @FXML
    private TextField contact;
    @FXML
    private ComboBox<String> role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          RoleService roleService = new RoleService();
        ObservableList<String>arraysRole = FXCollections.observableArrayList();

         
        // create a list of items
        ObservableList<String> items = FXCollections.observableArrayList(
            "DEMANDEUR", "OFFREUR"
        );
        
        // add the items to the ComboBox
        role.getItems().addAll(items);


        
    
      
    }
    private double x, y;

    @FXML
    private void ReturnSignin(ActionEvent event) throws IOException, SQLException {


        Stage primaryStage=(Stage) btn_login.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login/login_form.fxml"));
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
    private void signup(ActionEvent event) throws IOException, SQLException {
        
        
      
        
        
        
        
        if (username.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre username !!!");
        alert.showAndWait();}
        else if (mot_de_passe.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre mot de passe !!!");
        alert.showAndWait();}
        else if (email.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre email !!!");
        alert.showAndWait();}

        else if (contact.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre  contact !!!");
        alert.showAndWait();}
        else if (addresse.getText().isEmpty())
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer votre  addresse !!!");
        alert.showAndWait();}
        
        
           
        else if(role.getSelectionModel().isEmpty())        
        { Alert alert = new Alert(Alert.AlertType.INFORMATION);

                  alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez choisir votre  role !!!");
        alert.showAndWait();}
        
        else
        {  
            if(!email.getText().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) 
                        { Alert alert = new Alert(Alert.AlertType.INFORMATION);

                
                
                            alert.setTitle("Alerte");
        alert.setHeaderText(null);
        alert.setContentText("!!!  Vous devez entrer une email valide  !!!");
        alert.showAndWait();
            }else  {

            Utilisateur u = new Utilisateur();
            u.setUsername(username.getText());
            u.setEmail(email.getText());
            u.setMot_de_passe(mot_de_passe.getText());
            u.setAddress(addresse.getText());
            u.setContact(contact.getText());


            if (role.getValue().equals("OFFREUR")) {
                u.setRole(new Role(3));
            } else if (role.getValue().equals("DEMANDEUR")) {
                u.setRole(new Role(2));
            }
            UtilisateurService sc = new UtilisateurService();
            sc.ajouter(u);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("!!!  Inscription Avec Success !!!");
            alert.showAndWait();



                Stage primaryStage=(Stage) btn_login.getScene().getWindow();

                Parent root = FXMLLoader.load(getClass().getResource("/gui/Login/login_form.fxml"));
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
        }
    }
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.close();
    }
}
