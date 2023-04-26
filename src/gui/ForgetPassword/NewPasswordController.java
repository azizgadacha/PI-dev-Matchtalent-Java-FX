
package gui.ForgetPassword;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.Login.Login_formController;
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
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author nawelhammami
 */
public class NewPasswordController implements Initializable {

    @FXML
    private Button btn_signup;
      public static String mail="a";
    @FXML
    private TextField nvpassword;
    @FXML
    private TextField csecurite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
double m,n;
    @FXML
    private void newPasword(ActionEvent event) throws IOException {
          if(nvpassword.getText().isEmpty())
        {  Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!! Champs vide !!!");
            alert.showAndWait();
        }
        else
              
        { 
            
            
            
            String newPass = nvpassword.getText();
            UtilisateurService sc = new UtilisateurService();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/Login/login_form.fxml"));
        Login_formController ircc = loader.getController();
        
        
         FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        MotpasseoublieController mpoub = loader.getController();
        
        
       int x = MotpasseoublieController.codem;
            System.out.println("zezzzz "+x);
        String y=MotpasseoublieController.emailll;
        System.out.println(y+"hhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            int id = sc.getIdbyEmail(y);
        
        System.out.println("id"+id);
        
        
        if(String.valueOf(x).equals(csecurite.getText())) {
            sc.setNewMotPass(id, newPass);

            Stage primaryStage=(Stage) btn_signup.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("/gui/login_form.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless

            //drag it here
            root.setOnMousePressed(event1 -> {
                m = event1.getSceneX();
                n = event1.getSceneY();
            });
            root.setOnMouseDragged(event1 -> {

                primaryStage.setX(event1.getScreenX() - m);
                primaryStage.setY(event1.getScreenY() - n);

            });
            primaryStage.show();
        }
        else {
            {Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  code de Verification erroné !!!");
            alert.showAndWait();
        }
        }
       
        
        }
        
    }
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) btn_signup.getScene().getWindow();
        stage.close();
    }
    
}
