/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Admin;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author nawelhammami
 */

public class ListUsersController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableView;
    @FXML
    private TableColumn<Utilisateur, String> username_col;
    @FXML
    private TableColumn<Utilisateur, String> email_col;
    UtilisateurService a;
    
    ObservableList<Utilisateur>obList ;
Button btn;
Utilisateur  A=new Utilisateur();
    private TableColumn<Utilisateur, Void> colModifBtn;
    private TableColumn<Utilisateur, Void> colSuppBtn;
    @FXML
    private TableColumn<Utilisateur, String> contact_col;
    @FXML
    private TableColumn<Utilisateur, String> adresse_col;
 /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         colSuppBtn = new TableColumn<>("Supprimer");
            tableView.getColumns().add(colSuppBtn);    
                
        a= new  UtilisateurService();
        try {
            obList= a.recuperer();
               
            username_col.setCellValueFactory(new PropertyValueFactory<>("username"));
               email_col.setCellValueFactory(new PropertyValueFactory<>("email"));

               adresse_col.setCellValueFactory(new PropertyValueFactory<>("address"));
                             contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));
 
                            
       
   
                      tableView.setItems(obList);


            
       
            addButtonDeleteToTable();
     
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }    
    public void Afficher() throws SQLException{
        tableView.refresh();
            obList.clear();

            obList   = a.recuperer();
            
          username_col.setCellValueFactory(new PropertyValueFactory<>("username"));
               email_col.setCellValueFactory(new PropertyValueFactory<>("email"));

               adresse_col.setCellValueFactory(new PropertyValueFactory<>("address"));
                             contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));
 
                            
             
   
                      tableView.setItems(obList);
    }
   
    Button btnSupprimer;
      
         public void addButtonDeleteToTable() {
              


        Callback<TableColumn<Utilisateur, Void>, TableCell<Utilisateur, Void>> cellFactory = new Callback<TableColumn<Utilisateur, Void>, TableCell<Utilisateur, Void>>() {
            @Override
            public TableCell<Utilisateur, Void> call(final TableColumn<Utilisateur, Void> param) {

                final TableCell<Utilisateur, Void> cell = new TableCell<Utilisateur, Void>() {


                    { 

                        btnSupprimer = new Button("Supprimer");
                         btnSupprimer = new Button("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              A = tableView.getSelectionModel().getSelectedItem();
                            try {
                                showConfirmation(A);
                            } catch (SQLException ex) {
                                Logger.getLogger(ListUsersController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;    
            }
        };

        colSuppBtn.setCellFactory(cellFactory);


        
        
        
   
      }
            private Label label;
private void showConfirmation(Utilisateur A) throws SQLException {
        
 
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("Utilisateur est tres efficace");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          System.out.println("hiddddd iddd="+A);

          System.out.println("hiddddd iddd="+A.getId());
          a.supprimer(A);
          obList.clear();
          Afficher();
      } else if (option.get() == ButtonType.CANCEL) {
          System.out.println("rani lena");
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   }

    @FXML
    private void GoStat(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("/gui/StatistiqueUsersAdmin/Statistique.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
        
    }
}
