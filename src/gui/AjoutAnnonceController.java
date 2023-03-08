/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Annonce;
import entities.categorie;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.AnnonceService;
import services.CategorieService;


/**
 * FXML Controller class
 *
 * @author acer
 */
public class AjoutAnnonceController implements Initializable {

    @FXML
    private Label lab1;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private Label lab2;
    @FXML
    private Label lab3;
    @FXML
    private Label lab4;
    @FXML
    private Label lab5;
    @FXML
    private Label lab6;
    @FXML
    private Label lab7;
    @FXML
    private Label lab8;
    @FXML
    private ComboBox txt7;
    @FXML
    private DatePicker txt5;
    @FXML
    private DatePicker txt6;

    
    
    AnnonceService ps = new AnnonceService();
    
   ObservableList<categorie> liste=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* ObservableList<categorie> categories = (ObservableList<categorie>) categorie.getcategorie("categories");
    saveRamMenu.getItems().clear();
    openRamMenu.getItems().clear();

    for (categorie ram : categories) {
        final RAM finalRam = ram;
        MenuItem saveMenuItem = new MenuItem("from " + ram.getName() + "...");
        saveMenuItem.setOnAction(e -> saveRam(finalRam));
        saveRamMenu.getItems().add(saveMenuItem);

        MenuItem openMenuItem = new MenuItem("into " + ram.getName() + "...");
        openMenuItem.setOnAction(e -> openRam(finalRam));
        openRamMenu.getItems().add(openMenuItem);*/
       CategorieService cat=new CategorieService();
        
        try {
            liste=(ObservableList<categorie>) cat.recuperer();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    ObservableList<String> objetList = FXCollections.observableArrayList();

       for (categorie c : liste){
        objetList.add(c.getNom_categorie());
       }
        txt7.setItems(objetList);

    }   
    
    
    public void reset(){

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setValue(null);
        txt6.setValue(null);
        txt7.setValue(null);
       
}
    
      @FXML
    private void ajouterAnnonce(ActionEvent event) throws SQLException {
        
        Annonce a = new Annonce();
        a.setTitre(txt1.getText());
        a.setDescription(txt2.getText());
        a.setNom_societe(txt3.getText());
        a.setType_contrat(txt4.getText());
        Date time =Date.from(txt5.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        a.setDateFin( Date.from(txt6.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        a.setDateDebut( time);
        int i = 0;
    while( (i < liste.size())&&(liste.get(i).getNom_categorie().equals(txt7.getValue()))) {
       
        i++;
    }
       a.setCategorie(liste.get(i));
       //a.setCategorie(new categorie((String) txt7.valueProperty().getValue()));
        try {
            ps.ajouter(a);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
        }
      @FXML
    void afficherannonce(ActionEvent event) {
        
//                try {
//            Node node = getNomSociete; // the node to navigate from
//FXMLLoader newInterface = new FXMLLoader(getClass().getResource("InformationAnnonce.fxml"));
//Parent content = newInterface.load();
//Scene newScene = new Scene(content);
//Scene currentScene = node.getScene();
//Stage currentStage = (Stage) currentScene.getWindow();
//currentStage.setScene(newScene);
//currentStage.show();
//            InformationAnnonceController controller = newInterface.getController();
//            controller.AfficherAnnoce(annonce);
//        } catch (IOException ex) {
//            Logger.getLogger(AnnonceSeuleController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    }  


 



    


