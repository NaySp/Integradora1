package model;
import java.util.Random;
import java.util.Scanner;

public class GameController{

    private Scanner scanner;
    private Board board;
 

    public static Random random = new Random();

    public GameController(){
        scanner = new Scanner(System.in);
        board = new Board(0, 0);


    }

    public String showBoard(){
        return board.printBoard();
    }

    public void generateBoard(int rows, int cols) {
        this.board = new Board(rows, cols);
        addNodes(1, rows*cols);
        
    
    }

    public void addNodes(int current, int limit){

        if(current > limit){
            return;
        }
        else{
            int rows = board.getRows(), columns = board.getCols();

            int totalNodes = rows*columns, counter = 1;

            board.addNodes(totalNodes, counter); 

        }
              

    }


    

}