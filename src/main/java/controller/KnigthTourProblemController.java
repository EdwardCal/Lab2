package controller;

import domain.KnightTour;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class KnigthTourProblemController {


    private String KnigthTourData;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TableView tableView;

    @javafx.fxml.FXML
    public void initialize() {
        test();

        for (int i = 0; i < 8; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-"+(i+1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            tableView.getColumns().add(column);
        }
        tableView.setItems(getData());

    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        int count = 0;
        List<String> info = new ArrayList<>();
        KnigthTourData = KnigthTourData.replaceAll("\n", ""); //para eliminar los saltos de linea
        String a[] = KnigthTourData.split("");
        for (int i = 0; i < 64; i++) {
            info.add(a[i]);
            if (count++ == 7) {
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }
    public void test(){
        KnightTour knightTour = new KnightTour();
        textArea.setText("Knight Tour Problem solution for a 8x8 board\n"+
                            knightTour.solveKnightTour(8,0,0));
        this.KnigthTourData=knightTour.solveKnightTour(8,0,0);
    }
}