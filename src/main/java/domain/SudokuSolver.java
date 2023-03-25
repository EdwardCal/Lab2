package domain;

public class SudokuSolver {
    int size = 9;
    public boolean solving(int[][] board, int row, int col){

        //
        if(row == size-1 && col == size){
            return true;
        }

        //If col is equal to 9 which is the col limit, return col to 0 and increase the row
        if(col == size){
            row++;
            col = 0;
        }

        //if position is different from 0(free space), it goes to the next position
        if (board[row][col] != 0){
            return solving(board, row, col+1);
        }

        //This code try to put every number from 0 to 9 in a free space
        for (int i = 0; i < 10; i++) {
            if(isSafe(board, row, col, i)){
                board[row][col]=i;
                if (solving(board, row, col+1)){
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    //this code just puts the board in a String
    public String printSudoku(int[][] board) {
        String result = "";
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                result+=board[i][j] + " ";
            result+="\n";
        }
        return result;
    }

    //It search for the number, if the number already exists in the same column, row, or 3x3 it return false
    private boolean isSafe(int[][] board, int row, int col, int num) {
        //Si el numero que se intenta colocar ya se encuentra
        //en la columna retorna false
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == num){
                return false;
            }
        }

        //Si el numero que se intenta colocar ya se encuentra
        //en la fila retorna false
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == num){
                return false;
            }
        }

        //Si el numero que se intenta colocar ya se encuentra
        //en el sector de 3x3 retorna false
        int startRow3x3 = row-row%3;
        int startCol3x3 = col-col%3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i + startRow3x3][j+startCol3x3] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    //main method to resolve the sudoku
    public String sudokuSolver(int[][] board){
        if (solving(board, 0,0)){
            return(printSudoku(board));
        }else {
            return("Solution doesn't exists");
        }
    }
}
