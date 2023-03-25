package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BackTrackingTest {

    @Test
    public void test1() {
        NQueenProblem nQueen = new NQueenProblem();
        System.out.println("N Queens Problem solution for a 8x8 board");
        System.out.println(nQueen.solveNQueen(8));

        System.out.println("N Queens Problem solution for a 4x4 board");
        System.out.println(nQueen.solveNQueen(4));
    }
    @Test
    public void test2(){
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
        rt.printProblem(maze1);

       rt.solveMaze(maze1);
    }
}