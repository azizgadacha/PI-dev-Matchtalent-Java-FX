/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Candidature;

//import entities.Postulation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class CandidatureControlleur implements Initializable {


    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField searchBox;
    @FXML
    private ComboBox<?> comboBox;
    @FXML
    private VBox pnItems;
    @FXML
    private Label nombre;
    @FXML
    private ImageView imageView;
    @FXML
    private Label etat;
    @FXML
    private Label date;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        List<Postulation> postulations = st.recuperer();
//            int column = 1;
//            int row = 0;
//            for (int i = 0; i < postulations.size(); i++) {
//            Postulation a = postulations.get(i);

    }    
    

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void triUsername(MouseEvent event) {
    }

    @FXML
    private void triNote(MouseEvent event) {
    }

    @FXML
    private void onImageViewClicked(MouseEvent event) {
    }

}
