/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import entities.reponse_reclamation;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class OneItemController implements Initializable {

    @FXML
    private Label label_desc;
    @FXML
    private Label label_titre;
    @FXML
    private Button SuppBut;
    
    @FXML
    private Button RepBut;


    private GridPane gPrc; // add reference to GridPane
    private reclamation reclamation;
    private ReclamationService service = new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void SetItem(reclamation r, GridPane parent) {
        reclamation = r;
        gPrc = parent; // set the parentPane
        this.gPrc = gPrc;
        label_titre.setText(String.valueOf(r.getTitre()));
        label_desc.setText(String.valueOf(r.getDescription()));
    }
    
    @FXML
    void Supprimer(ActionEvent event) throws SQLException {
       ReclamationService ps = service;

        //ReclamationService ps = new ReclamationService();
         ps.supprimer(reclamation);
         System.out.println("Delete button clicked!");
    //gPrc.getChildren().remove(SuppBut.getParent()); // remove the parent node of the button from the parentPane
     Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    void redicert(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReponse.fxml"));
            Parent root = loader.load();
           // ListReclamationController controller = loader.getController();
            //controller.setData(ch_title.getText() + " " + ch_desc.getText()
            //+ " " + ch_date.getValue().atStartOfDay() + " " + combo.getSelectionModel().getSelectedItem().toString());
            Scene currentScene = RepBut.getScene();
            currentScene.setRoot(root);
    }

}
