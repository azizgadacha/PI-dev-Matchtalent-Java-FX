/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AfficherCategorieController implements Initializable {

    @FXML
    private VBox vboxcat;

    /**                

     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
         ArrayList<Node> nodes = new ArrayList<>();
        CategorieService cat =new CategorieService();
        
        ObservableList<categorie> categorieListe= (ObservableList<categorie>) cat.recuperer();
   
        for (int i = 0; i < categorieListe.size(); i++) {
           
                
            
            
                FXMLLoader loder = new FXMLLoader(getClass().getResource("Itemcat.fxml"));
                
                nodes.add(loder.load() );
               ItemcatController f=loder.getController();
//                nodes.add(FXMLLoader.load(getClass().getResource("Itemcat.fxml")));
   f.SetValue(categorieListe.get(i));
                
                vboxcat.getChildren().add(nodes.get(i));
            } }catch (Exception e) {
                e.printStackTrace();
            }
        
    }    
    
}
