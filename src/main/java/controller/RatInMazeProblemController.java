package controller;

import domain.RatInMaze;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeProblemController
{
    private String ratData;

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

        String a[] = ratData.split(" ");
        int count = 0;
        List<String> info = new ArrayList<>();
        ratData = ratData.replaceAll("\n",""); //para eliminar los saltos de linea
        for (int i = 0; i < 64; i++) {
            info.add(a[i]);
            if(count++==7){
                data.add(info);
                info = new ArrayList<>();
                count = 0;
            }
        }
        return data;
    }
    public void test(){
        RatInMaze rt= new RatInMaze();
        int[][] maze1 = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int maze2[][] = {
                {1, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1},
        };

        int maze3[][] = {
                {1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1},
        };
        textArea.setText("Rat In a Maze for a 4x4 board\n"+rt.printProblem(maze1)+
                            "\nSolution\n"+rt.solveMaze(maze1)+
                            "\nRat In a Maze for a 8x8 board\n"+rt.printProblem(maze2)+
                            "\nSolution\n"+rt.solveMaze(maze2)+
                            "\nRat In a Maze for a 8x8 board\n"+rt.printProblem(maze3)+
                            "\nSolution\n"+rt.solveMaze(maze3)
        );
        this.ratData= String.valueOf(rt.solveMaze(maze2));
    }
}