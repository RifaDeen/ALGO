// Fathima Rifa Badurdeen   stu id: 20220701

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final Node[][] graph;
    private final int width;
    private final int height;
    private Node startNode;
    private Node finishNode;
    private final List<Node> rocks;

    public Maze(int rows, int cols) {
        graph = new Node[rows][cols];
        width = cols;
        height = rows;
        rocks = new ArrayList<>();

        // Initialize all elements in the graph array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                graph[i][j] = new Node(i, j);
            }
        }
    }

    // Getters and setters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getFinishNode() {
        return finishNode;
    }

    public void setFinishNode(Node finishNode) {
        this.finishNode = finishNode;
    }

    public void setNode(int row, int col, Node node) {
        graph[row][col] = node;
    }

    public List<Node> getRocks() {
        return rocks;
    }

    public void addRock(Node rock) {
        rocks.add(rock);
    }

    // Method to get adjacent nodes with sliding behavior
    public List<Node> getAdjacentNodes(Node node) {
        List<Node> adjacentNodes = new ArrayList<>();
        int[] dx = {-1, 0, 1, 0}; // Change in row index for up, right, down, left
        int[] dy = {0, 1, 0, -1}; // Change in column index for up, right, down, left

        // Iterate over all possible directions
        for (int i = 0; i < 4; i++) {
            int newRow = node.getRow();
            int newCol = node.getCol();
            Node lastValidNode = null; // Keep track of the last valid node in the slide

            // Move in the current direction until hitting an obstacle or reaching the end
            while (true) {
                newRow += dx[i];
                newCol += dy[i];

                // Check if the new position is within the maze bounds
                if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
                    break;
                }

                // Check if the new position is a rock or wall
                if (graph[newRow][newCol].getType() == '0') {
                    break;
                }

                // Update the last valid node
                lastValidNode = graph[newRow][newCol];

                // Check if the new position is the finish node
                if (graph[newRow][newCol].equals(finishNode)) {
                    break;
                }
            }

            // Add the last valid node as an adjacent node
            if (lastValidNode != null) {
                adjacentNodes.add(lastValidNode);
            }
        }

        return adjacentNodes;
    }

                //method to get adjacent nodes with no sliding behavior
        //    public List<Node> getAdjacentNodes(Node node) {
        //        List<Node> adjacentNodes = new ArrayList<>();
        //        // Up, Right, Down, Left
        //        int[] dx = {-1, 0, 1, 0}; //change in row index
        //        int[] dy = {0, 1, 0, -1}; //change in column index
        //
        //        for (int i = 0; i < 4; i++) {
        //            int newRow = node.getRow() + dx[i];
        //            int newCol = node.getCol() + dy[i];
        //            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
        //                adjacentNodes.add(graph[newRow][newCol]);
        //            }
        //        }
        //
        //        return adjacentNodes;
        //    }


    //helper method to print the graph as read from the file
    public void print() {

        System.out.println("********** Maze Visualisation with indexes **********");
        System.out.println();
        System.out.println("S represents the start node, F represents the finish node, 0 represents rocks, and . represents empty nodes");
        System.out.println("Coordinates are set from top to bottom and left to right as (column, row) starting from 1; (1,1), (2,1), ...");
        System.out.println();

        for (Node[] nodes : graph) {
            for (Node node : nodes) {
                System.out.print(node.getType() + " ");
            }
            System.out.println();
        }

    }

}
