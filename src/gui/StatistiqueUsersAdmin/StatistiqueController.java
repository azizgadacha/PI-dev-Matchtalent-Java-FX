/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.StatistiqueUsersAdmin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author nawelhammami
 */
public class StatistiqueController implements Initializable {

    @FXML
    private StackPane stackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
        UtilisateurService us = new UtilisateurService();
       
    
         NumberAxis xAxis = new NumberAxis();
     CategoryAxis yAxis = new CategoryAxis();
 
     Statement statement = null;
     int i=1;
     int j=2;
  XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>();
  Pane pane=new Pane();
  pane.setPrefSize(600, 500);
  BarChart<String,Number> bchart=new BarChart<String,Number>(yAxis, xAxis);
  bchart.setPrefSize(550, 450);
  bchart.setTitle("Nombre de utilisateurs");
     xAxis.setLabel("Values");
     xAxis.setTickLabelRotation(60);
     yAxis.setTickLabelRotation(60);
     yAxis.setLabel("Menus");
     XYChart.Series series1 = new XYChart.Series();
     

      
        try {
            series1.getData().add(new XYChart.Data("Offreur",(us.getTotalOffreur())));
                                                series1.getData().add(new XYChart.Data("Demandeur",(us.getTotalDemandeur())));


            
            //DecimalFormat df = new DecimalFormat("0.00");
            //Moyenne_Age_Input.setText(String.valueOf(df.format(econtroleemploye.getMoyenneAge()/totale)));S
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
       
     bchart.getData().add(series1);
     pane.getChildren().add(bchart);    
    
    
	stackPane.getChildren().add(bchart);

        //
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
                Stage prStage =new Stage(); 
                loader.setLocation(getClass().getResource("/gui/Admin/ListUsers.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                prStage.setScene(scene);
                prStage.setResizable(false);
                prStage.show();
        
    }
    
}
