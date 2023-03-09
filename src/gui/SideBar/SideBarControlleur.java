package gui.SideBar;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SideBarControlleur {
    @FXML
    private BorderPane mainPane;

    @FXML
    private ImageView img;
    @FXML
    private StackPane content;

    private Map<String, Node> pages = new HashMap<>();
    @FXML
    private Button btnPostulation;
    @FXML
    private Button btnListePostulations;
    @FXML
    private Button files_ajout;

    private void initialize() throws IOException {
        // Set the first page as the content
        content.getChildren().add(loadPage("../File.fxml"));
    }
//    @FXML
//    void closePage(MouseEvent event) {
//        Stage stage = (Stage) img.getScene().getWindow();
//        stage.close();
//    }
//
    @FXML
    private void loadPage1() throws IOException {
        loadPageToContent("../File/File.fxml");
       
    }
    @FXML
    private void loadPage2() throws IOException {
        loadPageToContent("../ViewPost/ShowMesPostulation.fxml");        //../ShowMesPostulation.fxml
    }

//    @FXML
//    private void loadPage2() throws IOException {
//        loadPageToContent("../RDV/RDV_Viewer.fxml");
//    }
//    @FXML
//    private void loadPage3() throws IOException {
//        loadPageToContent("../Chart/Barchart.fxml");
//    }

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

   @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadPage3(ActionEvent event) throws IOException {
                loadPageToContent("../AjoutPost/ApplyNow.fxml");

    }

   
}