//<<<<<<< HEAD


package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class NewFXMain extends Application {


    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {

            Parent root = FXMLLoader.load(getClass().getResource("../gui/SideBar/SideBar.fxml"));
            primaryStage.setScene(new Scene(root));
            //set stage borderless 
           primaryStage.initStyle(StageStyle.UNDECORATED);

            //drag it here
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);

            });
            primaryStage.show();

        }


    public static void main(String[] args) {
        launch(args);
    }
}
//=======
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
// */
//package test;
//
//import java.io.IOException;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// *
// * @author Hend
// */
//public class NewFXMain extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//         //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterReclamation.fxml")); lee
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FormulaireAjoutRec.fxml"));
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ListReclamation1.fxml"));
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ClientMessagerie.fxml"));
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Email.fxml"));
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AffRec.fxml"));lee
//             //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FXML.fxml"));lee
//             //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AdminHomePage.fxml"));lee
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ListReclamation.fxml"));lee
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AjouterReponse.fxml"));lee
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ListReponse.fxml"));
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Stats.fxml"));
//            //FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/DisplayListReponse.fxml"));lee
//            Parent root = loader.load();
//            Scene scene = new Scene(root,800,600);
//            primaryStage.setScene(scene);
//            primaryStage.setTitle("ModuleReclamation");
//            primaryStage.show();
//
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
//>>>>>>> origin/HendFarah
