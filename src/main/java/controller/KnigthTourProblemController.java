package controller;

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

        for (int i = 0; i < 8; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-" + (i + 1));
            column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().get(colIndex)));
            tableView.getColumns().add(column);
        }
        tableView.setItems(getData());

    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        KnigthTourData = KnigthTourData.replaceAll("\n", ""); //para eliminar los saltos de linea
        KnigthTourData = KnigthTourData.replaceAll(" ", "");
        String a[] = KnigthTourData.split("");
        int count = 0;
        List<String> info = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            info.add(a[i]);
            if (count++ == 8) {
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }
}