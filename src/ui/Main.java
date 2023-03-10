package ui;
import model.*;
import java.util.Scanner;


public class Main {

    private Scanner reader;
    private Board tablero;

    public Main(){
        
        reader = new Scanner(System.in);
       
        tablero=new Board();
            tablero.addLast(new Node(0));
            tablero.addLast(new Node(1));
            tablero.addLast(new Node(4));
            tablero.addLast(new Node(5));
            tablero.addLast(new Node(6));
            tablero.addLast(new Node(5));
            tablero.addLast(new Node(8));
            tablero.addLast(new Node(9));
            tablero.addLast(new Node(10));



            tablero.printBoard(3, 3);
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
    System.out.println("|s|   Sssnake and Ladd⊭rs    |=| \n");
    System.out.print("1.Jugar. \n" +
        "0. Salir .\n\n" +
        "Opción: "); 
    }

 
    public void executeOption(int option){
        
        switch(option){
        
            case 1 -> System.out.println("playing");
            case 0 -> System.out.println("exit");
        
        
            default -> System.out.println("Invalid Option, try again :c ");
        }
	}


}