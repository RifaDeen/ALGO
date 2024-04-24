// Fathima Rifa Badurdeen   stu id: 20220701

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class FileParser {

    // Method to parse the maze.txt from a file
    public static Maze parseMaze(String filePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

            // Determine the number of rows and columns
            int rows = 0;
            int cols = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                cols = Math.max(cols, line.length());
                rows++;
            }

            // Initialize the maze
            Maze maze = new Maze(rows, cols);

            // Reset reader to beginning of the file
            reader.close();
            BufferedReader newReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            // Read data from the file and store it in the maze
            for (int i = 0; i < rows; i++) {
                line = newReader.readLine();
                for (int j = 0; j < line.length(); j++) {
                    char symbol = line.charAt(j);
                    Node node = new Node(i, j, symbol);
                    maze.setNode(i, j, node);
                    if (symbol == 'S') {
                        maze.setStartNode(node);
                    } else if (symbol == 'F') {
                        maze.setFinishNode(node);
                    } else if (symbol == '0') {
                        maze.addRock(node);
                    }
                }
            }
            //maze.print();
            newReader.close();
            return maze;

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }


    // method to print the maze details
    public static void printMazeDetails(Maze maze) {
        System.out.println("\n**************** Maze Details *****************");
        System.out.println();
        assert maze != null;
        System.out.println("Maze Width: " + maze.getWidth());
        System.out.println("Maze Height: " + maze.getHeight());
        System.out.println("Start Location: (" + (maze.getStartNode().getCol() + 1) + ", " + (maze.getStartNode().getRow() + 1) + ")");
        System.out.println("Finish Location: (" + (maze.getFinishNode().getCol() + 1) + ", " + (maze.getFinishNode().getRow() + 1) + ")");

        List<Node> rocks = maze.getRocks();

        // Sort the rocks based on their column values
        rocks.sort(Comparator.comparing(Node::getCol));

        System.out.println("Rocks Locations: ");
        int count = 0;
        for (Node rock : rocks) {
            System.out.print("(" + (rock.getCol() + 1) + ", " + (rock.getRow() + 1) + ") ");
            count++;
            if (count % 15 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

