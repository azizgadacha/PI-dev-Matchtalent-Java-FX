/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import entities.reponse_reclamation;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import services.Reponse_ReclamationService;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ListReponseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private VBox MyVbox;
    
    @FXML
    private TextField text_recherche;

     private List<reponse_reclamation> reponses;
     
    /*@FXML
    private Label welcomeLb;
       Reponse_ReclamationService ps = new Reponse_ReclamationService();*/

    //ArrayList<Node> nodes;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ArrayList<Node> nodes = new ArrayList<>();
            Reponse_ReclamationService ps = new Reponse_ReclamationService();
            //ObservableList<reponse_reclamation> reponse = ps.recuperer();
            ObservableList<reponse_reclamation> reponseList = (ObservableList<reponse_reclamation>) ps.recuperer();
       
       // p.BazTawTeslek();
        /* System.out.println("amaaaaaaaan");
        recuperer();
         } catch (SQLException ex) {
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
          
           // loeadDate();

    //}
    
    /*private void recuperer() throws SQLException, IOException {
           Reponse_ReclamationService ps = new Reponse_ReclamationService();
           ObservableList<reponse_reclamation> reponse = ps.recuperer(); 
        /*title.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desct.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        table_rec.setItems(reclamation);*/

        //nodes=new ArrayList<>();
        //if(reponse.size()>=1){*/
            for (int i = 0; i < reponseList.size(); i++) {
               
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Item.fxml"));
                    nodes.add(loader.load());
                    ItemController f =loader.getController();
                    f.setLabel(reponseList.get(i));
                    //ItemController itemController =loader.getController();
                    //System.out.println("bech tekhdem" + reponse.get(i).getReponse());
                    //System.out.println("nchalla nekhdem" + reponse.get(i).getClass());
                    //reponse_reclamation f = reponse.get(i);
                    //System.out.println("emchi " + f.getReponse());
                    //itemController f = getController();
                MyVbox.getChildren().add(nodes.get(i));
            } } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException ex) {
            Logger.getLogger(ListReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
    
    @FXML
void handleSearchButton(ActionEvent event) {
    String searchText = text_recherche.getText().trim();
    if(searchText.isEmpty()){
        // Clear the VBox
        MyVbox.getChildren().clear();
        // Reload all responses from the database
        //loadDate();
    }
    else {
        // Clear the VBox
        MyVbox.getChildren().clear();
        // Filter the responses based on the search text
        ArrayList<Node> nodes = new ArrayList<>();
        for (reponse_reclamation reponse : reponses) {
            if (reponse.getReponse().toLowerCase().contains(searchText.toLowerCase())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
                try {
                    nodes.add(loader.load());
                    ItemController f = loader.getController();
                    f.setLabel(reponse);
                    MyVbox.getChildren().add(nodes.get(nodes.size() - 1));
                } catch (IOException ex) {
                    Logger.getLogger(ListReponseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

    
}


            //pnItems.getChildren().removeAll();


        //}
        
    
  //}
    //}    
    
