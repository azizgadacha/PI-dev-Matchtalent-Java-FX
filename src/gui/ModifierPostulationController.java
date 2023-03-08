/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.ViewPost.ShowMesPostulationController;
import entities.Postulation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.FileService;
import services.PostulationService;

/**
 * FXML Controller class
 *
 * @author Istabrak
 */
public class ModifierPostulationController implements Initializable {

    @FXML
    private Label mySelectLabel;
    @FXML
    private Label ajoutD;
    @FXML
    private VBox i_box;
    @FXML
    private Label ajoutD1;
    @FXML
    private Label ajoutD11;
    @FXML
    private Label nameCv;
    @FXML
    private Label nameDeplome;
    @FXML
    private Button AfficherL;
    @FXML
    private Label nameMotivation;
    
    
   File pfilecV;
    
    byte[] fileCV ;
    
    File pfileDeplome;
    
    byte[] fileDeplome ;
    
    File pfilemotivation;
    
    byte[] filemotion ;


    FileService fs = new FileService();
    PostulationService ps = new PostulationService();
    
    Postulation postulation =ShowMesPostulationController.p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void UploadCv(ActionEvent event) throws MalformedURLException, IOException {
        
                    
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfilecV = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfilecV != null) {
           nameCv.setText(pfilecV.getName());
           fileCV = readBytes(pfilecV);       
    }
    }

    @FXML
    private void UploadCvDeplome(ActionEvent event) throws IOException {
        
                 FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfileDeplome = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfileDeplome != null) {
           nameDeplome.setText(pfileDeplome.getName());
           fileDeplome = readBytes(pfileDeplome);       
    }
        
    }

    @FXML
    private void UploadMotivation(ActionEvent event) throws IOException {
        
                 FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfilemotivation = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfilemotivation != null) {
           nameMotivation.setText(pfilemotivation.getName());
           filemotion = readBytes(pfilemotivation);       
    }
    }

    @FXML
    private void Confermer(ActionEvent event) throws SQLException {
        
        
        entities.File f = new entities.File();
          f.setCv(fileCV);
          f.setDeplome(fileDeplome);
          f.setLettremotivation(filemotion);
          f.setNameCV(nameCv.getText());
          f.setNamedeplome(nameDeplome.getText());
          f.setNamelettreMotivation(nameMotivation.getText());

          f.setIdUtilisateur(1);
          f.setIdFile(postulation.getIdFile());
          System.out.println("gui.PostulationController.Confermer()"+f);
          fs.modifier(f);
        
        Postulation p = new Postulation();
        p.setIdUtilisateur(p.getIdUtilisateur());
        p.setIdAnnonce(p.getIdAnnonce());
        System.err.println("hhh"+ps.MaxIdFile());
        p.setIdFile(ps.MaxIdFile());
        LocalDate dd = LocalDate.now();
        Date date = java.sql.Date.valueOf(dd);
        p.setDate((java.sql.Date) date);
        ps.modifier(p);
        
        
        Parent root;
             try {
               root = FXMLLoader.load(getClass().getResource("/gui/ShowMesPostulation.fxml"));
               Stage myWindow = (Stage) nameCv.getScene().getWindow();
               Scene sc = new Scene(root);
               myWindow.setScene(sc);
               myWindow.setTitle("page name");
                            //myWindow.setFullScreen(true);
               myWindow.show();
               } catch (IOException ex) {
               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
               }
        
    }
    @FXML
    private void AfficherListe(ActionEvent event) {
    }
    
    
          private byte[] readBytes(File file) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try (InputStream is = new FileInputStream(file)) {
            int len;
            while ((len = is.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
        }
        return bos.toByteArray();
    }
}
