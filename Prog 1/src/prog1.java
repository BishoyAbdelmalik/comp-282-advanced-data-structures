/**
 * @author Bishoy A Abdelmalik
 * @class COMP 282 meeting at 2:00 PM
 * @Assigment Program #1
 * @DateTurnedIn  Sept 11, 2019
 * @description Included is the two classes KnightBoard that have the board and the algorithm to do the knight tour and the pair class which is used as a row and column of a square on the board
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// The main class for the chessboard and methods needed to implement the 
// algorithm for finding knight's tours 
class KnightBoard {
    private int board[][];
    private int numRows, numCols;
    private Pair start;
    private ArrayList < Pair > move;
    // default constructor -- you might want to add a little to this 
    //     and use it for debugging 
    public KnightBoard() {
        board = new int[8][8];
        for (int row = 0; row < 8; row++)
            for (int col = 0; col < 8; col++) board[row][col] = 0;
        move = new ArrayList < Pair > ();
        start = new Pair(-1, -1);
    }

    // constructor -- data comes from a file 
    public KnightBoard(String fileName) throws IOException {
        Scanner sc=new Scanner(new File(fileName));//create scanner object and passing file as input
        String line=sc.nextLine();//reading the first line
        line=line.substring(line.indexOf(':')+1).trim();//parsing the line to remove the text and leave only the numbers
        numRows=Integer.parseInt(line.substring(0,line.indexOf(' ')).trim());// read until the space and trim and parse it to an int
        numCols=Integer.parseInt(line.substring(line.indexOf(' ')).trim());// read until the space and trim and parse it to an int
        board = new int[numRows][numCols];

        line=sc.nextLine();// read next line 
        line=line.substring(line.indexOf(':')+1).trim();//parsing the line to remove the text and leave only the numbers
        int startRow=Integer.parseInt(line.substring(0,line.indexOf(' ')).trim());
        int startCol=Integer.parseInt(line.substring(line.indexOf(' ')).trim());


        start=new Pair(startRow,startCol);
        board[start.getRow()][start.getCol()]=1;


        sc.nextLine(); //ignore piece movement string
        move = new ArrayList < Pair > ();

        while(sc.hasNext()) {
            line=sc.nextLine();// read next line 
            int row=Integer.parseInt(line.substring(0,line.indexOf(' ')).trim());
            int col=Integer.parseInt(line.substring(line.indexOf(' ')).trim());
            move.add(new Pair(row,col));
        }

        sc.close();

    }


    // copy constructor
    // Be sure to make a copy of everything. Do not have this KnightBoard 
    //  point to anything in b. 
    public KnightBoard(KnightBoard b) {
        this.numRows=b.board.length;
        this.numCols=b.board[0].length;
        this.board = new int[this.numRows][this.numCols];
        //copy all the data from b.board to the board in this object
        for (int row = 0; row < this.numRows; row++) {
            for (int col = 0; col < this.numCols; col++) {
                this.board[row][col]=b.board[row][col];
            }
        }
        // create a copy of start
        this.start=new Pair(b.start);
        this.move=new ArrayList < Pair > ();
        //copy every element from b.move and add it to this object
        for(Pair p:b.move) {
            this.move.add(new Pair(p));

        }
    }
 

    // These are the 3 methods I use to get the job done. You do not have to use 
    // these, but I found them useful. Ee sure to use the Pair class as much as 
    // possible

    // Check if this is a legal square to move to, i.e., is it actually on 
    // the board and has it not been entered yet 
    private boolean tryMove(Pair sq) {
        boolean returnValue=true;//assumes move is valid until proven otherwise
        if(!(sq.getRow()<board.length&&sq.getRow()>=0)
                ||!(sq.getCol()<board[0].length&&sq.getCol()>=0)) {// if its not on the board switch the return value to false
            returnValue=false;
        }
        else if(board[sq.getRow()][sq.getCol()]>0) {//if it is on the board check if that place has been visited if it has been then change return to false
            returnValue=false;
        }
        return returnValue;
    }

    // The number of legal moves from this square 
    private int moveCt(Pair sq) {
        int count=0;// assumes there is  moves
        for(Pair m:move) {
            Pair possibleMove = generateNextPostion(sq, m);//get the location on the board
            if (tryMove(possibleMove)) {//check if its valid if it is add 1
                count++;
            }
        }
        return count;
    }

    /**
     * this method generates the square given current location and the direction ie the legal move 
     * @param current
     * @param moveDirections
     * @return Pair
     */
    private Pair generateNextPostion(Pair current,Pair moveDirections) {
        return new Pair(current.getRow()+moveDirections.getRow(),current.getCol()+moveDirections.getCol());
    }

    // sq is the square the knight is on. Update the square to its new 
    // location based on the move and update the board to reflect this new move 
    private void makeMove(Pair sq, Pair move) {
        board[move.getRow()][move.getCol()]=board[sq.getRow()][sq.getCol()]+1;
    }
    // Enter the knight's moves into the board array 
    // Here’s how mine begins. It would be nice if yours starts the same way.  :)
    public void solve() {
        Pair nextMove = null;
        boolean done = false;
        while (!done) {
            int bestMoveCt=-1;// keeps a record of possible next moves
            Pair curSpot = (nextMove!=null)?new Pair(nextMove):new Pair(start);//saves current place and if next move == null save make it start
            nextMove=null;// saves next move
            done=true;//assume we will exit and it will be set to false if next move is set to a value
            for(Pair m:move) {
                Pair nextMoveTemp=generateNextPostion(curSpot,m);//used to test if this move is valid if it  is it will be set to nextMove
                if(tryMove(nextMoveTemp)) {
                    int bestMoveTemp=moveCt(nextMoveTemp);
                    if(bestMoveTemp<=bestMoveCt||bestMoveCt==-1) {
                        bestMoveCt=bestMoveTemp;
                        nextMove=nextMoveTemp;
                        done=false;
                    }
                }
            }
            // if we are not done meaning we found next move do the move
            //otherwise do nothing and and exit loop
            if(!done) {
                makeMove(curSpot,nextMove);
            }
        }

    }
    // Who are you? Put your name here. 
    public static String myName() {
        return "Bishoy Abdelmalik";
    }

    // For easy checking of your answers 
    public String toString2() {
        String result = new String();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                result = result + String.valueOf(board[row][col]);
            }
        }
        return result;
    }
    // Look at my output in testTours to see what should be happening 
    // Hint: use String.valueOf( num ) to convert int num to a String TODO if we didnt use String.valueOf????
    // You must be sure the columns line up properly as they do in my 
    // output. 
    public String toString() {
        String output="";
        boolean smallBoard=true;//to determine the spacing assume its small board
        try {
            if(Math.multiplyExact(board.length, board[0].length)>99) {//if the multiplication is equal to a value bigger than 99 then its not small board
                smallBoard=false;
            }
        }catch (ArithmeticException e) {
            smallBoard=false;
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(smallBoard) {
                    if(board[row][col]<10) {
                        output+=" ";
                    }
                }else {

                    if(board[row][col]<10) {
                        output+="   ";
                    }
                    if(board[row][col]<100&&board[row][col]>9) {
                        output+="  ";

                    }
                    if(board[row][col]>99&&board[row][col]<1000) {
                        output+=" ";

                    }

                }
                output+=" ";
                output+=board[row][col];
            }
            output+="\n";
        }

        return output;
    }


}


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