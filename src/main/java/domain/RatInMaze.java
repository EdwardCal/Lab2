package domain;

public class RatInMaze {
    // Función para imprimir la solución
    public String printSolution(int[][] sol) {
        int N = sol.length;
        String result="";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result+=sol[i][j]+" ";
            }
            result+="\n";
        }
        return result;
    }
    public String printProblem(int[][] maze) {
        int N = maze.length;
        String result="";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result+=maze[i][j]+" " ;
            }
            result+="\n";
        }
        return result;
    }

    // Función para verificar si una posición es segura
    public static boolean isSafe(int[][] maze, int x, int y, int[][] sol) {
        int N = maze.length;
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Función para resolver el problema de Rat in a Maze
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        // si se llega a la posición de salida, se retorna verdadero
        if (x == maze.length - 1 && y == maze.length - 1) {
            sol[x][y] = 2;
            return true;
        }

        // si la posición actual es segura, se marca como visitada
        if (isSafe(maze, x, y, sol)) {
            sol[x][y] = 2;

            // se mueve hacia adelante en la dirección x
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            // si moverse en dirección x no lleva a una solución, se mueve hacia abajo en la dirección y
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            // si no se encuentra una solución en ninguna dirección, se retrocede y marca la posición como no visitada
            sol[x][y] = 0;
            return false;
        }

        // si la posición actual no es segura, se retorna falso
        return false;
    }

    // Función para resolver el problema de Rat in a Maze
    public String solveMaze(int[][] maze) {
        int N = maze.length;
        int[][] sol = new int[N][N];




        // se llama a la función recursiva para resolver el problema
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            return "No hay solución para este laberinto";
        }

        // se imprime la solución
        return printSolution(sol);
    }
}
