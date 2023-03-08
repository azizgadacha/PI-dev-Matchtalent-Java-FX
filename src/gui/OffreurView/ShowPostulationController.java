/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.OffreurView;

import gui.ViewPost.ShowMesPostulationController;
import entities.File;
import entities.Postulation;
import gui.ListViewPostulation;
import static gui.ViewPost.ShowMesPostulationController.p;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import services.FileService;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class ShowPostulationController implements Initializable {

    @FXML
    private ListView<Postulation> listView;

    ObservableList<Postulation> data;

    PostulationService cs = new PostulationService();

    FileService fs = new FileService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                try {
            data = (ObservableList<Postulation>) cs.getAllPostulation();   
            listView.setItems(data);
            listView.setCellFactory((ListView<Postulation> param) -> new ListViewPostulation());
            
            
            // TODO
        } catch (SQLDataException ex) {
            Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleClose(ActionEvent event) {
    }

    @FXML
    private void Accepter(ActionEvent event) throws SQLException, Exception {
        
                    ObservableList<Postulation> e = listView.getSelectionModel().getSelectedItems();
             for (Postulation m : e) {
              cs.Accepter(m);
         }
                  entities.mail.envoi("istabrak.zouabi@esprit.tn", "Traitement de demande", "Votre demande est Accepter");

             Parent root;
             try {
               root = FXMLLoader.load(getClass().getResource("/gui/ShowPostulation.fxml"));
               Stage myWindow = (Stage) listView.getScene().getWindow();
               Scene sc = new Scene(root);
               myWindow.setScene(sc);
               myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
               myWindow.show();
               } catch (IOException ex) {
               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void Refuser(ActionEvent event) throws SQLException, Exception {
        
        
                ObservableList<Postulation> e = listView.getSelectionModel().getSelectedItems();
             for (Postulation m : e) {
              cs.Refuser(m);
          entities.mail.envoi("istabrak.zouabi@esprit.tn", "Traitement de demande", "Votre demande est refuser");

         }
             
        
             Parent root;
             try {
               root = FXMLLoader.load(getClass().getResource("/gui/ShowPostulation.fxml"));
               Stage myWindow = (Stage) listView.getScene().getWindow();
               Scene sc = new Scene(root);
               myWindow.setScene(sc);
               myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
               myWindow.show();
               } catch (IOException ex) {
               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @FXML
    private void Exporter(ActionEvent event) throws IOException {
        System.out.println("gui.ShowPostulationController.Exporter()");
                   ObservableList<Postulation> e = listView.getSelectionModel().getSelectedItems();
             for (Postulation m : e) {
              downloadFile(m.getIdFile());
         }
        
        
    }
    
    
    
    
        public void downloadFile(int id) throws IOException {
            
            File f = fs.get_FileById(id);
            
        String destination = "C:/Users/Istabrak/Desktop/projet_pidev/" + f.getNameCV(); // localisation de mes documents
        try (FileOutputStream outputStream = new FileOutputStream(destination)) {
            outputStream.write(f.getCv());
        }
    }
    
}
