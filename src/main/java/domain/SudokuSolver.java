package domain;

public class SudokuSolver {
    int[][] sudoku;

    public boolean solving(int[][] sudoku, int col, int row){
        String result="";
        int size = sudoku.length-1;
        if(col == size && row == size){
            return true;
        }

        for (int i = 0; i < 10; i++) {
            if(isSafe(sudoku, col, row, i)){
                sudoku[row][col]=i;
                if (solving(sudoku, col, row)){
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }
        return false;
    }

    private String printSudoku() {
        String result = null;
        int size = sudoku.length;
        for (int k = 0; k < size; k++) {
            result+=sudoku[k%9][k/9]+"  ";
            if(k == 9){
                result+="\n";
            }
        }
        return result;
    }


    private boolean isSafe(int[][] sudoku, int col, int row, int num) {
        //Si el numero que se intenta colocar ya se encuentra
        //en la columna retorna false
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num){
                return false;
            }
        }

        //Si el numero que se intenta colocar ya se encuentra
        //en la fila retorna false
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == num){
                return false;
            }
        }

        //Si el numero que se intenta colocar ya se encuentra
        //en el sector de 3x3 retorna false
        //Este metodo fue creado con ayuda de terceros
        //https://www.geeksforgeeks.org
        int startRow3x3 = row-row%3;
        int startCol3x3 = col-col%3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(sudoku[i + startRow3x3][j+startCol3x3] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public String sudokuSolver(int[][] sudoku){
        this.sudoku = sudoku;
        if (solving(sudoku, 0,0)){
            return printSudoku();
        }else {
            return "Solution doesn't exists";
        }
    }
}
