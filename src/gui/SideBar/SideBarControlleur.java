package gui.SideBar;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SideBarControlleur {
    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox sidebar;

    @FXML
    private StackPane content;

    private Map<String, Node> pages = new HashMap<>();

    @FXML
    private void initialize() {
        // Load the FXML pages and add them to the pages map
        try {
            pages.put("page1", loadPage("../Candidature/Candidature.fxml"));
            pages.put("page2", loadPage("Page2.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the first page as the content
        content.getChildren().add(pages.get("page1"));
    }

    @FXML
    private void loadPage1() {
        loadPageToContent("page1");
    }

    @FXML
    private void loadPage2() {
        loadPageToContent("page2");
    }

    private void loadPageToContent(String pageName) {
        // Remove any existing content from the content region
        content.getChildren().clear();

        // Add the new content to the content region
        content.getChildren().add(pages.get(pageName));
    }

    private Node loadPage(String fxmlFileName) throws IOException {
        URL fxmlUrl = getClass().getResource(fxmlFileName);
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        return loader.load();
    }
}