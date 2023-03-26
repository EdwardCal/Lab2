package domain;

import java.text.DecimalFormat;

public class KnightTour {

    private int walks;

    public String solveKnightTour(int n,int row, int col) { //Recibe el tamaño del tablero y la posición inicial
        String result="";
        int[][] board = new int[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]=0;
            }
        }
        board[row][col]=0;

            if (placeKnights(board, row, col, n, 1)) {
                    result += printBoard(board);
            } else {
                result += "Solution does not exist for this position";
            }
        return result;
    }

        private boolean placeKnights(int [][] board,int row, int col, int n, int index){ // Coloca los caballos
            if (board[row][col] != 0) {
                return false;
            }
            board[row][col] = walks++;

            if (index == n * n - 1) {
                return true;
            }
            // las ocho formas en las que puede avanzar el caballo
            if (isValid(row + 2, col + 1, n) && placeKnights(board, row + 2, col + 1, n, index + 1)) {
                return true;
            }
            if (isValid(row + 1, col + 2, n) && placeKnights(board, row + 1, col + 2, n, index + 1)) {
                return true;
            }
            if (isValid(row - 1, col + 2, n) && placeKnights(board, row - 1, col + 2, n, index + 1)) {
                return true;
            }
            if (isValid(row - 2, col + 1, n) && placeKnights(board, row - 2, col + 1, n, index + 1)) {
                return true;
            }
            if (isValid(row - 2, col - 1, n) && placeKnights(board, row - 2, col - 1, n, index + 1)) {
                return true;
            }
            if (isValid(row - 1, col - 2, n) && placeKnights(board, row - 1, col - 2, n, index + 1)) {
                return true;
            }
            if (isValid(row + 1, col - 2, n) && placeKnights(board, row + 1, col - 2, n, index + 1)) {
                return true;
            }
            if (isValid(row + 2, col - 1, n) && placeKnights(board, row + 2, col - 1, n, index + 1)) {
                return true;
            }
            board[row][col] = 0;
            walks--;
            return false;
        }

        private boolean isValid(int row, int col, int n) { //Revisa si la posición es valida y no se sale de los parametros del tablero
        boolean result = false;

            if ((row >= 0) && (row < n) && (col >= 0) && (col < n)) {
                result = true;
            }
            return result;
        }


        private String printBoard(int[][] board) {
            DecimalFormat digits = new DecimalFormat("00");
            String result="";
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    result+=digits.format(board[i][j])+" ";
                }
                result+="\n";
            }
            return result;
        }


}
