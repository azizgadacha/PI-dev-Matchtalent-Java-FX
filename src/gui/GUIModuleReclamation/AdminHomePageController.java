/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class AdminHomePageController implements Initializable {

    @FXML
    private Button btn_home;
    @FXML
    private Button btn_user;
    @FXML
    private Button btn_offre;
    @FXML
    private Button btn_reclamation;
    @FXML
    private Button btn_parametre;
    @FXML
    private Pane pane_status;
    @FXML
    private Label lab_one;
    @FXML
    private Label lab_two;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
 
        if (event.getSource() == btn_home)
        {
            lab_one.setText("/Home");
            lab_two.setText("Home");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
            if (event.getSource() == btn_user)
        {
            lab_one.setText("/Home/User");
            lab_two.setText("User");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                if (event.getSource() == btn_offre)
        {
            lab_one.setText("/Home/Offer");
            lab_two.setText("Offer");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                    if (event.getSource() == btn_reclamation)
        {
            lab_one.setText("/Home/Reclamation");
            lab_two.setText("Reclamation");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                        if (event.getSource() == btn_parametre)
        {
            lab_one.setText("/Home/Setting");
            lab_two.setText("Setting");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } 
        
    }
    
    /*@FXML
    private void afficher(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReclamation.fxml"));
            Parent root = loader.load();
            ListReclamationController controller = loader.getController();
            
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }*/
    @FXML
private void afficher(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReclamation.fxml"));
        Parent root = loader.load();
        ListReclamationController controller = loader.getController();
        Scene currentScene = btn_home.getScene();
        currentScene.setRoot(root);
    } catch (IOException ex) {
        System.out.println("error" + ex.getMessage());
    }
}
    
}
