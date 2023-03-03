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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
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
    private VBox pnItems;

    @FXML
    private Label welcomeLb;
       Reponse_ReclamationService ps = new Reponse_ReclamationService();

    ArrayList<Node> nodes;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Reponse_ReclamationService ps = new Reponse_ReclamationService();
        try {
            ObservableList<reponse_reclamation> reponse = ps.recuperer();
       
       // p.BazTawTeslek();
         System.out.println("amaaaaaaaan");
        recuperer();
         } catch (SQLException ex) {
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListReponseController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           // loeadDate();

    }
    
    private void recuperer() throws SQLException, IOException {
           Reponse_ReclamationService ps = new Reponse_ReclamationService();
           ObservableList<reponse_reclamation> reponse = ps.recuperer(); 
        /*title.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desct.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        table_rec.setItems(reclamation);*/

        nodes=new ArrayList<>();
        if(reponse.size()>=1){
            for (int i = 0; i < reponse.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Item.fxml"));

                    ItemController itemController =loader.getController();
                    System.out.println("bech tekhdem" + reponse.get(i).getReponse());
                    System.out.println("hend faddet" + reponse.get(i).getClass());
                    reponse_reclamation f = reponse.get(i);
                    System.out.println("emchi " + f.getReponse());
                    nodes.add(loader.load());
                    itemController.SetLabel(f);

                   

                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            pnItems.getChildren().removeAll();


        }
        
    
  }
    }    
    
