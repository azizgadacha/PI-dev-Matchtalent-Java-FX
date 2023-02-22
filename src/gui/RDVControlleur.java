package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class RDVControlleur  implements Initializable {

    @FXML
    private ChoiceBox<Integer> CB1;

    @FXML
    private ChoiceBox<Integer> CB2;

    @FXML
    private DatePicker date_Picker;
    private int[] a = IntStream.range(1, 30).toArray();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=8;i<18;i++) {
            CB1.getItems().add(i);
        }
        for (int i=0;i<60;i++) {
            CB2.getItems().add(i);
        }
    }
}
