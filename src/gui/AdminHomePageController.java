/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Button;
import static java.awt.Color.red;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;


/**
 *
 * @author Hend
 */
public class AdminHomePageController implements Initializable{
    
    
    @FXML
    private Button btn_home;

    @FXML
    private Button btn_offre;

    @FXML
    private Button btn_parametre;

    @FXML
    private Button btn_reclamation;

    @FXML
    private Button btn_user;
    
    @FXML
    private Label lab_one;

    @FXML
    private Label lab_two;

    @FXML
    private Pane pane_status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void handleClicks(ActionEvent event)
    {
        if (event.getSource() == btn_home)
        {
            lab_one.setText("/Accueil/Tableau de board");
            lab_two.setText("Tableau de board");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
            if (event.getSource() == btn_user)
        {
            lab_one.setText("/Accueil/User");
            lab_two.setText("User");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                if (event.getSource() == btn_offre)
        {
            lab_one.setText("/Accueil/Offre");
            lab_two.setText("Offre");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                    if (event.getSource() == btn_reclamation)
        {
            lab_one.setText("/Accueil/Reclamation");
            lab_two.setText("Reclamation");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
                        if (event.getSource() == btn_parametre)
        {
            lab_one.setText("/Accueil/Parametre");
            lab_two.setText("Parametre");
            pane_status.setBackground (new Background(new BackgroundFill(Color.rgb(63,43, 99), CornerRadii.EMPTY, Insets.EMPTY)));
        } 
        
    }
}
