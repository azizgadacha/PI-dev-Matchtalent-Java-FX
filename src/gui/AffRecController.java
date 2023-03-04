/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
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
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class AffRecController implements Initializable {

    @FXML
    private ScrollPane scrollPane_rc;
    @FXML
    private GridPane gPrc;
    
    ReclamationService ps = new ReclamationService();
    
    String query = null;
    Connection cnx = null ;
    ResultSet rs = null ;
    reclamation reclamation = null ;
    
    ObservableList<reclamation>  reclamations = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            List<reclamation> reclamations = ps.recuperer();
            int column = 1;
            int row = 0;
            for (int i = 0; i < reclamations.size(); i++) {
            reclamation r = reclamations.get(i);

        // load the content from the other FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OneItem.fxml"));
        Parent content = null;
        content = loader.load();
          OneItemController controller = loader.getController();
                controller.SetItem(reclamations.get(i), gPrc);
        
        // add the content to the grid at the specified position
        gPrc.add(content, column, row);
        column++;
        } row++;    
    } catch (SQLException | IOException ex) {
            Logger.getLogger(AffRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

