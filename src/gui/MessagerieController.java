/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import services.ModuleReclamation.Server;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class MessagerieController implements Initializable {

    @FXML
    private AnchorPane ap_main;
    @FXML
    private Button button_send;
    @FXML
    private TextField tf_message;
    @FXML
    private ScrollPane app_main;
    @FXML
    private VBox vbox_messages;

 
    /**
     * Initializes the controller class.
     */
    private Server server;
//In the initialize method, the class creates a new Server object and sets up a listener on the height of the vbox_messages VBox. 
    //This listener ensures that the scroll pane always scrolls to the bottom when new messages are added to the VBox.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            server = new Server(new ServerSocket(9000));
            System.out.println("Connected to Client!");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error creating Server ... ");
        }
        vbox_messages.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                app_main.setVvalue((Double) newValue);
            }
        });
//The server.receiveMessageFromClient method is called, passing in the vbox_messages VBox as a parameter. 
//This sets up the server to listen for incoming messages from the client and add them to the VBox.
            server.receiveMessageFromClient(vbox_messages);

            button_send.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String messageToSend = tf_message.getText();
                    /*if (!messageToSend.isBlank()) {
                        HBox hBox = new HBox();
                        hBox.setAlignment(Pos.CENTER_RIGHT);
                        hBox.setPadding(new Insets(5, 5, 5, 10));

                        Text text = new Text(messageToSend);
                        TextFlow textFlow = new TextFlow(text);

                        textFlow.setStyle(
                                "-fx-color: rgb(239, 242, 255);" +
                                        "-fx-background-color: rgb(15, 125, 242);" +
                                        "-fx-background-radius: 20px;");

                        textFlow.setPadding(new Insets(5, 10, 5, 10));
                        text.setFill(Color.color(0.934, 0.925, 0.996));

                        hBox.getChildren().add(textFlow);
                        vbox_messages.getChildren().add(hBox);

                        server.sendMessageToClient(messageToSend);
                        tf_message.clear();
                    }*/
                }
            });
    }
//the addLabel method is a helper method that adds a new message to the VBox. It takes a messageFromClient string and a vBox VBox as parameters, creates a new HBox to hold the message, and adds it to the VBox. 
    //The method is designed to be called from the Server class when a new message is received from the client.
    public static void addLabel(String messageFromClient, VBox vBox){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5, 5, 5, 10));

        Text text = new Text(messageFromClient);
        TextFlow textFlow = new TextFlow(text);

        textFlow.setStyle(
                        "-fx-background-color: rgb(233, 233, 235);" +
                        "-fx-background-radius: 20px;");

        textFlow.setPadding(new Insets(5, 10, 5, 10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox);
            }
        });
    }

    
        
    
}
