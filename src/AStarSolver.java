// Fathima Rifa Badurdeen   stu id: 20220701

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSolver {
    public static List<Node> solve(Maze maze) {
        Node startNode = maze.getStartNode();
        Node finishNode = maze.getFinishNode();

        // Initialize open and closed lists
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::getF));
        List<Node> closed = new ArrayList<>();

        // Add start node to open list
        open.add(startNode);

        while (!open.isEmpty()) {
            // retrieves and removes the node with the lowest f value
            Node current = open.poll();

            // If reached the finish node, reconstruct and return the path
            if (current.equals(finishNode)) {
                return reconstructPath(current);
            }

            // Add current node to closed list
            closed.add(current);

            // Expand current node's neighbors
            for (Node nextNode : maze.getAdjacentNodes(current)) {
                // Skip if neighbor is already in closed list
                if (closed.contains(nextNode)) {
                    continue;
                }

                // Calculate tentative g score for neighbor
                int tentativeGScore = current.getG() + 1;

                // Update neighbor's g score if necessary
                if (!open.contains(nextNode) || tentativeGScore < nextNode.getG()) {
                    nextNode.setParent(current);
                    nextNode.setG(tentativeGScore);  // Update g score (distance from start node)
                    nextNode.setH(heuristic(nextNode, finishNode));  // Update heuristic score
                    if (!open.contains(nextNode)) {
                        open.add(nextNode);
                    }
                }
            }
        }

        // No path found
        return null;
    }

    // Method for reconstructing the path from start to finish node
    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current);
            current = current.getParent();
        }
        return path;
    }

    // Method to calculate heuristic distance (Euclidean distance)
    private static int heuristic(Node current, Node finish) {
        return (int) Math.sqrt(Math.pow(current.getRow() - finish.getRow(), 2) + Math.pow(current.getCol() - finish.getCol(), 2));
    }
}
