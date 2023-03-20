package model;

import java.util.Random;


public class GameController{

    private Board board;
    public static Random random = new Random();   
    private Player currentPlayer;
    private Random dice;


    public GameController(){
    
        board = new Board(0, 0);

        this.dice = new Random();
        this.currentPlayer = null; 


    }

    public void generateBoard(int rows, int cols, int snake, int ladder) {
        this.board = new Board(rows, cols);
        addNodes(1, rows*cols);
        board.addSnakes();
        board.addLadders();
    }

    public void showBoard(){
        board.printBoard();
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

    public void configPlayers(){
        board.configPlayers(board.getHead());
    }

    public void move(Node current) {
		int roll = rollDice();
		moveHelper(current, roll);
	}
	
	private void moveHelper(Node current, int remainingMoves) {
		if (remainingMoves == 0 || current == null) {
			return;
		}
		moveHelper(current.getNext(), remainingMoves - 1);
	}
	

	public int rollDice() {
        return dice.nextInt(6) + 1;
    }

    
 



    

}
