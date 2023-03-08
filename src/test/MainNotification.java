/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import gui.NotificationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.NotificationServer;

/**
 *
 * @author Hend
 */
public class MainNotification extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/notification.fxml"));
        //NotificationController controller = new NotificationController();
        //loader.setController(controller);
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("JavaFX Notification with UDP");
        primaryStage.show();

        // Start the server
        //NotificationServer.main(null);
        Thread serverThread = new Thread(() -> {
            try {
                NotificationServer.main(null);
            } catch (Exception ex) {
                Logger.getLogger(MainNotification.class.getName()).log(Level.SEVERE, null, ex);
            }
});
serverThread.setDaemon(true);
serverThread.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}