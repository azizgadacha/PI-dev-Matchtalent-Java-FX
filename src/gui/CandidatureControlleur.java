/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Postulation;
import gui.ViewPost.ListViewMesPostulation;
import gui.ViewPost.ShowMesPostulationController;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class CandidatureControlleur implements Initializable {
    
     @FXML
    private ListView<Postulation> listView;
   
    ObservableList<Postulation> data;
    
    public static int idE ;
    
    public static Postulation p ;
   PostulationService cs = new PostulationService();

    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField searchBox;
    @FXML
    private ComboBox<?> comboBox;
    @FXML
    private Label etat;
    @FXML
    private Label date;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox vbox_id;
    @FXML
    private Label nombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
            data = (ObservableList<Postulation>) cs.getAllPostulationUser(1);   
            listView.setItems(data);
            listView.setCellFactory((ListView<Postulation> param) -> new ListViewMesPostulation());
            
            
            // TODO
        } catch (SQLDataException ex) {
            Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
        }    }    

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void triUsername(MouseEvent event) {
    }

    @FXML
    private void triNote(MouseEvent event) {
    }
    
}
