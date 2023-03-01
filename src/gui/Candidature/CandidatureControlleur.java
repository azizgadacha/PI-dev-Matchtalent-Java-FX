package gui.Candidature;

import entities.candidature;
import gui.Candidature.TableElement.elementController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CompareNom;
import services.CompareNote;
import services.CondidatureService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CandidatureControlleur implements Initializable {

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
    CondidatureService cs=new CondidatureService();


    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ImageView imageView;



    @FXML
    private void onImageViewClicked() {
        comboBox.getItems().add("ffff");
        System.out.println("ffff");
        comboBox.setVisible(!comboBox.isVisible());
    }


    @FXML
    private ImageView img;
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    ObservableList<candidature> candidaturesListe;
    public void remplirliste(ObservableList<candidature> candidaturesListe){
        nombre.setText(String.valueOf(candidaturesListe.size()));
        nodes=new ArrayList<>();
        if(candidaturesListe.size()>=1){
            for (int i = 0; i < candidaturesListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("TableElement/Item.fxml"));

                    nodes.add(  loader.load());
                    elementController f=loader.getController();
                    f.setValues(candidaturesListe.get(i));
                    //give the items some effect


                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            pnItems.getChildren().removeAll();


        }
    }


    @FXML
    void triNote(MouseEvent event) {
        FXCollections.sort(candidaturesListe, new CompareNote());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(candidaturesListe);
    }
    @FXML
    void triUsername(MouseEvent event) {
        FXCollections.sort(candidaturesListe, new CompareNom());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(candidaturesListe);
    }


    @FXML
    void rechercher(KeyEvent event) {

        FilteredList<candidature> filterData = new FilteredList<>(candidaturesListe, p -> true);
        searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(candida -> {
                if (newvalue == null || newvalue.isEmpty()) {

                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (String.valueOf(candida.getUtilisateur().getUsername()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }if (String.valueOf(candida.getNote()).indexOf(typedText) != -1) {

                    return true;
                }
                return false;
            });
            pnItems.getChildren().removeAll();

            SortedList<candidature > sortedList = new SortedList<>(filterData);
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
          candidaturesListe= (ObservableList<candidature>) cs.recuperer();
            System.out.println(candidaturesListe.get(0));
            remplirliste(candidaturesListe);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
