/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import services.UDPService;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class MessageController implements Initializable {

 @FXML
    private ListView<String> messageListView;
    @FXML
    private TextField messageTextField;
    @FXML
    private Button envoyerButton;

    private UDPService udpService;

    // No-argument constructor to prevent improper initialization
   

    public MessageController(UDPService udpService) {
        this.udpService = udpService;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        envoyerButton.setOnAction(event -> {
            String message = messageTextField.getText();
            try {
                udpService.envoyerMessage(message);
                         messageTextField.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void respondToMessage(String message) {
        messageListView.getItems().add(message);
    }

    public void receiveMessage(String message) {
   
    }

    @FXML
    private void envoyermessage(ActionEvent event) {
    }

    void envoyermessage(String message) {
   
    }
}
