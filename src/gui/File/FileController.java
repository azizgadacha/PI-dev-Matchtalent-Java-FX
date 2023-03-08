/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.File;

import entities.Postulation;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.util.Arrays.equals;
import java.util.Date;
import static java.util.Objects.equals;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
public class FileController implements Initializable {

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
    
    
    java.io.File pfilecV;
    
    byte[] fileCV ;
    
    java.io.File pfileDeplome;
    
    byte[] fileDeplome ;
    
    java.io.File pfilemotivation;
    
    byte[] filemotion ;


    FileService fs = new FileService();
    PostulationService ps = new PostulationService();
    ObservableList<entities.File> data =FXCollections.observableArrayList();
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data = (ObservableList<entities.File>) fs.getAllFileByUser(1);
       if (data.size()!=0) {
           nameCv.setText(data.get(0).getNameCV());
           nameDeplome.setText(data.get(0).getNamedeplome());
           nameMotivation.setText(data.get(0).getNamelettreMotivation());
        }
        } catch (SQLDataException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
       

    }  }  

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
 
          if (nameCv.getText().equals("")|| nameDeplome.getText().equals("")|| nameMotivation.getText().equals("")){
          
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Completez vos coordonnees", ButtonType.OK); /// 
           alert.showAndWait();
          }else{
              f.setIdUtilisateur(1);
        System.out.println("ajouterAvecSucces"+f);
        
        if (data.size()==0){
            System.out.println("dothis");
              
                  fs.ajouter(f);
              }else{
        fs.modifier(f);
        }
        
        
        
//        Postulation p = new Postulation();
//        p.setIdUtilisateur(1);
//        p.setIdAnnonce(1);
//        System.err.println("hhh"+ps.MaxIdFile());
//        p.setIdFile(ps.MaxIdFile());
//        LocalDate dd = LocalDate.now();
//        Date date = java.sql.Date.valueOf(dd);
//        p.setDate((java.sql.Date) date);
//        ps.ajouter(p);
              
          
        
        
//        Parent root;
//             try {
//               root = FXMLLoader.load(getClass().getResource("/gui/ShowMesPostulation.fxml"));
//               Stage myWindow = (Stage) nameCv.getScene().getWindow();
//               Scene sc = new Scene(root);
//               myWindow.setScene(sc);
//               myWindow.setTitle("page name");
//                            //myWindow.setFullScreen(true);
//               myWindow.show();
//               } catch (IOException ex) {
//               Logger.getLogger(ShowMesPostulationController.class.getName()).log(Level.SEVERE, null, ex);
//               }
          }
    }

    @FXML
    private void AfficherListe(ActionEvent event) {
    }
    
    
    
      private byte[] readBytes(java.io.File file) throws IOException {
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
