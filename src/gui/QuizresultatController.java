package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //PassagequizController passagequizController = new PassagequizController();
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
    commentaire.setText("Vous n'avez répondu correctement à aucune question. Malheuresemnt votre candidature est refusé. Bon courage pour la suite ");
} else if (pourcentageScore == 100) {
    commentaire.setText("Félicitations ! Vous avez obtenu un score parfait, on vous contactera prochainement pour un entretien d'embauche !");
} else if (pourcentageScore > 75) {
    commentaire.setText("Bravo ! Vous avez obtenu un bon score. vous avez de grandes chances d'etre embauché");
} else if (pourcentageScore > 25) {
    commentaire.setText("Vous avez obtenu un score moyen. l'acceptation de votre candidature depéndra des scores des autres candidats");
} else {
    commentaire.setText("Votre score est inférieur à 25%. Malheuresemnt votre candidature est refusé. bon courage pour la suite");
}

        
        
        
        

    } 
}
