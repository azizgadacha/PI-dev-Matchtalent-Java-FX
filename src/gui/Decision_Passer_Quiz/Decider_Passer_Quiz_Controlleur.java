package gui.Decision_Passer_Quiz;
//import com.pdfjet.*;

import entities.Annonce;
import entities.Postulation;
import gui.Decision_Passer_Quiz.table_Element_Decision.Item_Decision;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import services.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Decider_Passer_Quiz_Controlleur implements Initializable {

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
    PoService ps=new PoService();


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

    ObservableList<Postulation> PostulationsListe;
    public void remplirliste(ObservableList<Postulation> PostulationsListe) throws SQLException {
        nombre.setText(String.valueOf(PostulationsListe.size()));
        nodes=new ArrayList<>();
        System.out.println(PostulationsListe.size());
        if(PostulationsListe.size()>=1){
            for (int i = 0; i < PostulationsListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("table_Element_Decision/Item_Decision.fxml"));

                    nodes.add(  loader.load());
                    Item_Decision f=loader.getController();
                    f.setChangeListener(new Item_Decision.PopupListener() {
                        @Override
                        public void onInfoSentChange( Boolean var) throws SQLException {
                            if (var) {
                                pnItems.getChildren().clear();

                                getFromDb();

                            }
                        }

                    });
                    f.setValues(PostulationsListe.get(i));
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
    void triNote(MouseEvent event) throws SQLException {
        FXCollections.sort(PostulationsListe, new Compare_Nom_Postultion());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(PostulationsListe);
    }
    @FXML
    void triUsername(MouseEvent event) throws SQLException {
        FXCollections.sort(PostulationsListe, new Compoare_Address_Postulation());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(PostulationsListe);
    }


    @FXML
    void rechercher(KeyEvent event) {

        FilteredList<Postulation> filterData = new FilteredList<>(PostulationsListe, p -> true);
        searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(Postulation -> {
                if (newvalue == null || newvalue.isEmpty()) {

                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (String.valueOf(Postulation.getUtilisateur().getUsername()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }if (String.valueOf(Postulation.getUtilisateur().getAddress()).indexOf(typedText) != -1) {

                    return true;
                }
                return false;
            });
            pnItems.getChildren().removeAll();

            SortedList<Postulation > sortedList = new SortedList<>(filterData);
          // sortedList.comparatorProperty().bind(pnItems.);
            pnItems.getChildren().clear();

            try {
                remplirliste(sortedList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // table.setItems(sortedList);


        });

    }
    ArrayList<Node> nodes;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getFromDb();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void getFromDb() throws SQLException {

            PostulationsListe= (ObservableList<Postulation>) ps.getSpecified(new Annonce(1));
            remplirliste(PostulationsListe);


    }


}
