// Fathima Rifa Badurdeen   stu id: 20220701

public class Node {     //class to represent a node in the maze
    private final int row;
    private final int col;
    private char type;
    private int g;  // g score
    private int h;  // h score
    private int f;  // f score
    private Node parent;

    public Node(int row, int col, char type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.g = Integer.MAX_VALUE; // set g score to infinity
        this.h = 0;
        this.f = this.g + this.h;
        this.parent = null;
    }

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getters and setters
    public int getRow() { return row; }

    public int getCol() { return col; }

    public char getType() { return type; }

    public int getG() { return g; }

    public void setG(int g) { this.g = g; }

    public int getH() { return h; }
    public void setH(int h) { this.h = h; }

    public int getF() {
        f = getG() + getH();
        return f;
    }

    public void setF(int f) { this.f = f; }

    public Node getParent() { return parent; }

    public void setParent(Node parent) { this.parent = parent; }

}
