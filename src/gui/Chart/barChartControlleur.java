package gui.Chart;

import entities.candidature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class barChartControlleur implements Initializable {
    @FXML
    private PieChart pieChart;
    @FXML
    private javafx.scene.chart.BarChart<?, ?> BarChart;
    ObservableList<candidature> lc;

    public void sendData(ObservableList<candidature> ls){
        this.lc=ls;
        int[]  tableNote =new int[3];
        for (int i=0;i<lc.size();i++){
            if (lc.get(i).getNote()>15)
                tableNote[0]++;
            else if(lc.get(i).getNote()>10)
                tableNote[1]++;
            else
                tableNote[2]++;
            System.out.println("note "+tableNote[0]);
            System.out.println("note "+tableNote[1]);
            System.out.println("note "+tableNote[2]);
            ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(new PieChart.Data("note entre 10 et 15",tableNote[0]),new PieChart.Data("note inferieur a10",tableNote[1]),new PieChart.Data("note 15 ou plus",tableNote[2]));
            pieChart.setData(pieChartData);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
