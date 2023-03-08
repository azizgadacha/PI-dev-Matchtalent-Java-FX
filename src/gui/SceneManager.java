package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class SceneManager {

    private static SceneManager instance;

    private FXMLLoader interfaceLoader;
    private FXMLLoader messageLoader;

    private InterfaceController interfaceController;
    private MessageController messageController;

    private SceneManager() throws IOException {
        // Initialize the FXML loaders
        interfaceLoader = new FXMLLoader(getClass().getResource("/gui/Interface.fxml"));
        messageLoader = new FXMLLoader(getClass().getResource("/gui/Message.fxml"));

        // Load the interfaces and controllers
       
            Parent interfaceRoot = interfaceLoader.load();
            Parent messageRoot = messageLoader.load();
            interfaceController = interfaceLoader.getController();
            messageController = messageLoader.getController();
            interfaceController.setMessageController(messageController);
       
    }

    public static SceneManager getInstance() throws IOException {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public InterfaceController getInterfaceController() {
        return interfaceController;
    }

    public MessageController getMessageController() {
        return messageController;
    }

    public Scene getInterfaceScene() {
        return new Scene(interfaceLoader.getRoot());
    }

    public Scene getMessageScene() {
        return new Scene(messageLoader.getRoot());
    }

}
