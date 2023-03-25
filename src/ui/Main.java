package ui;
import model.*;
import java.util.Scanner;




public class Main {

    private Scanner reader;
    private GameController controller;


    

    public Main(){
        reader = new Scanner(System.in);
        controller = new GameController();

       
    }

    public static void main(String[] args) {

        Main main = new Main();
        int option = -1;

        do{

            option = main.getOptionShowMenu();
            main.executeOption(option);

        }while(option != 0);
        
    }

    public int validateInt(){
        int option = -1;

        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.next();
            option = -1;
        }
        return option;
    }

    public Scanner getReader(){
        return this.reader;
    }

    public int getOptionShowMenu(){
        int option =0;
        printMenu();
        option = validateInt();
        return option;
        
        
    }

    public void printMenu(){
    System.out.println(" ");
    System.out.println("|s|   Sssnake and Ladd⊭rs   |=| \n");
    System.out.print("1. Jugar. \n" +
        "0. Salir.\n\n" +
        "Opción: "); 
    }

 
    public void executeOption(int option){
        
        switch(option){
        
            case 1 -> play();
            case 0 -> System.out.println("exit");
        
        
            default -> System.out.println("Invalid Option, try again :c ");
        }
	}

    public void play(){

        int n;
        int m;

        int s;
        int e;

        System.out.println("Please type the numbers of  rows that the game will have: ");
        n = validateInt();  
        System.out.println("Now, type the number of column");
        m = validateInt();

        System.out.println("It´s almost over, please type the number of the sneakes u want, remember that it cannot be higher than 40% ");
        s = validateInt();  
        System.out.println("And, type the number of stairs (remember that it cannot be higher than 40%)");
        e = validateInt();
        

        controller.generateBoard(n, m, s, e);
        reader.nextLine();
        System.out.println("\nThe game will be play only wit 3 players. Just choose your turn :p");
        controller.configPlayers();
        GameMenu();
        
        
    }

    public void GameMenu(){

        controller.showBoard();
        

        /** */
        System.out.print("""
                \n- >> Playinggg << -
                Player turn:\s""" + controller.getCurrentTurn()+ "\s["  + """
                ]\n1. Roll dice
                2. Show snakes and ladders
                Option:\s""");
        int option = reader.nextInt();

        switch (option) {
            case 1 ->controller.move();
            case 2 -> controller.showSnakeAndLadder();
            default -> System.out.println("\nInvalid input");
        }

        if(controller.hasGameFinished()) {
            reader.nextLine();
            
        } 
            GameMenu();
        }
    }

    

