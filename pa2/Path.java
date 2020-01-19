/******************************************************************************
 * Path.java
 *
 * A linked list of nodes representing the optimal path returned by Match
 *
 ******************************************************************************/

public class Path {
  private int row, col;
  private int cost;
  private Path next;
  private char a, b;

Path(int x, int y) {
  row = x;
  col = y;
  next = null;
  this.cost = 0;
}
public void setCharA(char a) {
    this.a = a;
}
public char getCharA() {
   return a;

}
public void setCharB(char b) {
  this.b = b;
}
public char getCharB() {
    return b;
}
public void setPath(Path next) {
      this.next = next;
}
  public void setCost(int cost) {
      this.cost = cost;
  }
  public void setRow(int row) {
      this.row = row;
  }
public void setCol(int col) {
     this.col = col;
  }
  public int getRow() {
      return row;
  }
  public int getCol() {
      return col;
  }
  public int getCost() {

      return cost;
  }
  public Path getPath() {
      return next;
  }
}
