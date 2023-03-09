/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pidev;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class PIDEV extends Application {
    
 @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Load the FXML file using the FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/login_form.fxml"));
        Pane root = loader.load();
        
        // Create a new Scene with the loaded root node
        Scene scene = new Scene(root, 600, 400);
        
        // Set the title of the window
        primaryStage.setTitle("Display Window");
        
        // Set the scene for the primary stage
        primaryStage.setScene(scene);
        
        // Show the primary stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}





