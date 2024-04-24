// Fathima Rifa Badurdeen   stu id: 20220701

import java.util.List;

public class Solution {
    public static void displaySolution(List<Node> path) {
        System.out.println("\n**************** Solution *********************");
        System.out.println();
        if (path == null) {
            System.out.println("No solution found.");
        } else {
            Node previousNode = null;
            for (int i = 0; i < path.size(); i++) {
                Node currentNode = path.get(i);
                if (i == 0) {
                    System.out.println((i + 1) + ". Start at (" + (currentNode.getCol()+1) + ", " + (currentNode.getRow()+1) + ")");
                }else {
                    String direction = getDirection(currentNode, previousNode);
                    System.out.println((i + 1) + ". Move " + direction + " to (" + (currentNode.getCol()+1) + ", " + (currentNode.getRow()+1) + ")");
                }
                previousNode = currentNode;
            }
            System.out.println( path.size()+1 + ".Done!");
        }
    }
    private static String getDirection(Node currentNode, Node previousNode) {
        String direction = "";
        if (currentNode.getRow() > previousNode.getRow()) {
            direction = "down";
        } else if (currentNode.getRow() < previousNode.getRow()) {
            direction = "up";
        } else if (currentNode.getCol() > previousNode.getCol()) {
            direction = "right";
        } else if (currentNode.getCol() < previousNode.getCol()) {
            direction = "left";
        }
        return direction;
    }
}

