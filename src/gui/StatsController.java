/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Hend
 */
public class StatsController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private BarChart<String, Integer> chart;
    
      @FXML
    private Button backk;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Retrieve data from database and populate chart
        populateChart();
    }    
    
    private void populateChart() {
        XYChart.Series<String, Integer> reclamationSeries = new XYChart.Series<>();
        XYChart.Series<String, Integer> reponse_reclamationSeries = new XYChart.Series<>();

        try {
            Connection conx = MyDB.getInstance().getCnx();
            PreparedStatement stmt1 = conx.prepareStatement("SELECT COUNT(*) FROM reclamation");
            PreparedStatement stmt2 = conx.prepareStatement("SELECT COUNT(*) FROM reponse_reclamation");
            ResultSet rs1 = stmt1.executeQuery();
            ResultSet rs2 = stmt2.executeQuery();

            if (rs1.next()) {
                reclamationSeries.getData().add(new XYChart.Data<>("Reclamation", rs1.getInt(1)));
            }

            if (rs2.next()) {
                reponse_reclamationSeries.getData().add(new XYChart.Data<>("Response_reclamation", rs2.getInt(1)));
            }

            chart.getData().addAll(reclamationSeries, reponse_reclamationSeries);

            rs1.close();
            rs2.close();
            stmt1.close();
            stmt2.close();
            //conx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void backbutton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListReclamation1.fxml"));
            Parent root = loader.load();
            Scene currentScene = backk.getScene();
            currentScene.setRoot(root);
    }
}
