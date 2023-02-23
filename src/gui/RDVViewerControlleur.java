package gui;

import entities.candidature;
import entities.rendez_vous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RDVViewerControlleur implements Initializable {
    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private TextField searchBox;
    @FXML
    private VBox pnItems;
    @FXML
    private Label nombre;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private GridPane grid;
    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;
    Rendez_vous_service rs=new Rendez_vous_service();

    @FXML
    private ImageView img;
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    ObservableList<rendez_vous> rendez_vousListe;
    public void remplirliste(ObservableList<rendez_vous> rendez_vousListe){
        nombre.setText(String.valueOf(rendez_vousListe.size()));
        nodes=new ArrayList<>();
        if(rendez_vousListe.size()>=1){
            for (int i = 0; i < rendez_vousListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("../gui/itemRendezvou.fxml"));

                    nodes.add(  loader.load());
                    RDVelement f=loader.getController();
                    f.setValues(rendez_vousListe.get(i));
                    //give the items some effect


                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("im here b");
            System.out.println(pnItems.getChildren());
            pnItems.getChildren().removeAll();

            System.out.println(pnItems.getChildren());

        }
    }


    @FXML
    void triNomAnnonce(MouseEvent event) {
        FXCollections.sort(rendez_vousListe, new CompareAnoonceName());
        pnItems.getChildren().removeAll();
        pnItems.getChildren().clear();
        remplirliste(rendez_vousListe);
    }


    @FXML
    void rechercher(KeyEvent event) {

        FilteredList<rendez_vous> filterData = new FilteredList<>(rendez_vousListe, p -> true);
        searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(rendez_vous -> {
                System.out.println("im here1 "+newvalue);
                if (newvalue == null || newvalue.isEmpty()) {
                    System.out.println("im here2 "+newvalue);

                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (String.valueOf(rendez_vous.getAnnonce().getTitre()).toLowerCase().indexOf(typedText) != -1) {
                    System.out.println("im here3 "+newvalue);

                    return true;
                }
                return false;
            });
            pnItems.getChildren().removeAll();

            SortedList<rendez_vous > sortedList = new SortedList<>(filterData);
            // sortedList.comparatorProperty().bind(pnItems.);
            pnItems.getChildren().clear();

            remplirliste(sortedList);

            // table.setItems(sortedList);


        });

    }
    ArrayList<Node> nodes;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            rendez_vousListe= (ObservableList<rendez_vous>) rs.recuperer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        remplirliste(rendez_vousListe);

    }



    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #e7e5e5");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }
}
