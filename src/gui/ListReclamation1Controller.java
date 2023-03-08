/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ListReclamation1Controller implements Initializable {

    @FXML
    private VBox RecVbox;
    
     @FXML
    private Button btn_stat;
     
      @FXML
    private Button btn_email;

    private List<reclamation> reclamations;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ArrayList<Node> nodes = new ArrayList<>();
            ReclamationService ps = new ReclamationService();
            //ObservableList<reponse_reclamation> reponse = ps.recuperer();
            ObservableList<reclamation> reclamationList = (ObservableList<reclamation>) ps.recuperer();
            
            for (int i = 0; i < reclamationList.size(); i++) {
               
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Item1.fxml"));
                    nodes.add(loader.load());
                    Item1Controller f =loader.getController();
                    f.setLabels(reclamationList.get(i));
                    //ItemController itemController =loader.getController();
                    //System.out.println("bech tekhdem" + reponse.get(i).getReponse());
                    //System.out.println("nchalla nekhdem" + reponse.get(i).getClass());
                    //reponse_reclamation f = reponse.get(i);
                    //System.out.println("emchi " + f.getReponse());
                    //itemController f = getController();
                RecVbox.getChildren().add(nodes.get(i));
            } } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException ex) {
            Logger.getLogger(ListReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
    
      @FXML
    void handlesomestatistics(ActionEvent event) throws IOException {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("Stats.fxml"));
            Parent root = loader.load();
           // ListReclamationController controller = loader.getController();
            //controller.setData(ch_title.getText() + " " + ch_desc.getText()
            //+ " " + ch_date.getValue().atStartOfDay() + " " + combo.getSelectionModel().getSelectedItem().toString());
            Scene currentScene = btn_stat.getScene();
            currentScene.setRoot(root);
    }
    
     @FXML
    void handleEmail(ActionEvent event) throws IOException {
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Email.fxml"));
            Parent root = loader.load();
            Scene currentScene = btn_email.getScene();
            currentScene.setRoot(root);
    }
    }    
