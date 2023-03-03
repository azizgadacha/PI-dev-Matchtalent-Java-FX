/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import services.NotificationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class NotificationController implements Initializable {

    @FXML
    private Label notificationLabel;
    @FXML
    private Button notificationButton;

    private NotificationService notificationService;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        notificationService = new NotificationService();
        notificationService.setOnSucceeded(event -> {
            String message = (String) event.getSource().getValue();
            notificationLabel.setText(message);
        });
    }    

    @FXML
    private void handleNotificationButton(ActionEvent event) {
        notificationService.restart();
        System.out.println("Notification work!");
    }
    
}
