package controller;

import domain.SudokuSolver;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolverController
{
    @javafx.fxml.FXML
    private TableView TableView;
    @javafx.fxml.FXML
    private TextArea textArea;
    private String sudokuData;
    @javafx.fxml.FXML
    public void initialize() {
        test();

        //agregamos las columnas al tableview
        for (int i = 0; i < 9; i++) {
            final int colIndex = i;
            TableColumn<List<String>, String> column = new TableColumn<>("col-"+(i+1));
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue().get(colIndex)));
            TableView.getColumns().add(column);
        }
        TableView.setItems(getData());


    }

    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        sudokuData = sudokuData.replaceAll("\n",""); //para eliminar los saltos de linea
        sudokuData = sudokuData.replaceAll(" ","");
        String a[] = sudokuData.split("");
        int count = 0;
        List<String> info = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            info.add(a[i]);
            if(count++==8){
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }

    private void test() {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        this.textArea.setText(sudokuSolver.printSudoku(board)+"\n"+"solution"+"\n"+sudokuSolver.sudokuSolver(board));
        this.sudokuData = sudokuSolver.sudokuSolver(board);
    }

}