package gui.Candidature;
//import com.pdfjet.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.awt.*;
import java.io.BufferedInputStream;
import java.io.*;

//import com.pdfjet.Cell;
import entities.annonce;
import entities.candidature;
import gui.Candidature.TableElement.elementController;
import gui.Chart.barChartControlleur;
import gui.RDV.AddRDV.addRDVControlleur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import services.CompareNom;
import services.CompareNote;
import services.CondidatureService;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public void remplirliste(ObservableList<candidature> candidaturesListe) throws SQLException {
        nombre.setText(String.valueOf(candidaturesListe.size()));
        nodes=new ArrayList<>();
        System.out.println(candidaturesListe.size());
        if(candidaturesListe.size()>=1){
            for (int i = 0; i < candidaturesListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("TableElement/Item.fxml"));

                    nodes.add(  loader.load());
                    elementController f=loader.getController();
                    f.setChangeListener(new elementController.PopupListener() {
                        @Override
                        public void onInfoSentChange( Boolean var) throws SQLException {
                            if (var) {
                                pnItems.getChildren().clear();

                                getFromDb();

                            }
                        }

                    });
                    f.setValues(candidaturesListe.get(i));
                    //give the items some effect


                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            createpdf();
            pnItems.getChildren().removeAll();


        }
    }
    @FXML
    void moveToChart(ActionEvent event) throws Exception {
        pdfGenerator();
       /* FXMLLoader loader =new FXMLLoader(getClass().getResource("../Chart/Barchart.fxml"));
        Parent root =loader.load();
        barChartControlleur send1 = loader.getController();

        send1.sendData(candidaturesListe);
        pnlOverview.set setCenter(root);*/

        FXMLLoader loader =new FXMLLoader(getClass().getResource("../Chart/Barchart.fxml"));
        Pane root =loader.load();
        barChartControlleur send1 = loader.getController();

        send1.sendData(candidaturesListe);
        pnlOverview.getChildren().setAll(root);


    }

    private void createpdf() throws SQLException {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc,new FileOutputStream("../pdf.pdf"));
            doc.open();

//       Image img = Image.getInstance("C:\\Users\\msi\\Desktop\\projet yocef\\reclamation\\src\\com\\img\\Exchange.png12.png");
//       img.scaleAbsoluteHeight(60);
//       img.scaleAbsoluteWidth(100);
//       img.setAlignment(Image.ALIGN_RIGHT);
//       doc.add(img);

            doc.add(new Paragraph(" "));
            Font font = new Font(FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
            Paragraph p = new Paragraph("Liste des reservations", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(2);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            System.out.println("heelo");

            cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("prenom", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            for (candidature Candidature : candidaturesListe) {
                tabpdf.addCell(Candidature.getUtilisateur().getUsername());
                tabpdf.addCell(Candidature.getUtilisateur().getEmail());

            }

/*
for(int i =0;i<candidaturesListe.size();i++){
    cell = new PdfPCell(new Phrase(.getString("date_res"), FontFactory.getFont("Times New Roman", 11)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell.setBackgroundColor(BaseColor.WHITE);
    tabpdf.addCell(cell);

    cell = new PdfPCell(new Phrase(rs1.getString("prix_res"), FontFactory.getFont("Times New Roman", 11)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell.setBackgroundColor(BaseColor.WHITE);
    tabpdf.addCell(cell);
}
            for (candidature rowData : candidaturesListe) {
              //  for (String cellData : rowData) {
                    Cell nameCell = new Cell().add(new Text(rowData.getUtilisateur().getUsername()).setFont(font));
                    Cell ageCell = new Cell().add(new Text(Integer.toString(student.getAge())).setFont(font));
                    Cell cityCell = new Cell().add(new Text(student.getCity()).setFont(font));

                    table.addCell(nameCell);
                    table.addCell(ageCell);
                    table.addCell(cityCell);
                    //Cell cell = new Cell().add(new Text(cellData).setFont(font));
                    //table.addCell(cell);
                //}
            }
            while(rs1.next()){
                System.out.println(rs1.getString("date_res"));
                cell = new PdfPCell(new Phrase(rs1.getString("date_res"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs1.getString("prix_res"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);


            }
*/
            doc.add(tabpdf);
            doc.close();
            Desktop.getDesktop().open(new File("../pdf.pdf"));


        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }
    }
    public void pdfGenerator () throws Exception {
       /* File out=new File("../rapport_financier1.pdf");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(out);
            PDF pdf = new PDF(fos);

            Page page = new Page(pdf, A4.PORTRAIT);

//			font for the table heading
            Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD);

//			/*font for the pdf table data
            Font f2 = new Font(pdf, CoreFont.HELVETICA);
            Font f3 = new Font(pdf, CoreFont.HELVETICA);

//			pdf table
            Table table1 = new Table();
            Font font = new Font(pdf, CoreFont.HELVETICA_BOLD);

            // Create a table object with 3 columns
            Table table = new Table();
            ArrayList<List<Cell>> data = new ArrayList<List<Cell>>();

            ArrayList<Cell> header = new ArrayList<Cell>();
            header.add(new Cell(f1,"username"));
            header.add(new Cell(f1,"nom"));
            data.add(header);
            for(candidature candidatureIns:candidaturesListe) {
                ArrayList<Cell> row1 = new ArrayList<Cell>();
                row1.add(new Cell(f1,"username"));
                row1.add(new Cell(f1,"nom"));
                data.add(row1);

            }
            ArrayList<candidature> arrayList = new ArrayList<candidature>(candidaturesListe);

            table.setData(data);



            //add row to table




            table1.setPosition(20f, 150f);
            table1.setColumnWidth(0, 50f);
            table1.setColumnWidth(1, 160f);
            table1.setColumnWidth(2, 70f);
            table1.setColumnWidth(3, 65f);
            table1.setColumnWidth(4, 220f);
table.drawOn(page)         ;
          //  pdf.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        alert.setContentText("rapport generer en bureau  ");
        alert.showAndWait();*/
    }


    @FXML
    void triNote(MouseEvent event) throws SQLException {
        FXCollections.sort(candidaturesListe, new CompareNote());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(candidaturesListe);
    }
    @FXML
    void triUsername(MouseEvent event) throws SQLException {
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

            candidaturesListe= (ObservableList<candidature>) cs.recupererSuivantannance(new annonce(1));
            remplirliste(candidaturesListe);


    }


}
