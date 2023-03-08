/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


import entities.reponse_reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import services.Reponse_ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class DisplayListReponseController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane gride;
    
    Reponse_ReclamationService ps = new Reponse_ReclamationService();
    
    String query = null;
    Connection cnx = null ;
    ResultSet rs = null ;
    reponse_reclamation reponse_reclamation = null ;
    
    ObservableList<reponse_reclamation>  reponse_reclamations = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
         try {
            List<reponse_reclamation> reponse_reclamations = ps.recuperer();
            int column = 5;
            int row = 10;
            for (int i = 0; i < reponse_reclamations.size(); i++) {
            reponse_reclamation r = reponse_reclamations.get(i);

        // load the content from the other FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseOneItem.fxml"));
        Parent content = null;
        content = loader.load();
          ReponseOneItemController controller = loader.getController();
                controller.SetReponseItem(reponse_reclamations.get(i), gride);
        
        // add the content to the grid at the specified position
        gride.add(content, column, row);
        column++;
        } row++;    
    } catch (SQLException | IOException ex) {
            Logger.getLogger(AffRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
