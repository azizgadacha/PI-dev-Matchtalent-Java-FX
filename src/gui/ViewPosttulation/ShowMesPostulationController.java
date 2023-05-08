/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ViewPosttulation;


import entities.Postulation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import services.PostulationService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class ShowMesPostulationController implements Initializable {

    @FXML
    private ListView<Postulation> listView;
   
    ObservableList<Postulation> data;
    
    public static int idE ;
    
    public static Postulation p ;
   PostulationService cs = new PostulationService();

   

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
        }
    }    




    @FXML
    private void handleClose(ActionEvent event) {
    }

//    @FXML
//    private void modifier(ActionEvent event) {
//              
//        
//        
//        ObservableList<Postulation> e = listView.getSelectionModel().getSelectedItems();
//             for (Postulation m : e) {
//              p = m ;
//         }
//        
//        
//             Parent root;
//             try {
//               root = FXMLLoader.load(getClass().getResource("/gui/ModifierPostulation.fxml"));
//               Stage myWindow = (Stage) listView.getScene().getWindow();
//               Scene sc = new Scene(root);
//               myWindow.setScene(sc);
//               myWindow.setTitle("page name");
//                            //myWindow.setFullScreen(true);
//               myWindow.show();
//               } catch (IOException ex) {
//               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//        
//    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
        
             ObservableList<Postulation> e = listView.getSelectionModel().getSelectedItems();
             for (Postulation m : e) {
             cs.supprimer(m.getId());
         }
             
        Parent root;
             try {
               root = FXMLLoader.load(getClass().getResource("../ViewPost/ShowMesPostulation.fxml"));
               Stage myWindow = (Stage) listView.getScene().getWindow();
               Scene sc = new Scene(root);
               myWindow.setScene(sc);
               myWindow.setTitle("ShowMesPostulation.fxml");
                            //myWindow.setFullScreen(true);
               myWindow.show();
               } catch (IOException ex) {
               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
               }
         
    }
//
//    @FXML
//    private void Ajouter(ActionEvent event) {
//        
//              Parent root;
//             try {
//               root = FXMLLoader.load(getClass().getResource("/gui/Postulation.fxml"));
//               Stage myWindow = (Stage) listView.getScene().getWindow();
//               Scene sc = new Scene(root);
//               myWindow.setScene(sc);
//               myWindow.setTitle("page name");
//                            //myWindow.setFullScreen(true);
//               myWindow.show();
//               } catch (IOException ex) {
//               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
//               }
//        
//        
//    }




    }

    

