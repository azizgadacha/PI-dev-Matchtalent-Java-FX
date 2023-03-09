
package gui;

import java.io.IOException;
import java.net.URL;
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
        loader.setLocation(getClass().getResource("login_form.fxml"));
        Login_formController ircc = loader.getController();
        
        
         FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Motpasseoublie.fxml"));
        MotpasseoublieController mpoub = loader.getController();
        
        
       int x = MotpasseoublieController.codem;
        
        String y=MotpasseoublieController.emailll;
        System.out.println(y+"hhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            int id = sc.getIdbyEmail(y);
        
        System.out.println("id"+id);
        
        
        if(x == Integer.parseInt(csecurite.getText())) {
            sc.setNewMotPass(id, newPass);
            
        FXMLLoader loaderr = new FXMLLoader();
        nvpassword.getScene().getWindow().hide();
        Stage prStage = new Stage();
        loaderr.setLocation(getClass().getResource("login_form.fxml"));
        Parent root = loaderr.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        prStage.setResizable(false);

        prStage.show();
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
    
}
