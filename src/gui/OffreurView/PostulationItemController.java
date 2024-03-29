/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.OffreurView;


import entities.Annonce;
import entities.Postulation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class PostulationItemController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Text nomuser;
    
    @FXML
    private Text etat;
    @FXML
    private Text type;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView imv;
    
    
    
    
    PostulationService ps = new PostulationService();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
   
    }  
    
    public PostulationItemController(){
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/PostulationItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
    }

    public HBox getBox() {
        return Hbox;
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }
    
    
    
    
        public void setInfo(Postulation p)  {   

        Annonce a = ps.get_AnnonceById(p.getIdAnnonce());
        type.setText(a.getNom_societe());
        nomuser.setText("Sarra");
        etat.setText(p.getEtat());
        
//        Annonce c = ps.get_AnnonceById(2);
//        nomuser.setText("Aziz");
//        etat.setText(p.getEtat());
//        
//            Annonce b = ps.get_AnnonceById(2);
//        nomuser.setText("Istabrak");
//        etat.setText(p.getEtat());
        
     
     
}
        
}
