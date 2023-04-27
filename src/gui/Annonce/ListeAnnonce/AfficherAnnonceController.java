/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Annonce.ListeAnnonce;

import entities.Annonce;
import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.Annonce.ElementOfViewAnnonce.AnnonceSeuleController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import services.AnnonceService;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AfficherAnnonceController implements Initializable {


    
    private GridPane grid;

    AnnonceService ps = new AnnonceService();

   
        String query = null;
    Connection cnx = null ;
    ResultSet rs = null ;
    Annonce anonce = null ;
    
    ObservableList<Annonce>  annonces = FXCollections.observableArrayList();
    ObservableList<categorie>  categories = FXCollections.observableArrayList();
    @FXML
    private ScrollPane annonceListSpane;
    @FXML
    private GridPane annonceListGP;

    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        annonceListGP.setHgap(5);
        annonceListGP.setVgap(5);

        try {
            List<Annonce> annonces = ps.recuperer();
            int column = 1;
            int row = 1;
            for (int i = 0; i < annonces.size(); i++) {
            Annonce a = annonces.get(i);

        // load the content from the other FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Annonce/ElementOfViewAnnonce/annonceSeule.fxml"));
        Parent content = null;
        content = loader.load();
          AnnonceSeuleController controller = loader.getController();
                controller.infoAnnonce(annonces.get(i));
        
        // add the content to the grid at the specified position
                System.out.println("eeeeee "+row);

        annonceListGP.add(content, column, row);
                if(column==4){
                  row++;
                column=1;

                }else
                    column++;

        }
            
//        loadDate();
//               try {
//            List<Annonce> annonces = ps.recuperer();
//            int row = 0;
//            int column = 0;
//            for (int i = 0; i < annonces.size(); i++) {
//                //chargement dynamique d'une interface
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("Personne.fxml"));
//                AnchorPane pane = loader.load();
//               
//                //passage de parametres
//                AfficherAnnonceController controller = loader.getController();
//              //  controller.setAnnonce(annonces.get(id_annonce));
//
//                grid.add(pane, column, row);
//                column++;
//                if (column > 1) {
//                    column = 0;
//                    row++;
//                }
//            }
//        } catch (SQLException | IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    private void loadDate() {
//
//
//
//        
//        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
//        coldes.setCellValueFactory(new PropertyValueFactory<>("description"));
//        coldatedebut.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
//        coldatefin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
//        coltype.setCellValueFactory(new PropertyValueFactory<>("typecontrat"));
//        colcat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        colnomsoc.setCellValueFactory(new PropertyValueFactory<>("nomsociete"));
/*    deleteButton.setOnMouseClicked((MouseEvent event) -> {

try {
Annonce = tab1.getSelectionModel().getSelectedItem();
query = "DELETE FROM `annonce` WHERE id  ="+Annonce.getId_annonce();
connection = DbConnect.getConnect();
preparedStatement = connection.prepareStatement(query);
preparedStatement.execute();
refreshTable();

} catch (SQLException ex) {
Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);

        }*/ } catch (SQLException | IOException ex) {
            Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }


    
    
    }    }
    

