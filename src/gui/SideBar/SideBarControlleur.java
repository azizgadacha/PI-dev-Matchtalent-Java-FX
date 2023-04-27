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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.UserConnect;

public class SideBarControlleur implements Initializable {

    @FXML
    private Button AcceptPostulation;

    @FXML
    private Button CandidatureButton;

    @FXML
    private Button RendezVousButton;

    @FXML
    private Button UserListeButton;

    @FXML
    private Button AnnonceButton;
    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox sidebar;
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane leftanchorpane;
    @FXML
    private StackPane content;

    @FXML
    private VBox left;

    private Map<String, Node> pages = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        if (UserConnect.getUser().getRole().getNom_role().equals("ADMIN")){
            System.out.println("rani lena bb");
            AnnonceButton.setVisible(false);
            btnPackages.setVisible(false);
            btnSettings.setVisible(false);
           AcceptPostulation.setVisible(false);

           CandidatureButton.setVisible(false);

            RendezVousButton.setVisible(false);

            content.getChildren().add(loadPage("../Admin/UserListe.fxml"));

           // left.setAlignment();
            UserListeButton.setLayoutX(150);
        }
        else {
           UserListeButton.setVisible(false);

            content.getChildren().add(loadPage("../Candidature/Candidature.fxml"));
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

  /*  @FXML
    private void initialize() throws IOException {
        // Set the first page as the content

    }*/

    @FXML
    void LoadAnnonceButton(ActionEvent event) throws IOException {
        loadPageToContent("/gui/Annonce/ListeAnnonce/AfficherAnnonce.fxml");

    }

    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadPage1() throws IOException {

        loadPageToContent("../Candidature/Candidature.fxml");
    }

    @FXML
    private void loadPage2() throws IOException {
        loadPageToContent("../RDV/RDV_Viewer.fxml");
    }
    @FXML
    private void loadPage3() throws IOException {
        loadPageToContent("../Decision_Passer_Quiz/Decider_Passer_Quiz.fxml");
    }
    @FXML
    private void loadPageListeUser() throws IOException {
        loadPageToContent("../Admin/UserListe.fxml");
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