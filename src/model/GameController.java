package model;

import java.util.Random;



public class GameController{

    private Board board;
    private int currentTurn;
    boolean gameOver;
    public static Random random = new Random();
    




    public GameController(){
    
        board = new Board(0, 0);
         


    }

    public void generateBoard(int rows, int cols, int snake, int ladder) {
        this.board = new Board(rows, cols);
        addNodes(1, rows*cols);
        
        board.addLadders(ladder);
        configPlayers();
    }

    public void showBoard(){
        board.printBoard();
        
    }

    public void showSnakeAndLadder(){
        board.printBoardSnakeAndLadder();
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

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void updateCurrentTurn() {
        if (currentTurn == 3) {
            this.currentTurn = 1;
        } else {
            this.currentTurn++;
        }
    }
    public void move(){
        board.move(currentTurn);
        updateCurrentTurn();
    }

    public void configPlayers(){
        board.configPlayers(board.getHead());
    }

    //** */
 


    //** */
    public boolean hasGameFinished(){
        return board.gameFinished();
    }
   public String winners(){
    return board.returnPositions();
   }
    public void position(){
        
    }

    //** */









}