/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.AjoutPost;

import entities.Postulation;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import services.FileService;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class ApplyNowController implements Initializable {

    @FXML
    private AnchorPane apply_id;
    @FXML
    private Button Pos_id;

        PostulationService ps = new PostulationService();
        FileService fs = new FileService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
         
        Postulation p = new Postulation();
        p.setIdUtilisateur(1);
        p.setIdAnnonce(1);
        System.err.println("done"+ps.MaxIdFile());
        p.setIdFile(fs. get_File_of_user(1));
        LocalDate dd = LocalDate.now();
        Date date = java.sql.Date.valueOf(dd);
        p.setDate((java.sql.Date) date);
        ps.ajouter(p);
        
    }
    
}
