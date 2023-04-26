/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.UDPService;

/**
 *
 * @author acer
 */
public class Maingui extends Application {
    private double x, y; 
    private UDPService udpService;
    

    @Override
    public void start(Stage primaryStage) throws IOException {

          // Load the Interface FXML file
//        FXMLLoader interfaceLoader = new FXMLLoader(getClass().getResource("../gui/interface.fxml"));
//        Parent interfaceRoot = interfaceLoader.load();
//        InterfaceController interfaceController = interfaceLoader.getController();
//
//        // Load the Message FXML file
//        FXMLLoader messageLoader = new FXMLLoader(getClass().getResource("../gui/message.fxml"));
//        MessageController messageController = new MessageController(udpService);
//        messageLoader.setController(messageController);
//        Parent messageRoot = messageLoader.load();
//
//        // Combine the Interface and Message views
//        VBox root = new VBox();
//        root.getChildren().addAll(interfaceRoot, messageRoot);
//
//        // Set the scene and display the window
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Chat App");
//        primaryStage.show();
//    }
        

//        
//        Parent root = FXMLLoader.load(getClass().getResource("../gui/AfficherCategorie.fxml"));
//        primaryStage.setScene(new Scene(root));
//        //set stage borderless
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//
//        //drag it here
//        root.setOnMousePressed(event -> {
//            x = event.getSceneX();
//            y = event.getSceneY();
//        });
//        root.setOnMouseDragged(event -> {
//
//            primaryStage.setX(event.getScreenX() - x);
//            primaryStage.setY(event.getScreenY() - y);
//
//        });
//        primaryStage.show();
//        
//        
//    }
//        
//           
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjoutAnnonce.fxml"));
//            Parent root = loader.load();
//            Scene sc = new Scene(root);
//            primaryStage.setTitle("Annonce");
//            primaryStage.setScene(sc);
//            primaryStage.show();}

        
       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherAnnonce.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            primaryStage.setTitle("Annonce");
            primaryStage.setScene(sc);
            primaryStage.show();
    }

        



    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
