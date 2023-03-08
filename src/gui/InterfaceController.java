package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import services.UDPService;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class InterfaceController implements Initializable {

    private UDPService udpService;
    
    @FXML
    private ListView<String> messageListView;
    
    @FXML
    private TextField messageTextField;
    
    @FXML
    private Button EnvoyerButton;
    
    @FXML
    private Button shutdownButton;
    
    private MessageController messageController;

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           // udpService = new UDPService("localhost", 55555);
            
            // Pass UDPService instance to the MessageController constructor
            messageController = new MessageController(udpService);
            
        
           
            
        ;

    }
    
    @FXML
    public void shutdown() {
        udpService.close();
    }

@FXML
private void envoyermessage(ActionEvent event) {
    String message = messageTextField.getText(); // Get the text from the messageTextField
    if (!message.isEmpty()) { envoyerMessage(message); // Send the message to the MessageController
    messageTextField.clear(); // Clear the messageTextField
    }
}

void envoyerMessage(String message) {
    ObservableList<String> items = messageListView.getItems(); // Get the items of the messageListView
    items.add(message); // Add the message to the items list
    messageListView.setItems(items); // Set the items back to the messageListView
}


public void setMessageController(MessageController messageController) {
    this.messageController = messageController;
}

    void receiveMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
  
}
