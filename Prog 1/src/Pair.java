import java.io.*; 
import java.util.*;


//Pair can be used as a row and column of a square on the board and 
// also as increment values to represent a generalized knight's move
class Pair {
    private int row, col; 
    // Constructor 
    public Pair(int row, int col) {
    	this.row=row;
    	this.col=col;
    }
    // Copy constructor 
    public Pair(Pair p) {
    	this.row=p.getRow();
    	this.col=p.getCol();
    }
    
    // Getters and Setters – a total of 4 methods
    
    public int getRow() {
    	return row;
    }
    public int getCol() {
		return col;
    }
    
    // This is one of the four 
    public void setRow(int row) {
    	this.row=row;
    }
    public void setCol(int col) {
    	this.col=col;   	
    }
    
    
    
    // It's almost always a good idea to override Java's default toString
    public String toString() {
    	return "(" + String.valueOf(row) + ", " + String.valueOf(col) + ")"; 
    }
}