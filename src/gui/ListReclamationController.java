/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import services.ReclamationService;
import utils.Enum.Statut;
import utils.Enum.TypeReclamation;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ListReclamationController implements Initializable {

    @FXML
    private TableView<reclamation> table_rec;

    @FXML
    private TableColumn<reclamation, String> desct ;
//= new TableColumn<>("description")
    @FXML
    private TableColumn<reclamation, Date> date ;
    //= new TableColumn<>("date")
    
    @FXML
    private TableColumn<reclamation, TypeReclamation> typec;

    @FXML
    private TableColumn<reclamation, String> title ;
    
      @FXML
    private TableColumn<reclamation,Statut> statut;
    //= new TableColumn<>("titre")

   // @FXML
    //private TableColumn<reclamation, Boolean> ac = new TableColumn<>("action");

    ReclamationService ps = new ReclamationService();

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*try {
            // TODO
            List<reclamation> reclamations = ps.recuperer();
            ObservableList<reclamation> olp = FXCollections.observableArrayList(reclamations);
            table_rec.setItems(olp);
            desct.setCellValueFactory(new PropertyValueFactory("description"));
            title.setCellValueFactory(new PropertyValueFactory("titre"));
            date.setCellValueFactory(new PropertyValueFactory("date"));
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }*/
        ReclamationService p = new ReclamationService();
        try {
            ObservableList<reclamation> reclamation = p.afficherReclamationList();
        } catch (SQLException ex) {
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // p.BazTawTeslek();
         System.out.println("amaaaaaaaan");
        try {
            afficherReclamationList();
            
            // loeadDate();
        } catch (SQLException ex) {
            Logger.getLogger(ListReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void afficherReclamationList() throws SQLException {
           ReclamationService p = new ReclamationService();
           ObservableList<reclamation> reclamation = p.afficherReclamationList();     
        title.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desct.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        typec.setCellValueFactory(new PropertyValueFactory<>("type"));
        table_rec.setItems(reclamation);
    }
}


