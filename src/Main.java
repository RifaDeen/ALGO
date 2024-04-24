// Fathima Rifa Badurdeen   stu id: 20220701

import java.util.List;

public class Main {  //main class to run the program
    public static void main(String[] args) {

        // Specify the file path
        String filePath = "./examples/maze.txt";
        //String filePath = "./benchmark_series/puzzle_1280.txt";

        // Parse the maze.txt from the file using GridParser
        Maze maze = FileParser.parseMaze(filePath);

        // Solve the maze.txt using A* algorithm
        assert maze != null;
        long startTime = System.currentTimeMillis();
        List<Node> path = AStarSolver.solve(maze);
        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);
        System.out.println("\nTime taken to solve the maze: " + duration + " milliseconds");

        // Display the steps of the solution
        Solution.displaySolution(path);

        //helper method call to print the maze details
        System.out.println();
        maze.print();
        FileParser.printMazeDetails(maze);
    }
}
