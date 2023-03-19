package model;

import java.util.Random;


public class GameController{

    private Board board;
    public static Random random = new Random();
    private Player currentPlayer;
    private Random dice;


    public GameController(){

        board = new Board(0, 0);
        this.currentPlayer = new Player(0);
        this.dice = new Random();
        this.currentPlayer = null;


    }

    public void generateBoard(int rows, int cols) {
        this.board = new Board(rows, cols);
        addNodes(1, rows*cols);


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

    public String createPlayer(String symbol, Node node) {
        if (symbol == null || symbol.isEmpty()) {
            return "Invalid symbol.";
        }

        if (validateSymbol(symbol.charAt(0), 0)) {
            Player newPlayer = new Player(symbol.charAt(0));
            newPlayer.setCurrent(board.getHead());
            currentPlayer.addPlayer(newPlayer);
            return "Created player.";
        } else {
            return "Invalid option.";
        }
    }

    private String getPosPlayer(Node current, Player player, boolean passed) {
        if(player == ((Player) current).getHead()) {
            if(!passed) {
                passed = true;
            } else {
                return "";
            }
        }
        if(player.getCurrent() == current) {
            return player.getToken() + getPosPlayer(current, (Player)player.getNext(), passed);
        } else {
            return getPosPlayer(current, (Player)player.getNext(), passed);
        }
    }

    public boolean validateSymbol(char symbol, int i) {
        //Put valid symbols here
        String symbols = "*!OX%$#+&";
        if (i == 9) {
            return false;
        } else {
            //Validate if the symbol is correct
            if (symbols.charAt(i) == symbol) {
                //Validate if the symbol has been chosen
                return !currentPlayer.validatePlayer(symbols.charAt(i));
            } else {
                return validateSymbol(symbol, ++i);
            }
        }
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

    public Object createPlayer(String nextLine) {
        return null;
    }

    public char getCurrentSymbol() {
        if (currentPlayer == null) {
            return currentPlayer.getHead().getToken();
        } else {
            return currentPlayer.getToken();
        }
    }





}
