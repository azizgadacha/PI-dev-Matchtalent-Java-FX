package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class QuizresultatController implements Initializable {

    private int nbReponsesCorrectes;
    private int nbReponsesIncorrectes;
    @FXML
    private AnchorPane RESULT;
    @FXML
    private Label score;
    @FXML
    private Label nbbonnereponse;
    @FXML
    private Label nbmauvaisereponses;

    private PassagequizController passagequizController;
    @FXML
    private Label commentaire;
    @FXML
    private PieChart pie;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        passagequizController = PassagequizController.getInstance();
        nbReponsesCorrectes = passagequizController.getNbReponsesCorrectes();
        System.out.println(nbReponsesCorrectes);

        nbReponsesIncorrectes = passagequizController.getNbReponsesIncorrectes();
        System.out.println(nbReponsesIncorrectes);

        int nbQuestions = nbReponsesCorrectes + nbReponsesIncorrectes;

        double pourcentageScore = ((double) nbReponsesCorrectes / nbQuestions) * 100;

        score.setText(String.format("%.2f", pourcentageScore) + "%");
        nbbonnereponse.setText("Nombre de bonnes réponses : " + nbReponsesCorrectes);
        nbmauvaisereponses.setText("Nombre de mauvaises réponses : " + nbReponsesIncorrectes);

        if (nbReponsesCorrectes == 0) {
            commentaire.setText("Vous n'avez répondu correctement à aucune question. Malheureusement votre candidature est refusée. Bon courage pour la suite.");
        } else if (pourcentageScore == 100) {
            commentaire.setText("Félicitations ! Vous avez obtenu un score parfait, on vous contactera prochainement pour un entretien d'embauche !");
        } else if (pourcentageScore > 75) {
            commentaire.setText("Bravo ! Vous avez obtenu un bon score. Vous avez de grandes chances d'être embauché.");
        } else if (pourcentageScore > 25) {
            commentaire.setText("Vous avez obtenu un score moyen. L'acceptation de votre candidature dépendra des scores des autres candidats.");
        } else {
            commentaire.setText("Votre score est inférieur à 25%. Malheureusement votre candidature est refusée. Bon courage pour la suite.");
        }

        // Ajout du PieChart
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Bonnes réponses", nbReponsesCorrectes),
                        new PieChart.Data("Mauvaises réponses", nbReponsesIncorrectes)
                );
        pie.setData(pieChartData);
    }
}
