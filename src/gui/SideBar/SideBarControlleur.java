/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.SideBar;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class SideBarControlleur implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private ImageView img;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private StackPane content;

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
          // Set the first page as the content
//        content.getChildren().add(loadPage("../Candidature/Candidature.fxml"));
    }    

    @FXML
    private void closePage(MouseEvent event) {
         Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadPage1(ActionEvent event) throws IOException {
//        loadPageToContent("../Candidature/Candidature.fxml");
    }

    @FXML
    private void loadPage2(ActionEvent event) {
//        loadPageToContent("../RDV/RDV_Viewer.fxml");
    }

    @FXML
    private void loadPage3(ActionEvent event) {
//        loadPageToContent("../Chart/Barchart.fxml");
    }
   private void loadPageToContent(String pageName) throws IOException {
        // Remove any existing content from the content region
        content.getChildren().clear();

        // Add the new content to the content region
        content.getChildren().add(loadPage(pageName));
    }

    private Node loadPage(String fxmlFileName) throws IOException {
        URL fxmlUrl = getClass().getResource(fxmlFileName);
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        return loader.load();
    }  
}
