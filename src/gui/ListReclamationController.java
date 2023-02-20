/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReclamationService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class ListReclamationController implements Initializable {

     
    /**
     * Initializes the controller class.
     */
    ReclamationService ps = new ReclamationService();
     private TableColumn<reclamation, Button> delete;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /*try {
            // TODO
            List<reclamation> reclamations = ps.recuperer();
            ObservableList<reclamation> olp = FXCollections.observableArrayList(reclamations);
            reclamation_view.setItems(olp);
            col1.setCellValueFactory(new PropertyValueFactory("nom"));
            col2.setCellValueFactory(new PropertyValueFactory("prenom"));
            col3.setCellValueFactory(new PropertyValueFactory("age"));
            this.delete();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }*/

    }
    
     /*public void delete() {
        delete.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("delete");
                        b.setOnAction((event) -> {
                            try {
                                if (ps.supprimer(reclamation_view.getItems().get(getIndex()))) {
                                    reclamation_view.getItems().remove(getIndex());
                                    reclamation_view.refresh();

                                }
                            } catch (SQLException ex) {
                                System.out.println("erreor:" + ex.getMessage());

                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });

    }

    public void setData(String Message) {
        welcomeLb.setText("Welcomme " + Message);

    }*/

}
    