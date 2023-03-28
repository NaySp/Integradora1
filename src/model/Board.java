package model;
import java.util.Random;

public class Board {
	
	private Node head; 
	private Node tail; 
	
	
	private int rows;
	private int cols;
	private Random dice;
	private Random random;
	int position1=0;
	int position2=0;
	int position3=0;
	
	private Snake snake;
	private Ladder ladder; 
	
	private Player p1=new Player("*");
	private Player p2=new Player("+");
	private Player p3=new Player("?");

	public Board(int rows, int cols) {
		this.head = null;
		this.tail = null;
		this.rows = rows;
		this.cols = cols;
		this.dice = new Random();
		this.random=new Random();
		
	}
	
	public void addValue(int value) {
		Node newNode = new Node(value);
		addLast(newNode);
	}
	
	public void addLast(Node node){
		if(this.head == null){
			this.tail = node; 
			this.head = node; 
			this.tail.setNext(this.head);
			this.head.setPrevious(this.tail);
		}
		else{
			this.tail.setNext(node);
			node.setPrevious(this.tail);
			this.tail = node; 
			this.tail.setNext(this.head);
			this.head.setPrevious(this.tail);
		}
	}

	public void addFirst(Node node){
		if(head == null){
			head = node;
			tail = node;
		}else{
			node.setNext(head);
			head = node;
		}
	}

	public void addNodes(int totalNodes, int counter){
		
		Node node = new Node(counter);

		if(counter <= totalNodes){
			addLast(node);
			addNodes(totalNodes, counter+1);

		}

	}

	//**    */
	
	public void printBoard() {
		printBoard(this.tail, this.rows, this.cols, 0);
	}
	
	

	private void printBoard(Node current, int rows, int cols, int count) {
		int colCount = 0;

		if (current == null || count == rows * cols) {
			System.out.println(); // Agregar salto de línea al final
			return;
		}
	
		int position = (rows * cols) - count - 1; // Calcular la posición del nodo actual
	
		if ((position + 1) % cols == 0) {
			System.out.print("\n"); // Agregar salto de línea al inicio de cada fila
			colCount = 0;
		} 
	
		if (colCount % 2 != 0) {
			reverse(current, cols, 1);
		} else {
			System.out.print(" [ " + current.getValue() + printp(current) + "      ] ");
			
			
			colCount++;
		}
		
		printBoard(current.getPrevious(), rows, cols, count + 1); // Avanzar al nodo anterior
	}

	//**  */

	public void printBoardSnakeAndLadder() {
		printBoardSnakeAndLadder(this.tail, this.rows, this.cols, 0);
	}

	private void printBoardSnakeAndLadder (Node current, int rows, int cols, int count) {
		
		int colCount = 0;

		if (current == null || count == rows * cols) {
			System.out.println(); // Agregar salto de línea al final
			return;
		}
	
		int position = (rows * cols) - count - 1; // Calcular la posición del nodo actual
	
		if ((position + 1) % cols == 0) {
			System.out.print("\n"); // Agregar salto de línea al inicio de cada fila
			colCount = 0;
		} 
	
		if (colCount % 2 != 0) {
			reverse(current, cols, 1);
		} else {
			System.out.print(" [ " + printSnL(current) + "      ] ");
			
			
			colCount++;
		}
		
		printBoard(current.getPrevious(), rows, cols, count + 1); // Avanzar al nodo anterior
	}
	
	//**  */

	private void reverse(Node current, int cols, int count) {
		if (current == null || count > cols) {
			return;
		}
		reverse(current.getPrevious(), cols, count + 1);
		System.out.print("[ " + current.getValue() + " ]");
	}



	//** */

	public String printp(Node current){
		String msj="";
		
		if(current.getValue()==p1.getValueP()){
			msj += p1.getToken();
		}
		if(current.getValue()==p2.getValueP()){
			msj += p2.getToken();
		}
		if(current.getValue()==p3.getValueP()){
			msj += p3.getToken();
		}
		return msj;
	}

	//**  */

	public String printSnL(Node current){
		
		String msj = "";

		if(snake != null && current.getValue() == snake.getHead()){
			msj += snake.getId();
		}
		if(snake != null && current.getValue() == snake.getTail()){
			msj += snake.getId();
		}
		if(ladder != null && current.getValue() == ladder.getHead()){
			msj += ladder.getId();
		}
		if(ladder != null && current.getValue() == ladder.getTail()){
			msj += ladder.getId();
		}

		return msj;
	}



	//**  */


	public void configPlayers(Node current){

		current=head;
		p1.setValue(current.getValue());
		p2.setValue(current.getValue());
		p3.setValue(current.getValue());
		p1.setNum(1);
		p2.setNum(2);
		p3.setNum(3);
		

	}
	
	public void move(int turno){
		if(turno==1){
			int dado=rollDice();
			System.out.println("Niceeeee :D, You got a "+dado);
			int posicion=p1.getValueP();
			int newPosition=posicion+dado;
			if(newPosition>rows*cols){
				System.out.println("Sorry, you got a number superior to the limit");
				return;
			}else if(newPosition==rows*cols){
				order(p1);
				p1.setValue(newPosition);
			}else{
			p1.setValue(newPosition);
			}
		}else if(turno==2){
			int dado=rollDice();
			System.out.println("Niceeeee :D, You got a "+dado);
			int posicion=p2.getValueP();
			int newPosition=posicion+dado;
			if(newPosition>rows*cols){
				System.out.println("Sorry, you got a number superior to the limit");
				return;
			}else if(newPosition==rows*cols){
				order(p2);
				p2.setValue(newPosition);
			}else{
			p2.setValue(newPosition);
			}
		}else if(turno==3){
			int dado=rollDice();
			System.out.println("Niceeee :D, You got a "+dado);
			int posicion=p3.getValueP();
			int newPosition=posicion+dado;
			if(newPosition>rows*cols){
				System.out.println("Sorry, you got a number superior to the limit");
				return;
			}else if(newPosition==rows*cols){
				order(p3);
				p3.setValue(newPosition);
			}else{
			p3.setValue(newPosition);
			}

			
		}
	}

	
	public int rollDice() {
		int dado=dice.nextInt(6) + 1;
        return dado;
    }

	
	//*  */
	public void addSnakes(int numSnakes) {
		if (numSnakes == 0) {
			return;
		}
		
		addSnake(head);
		
		addSnakes(numSnakes - 1);
	}

	private void addSnake(Node current) {
		
		if (current == null) {
			return;
		}
		
		
		Snake newSnake = new Snake(0, 0);
		newSnake.setHead(random().getHeadRandom());
		newSnake.setTail(random().getTailRandom());
		
		if (newSnake.getHead() == current.getValue()) {
			newSnake.setHeadNode(current);
		}
		
		if (newSnake.getTail() == current.getValue()) {
			newSnake.setTailNode(current);
		}
		
		addSnake(current.getNext());
	}
	

	//**  */

	public void addLadders(int ladder) {
		Ladder newLadder = new Ladder(0, 0);
		newLadder.setHead(ladder);
		addLadders(newLadder, head);
	}
	
	private void addLadders(Ladder ladder, Node current) {
		if (ladder == null || current == null) {
			return; // do nothing if either snake or current is null
		}
		if (ladder.getHead() == 0) {
			ladder.setHead(current.getValue()); // set the head of the snake to current if it is not already set
			return;
		}
		if (ladder.getHead() == current.getValue()) {
			ladder.setHead(current.getValue());
			return;
		}
		addLadders(ladder, current.getNext());
	}

	//**  */

	public Randoms random(){

		Randoms rand=new Randoms(0,0);
		int limit=rows*cols;

		int headrandom = random.nextInt(limit);
		int tailrandom = random.nextInt(limit);
		
		if(tailrandom>=headrandom){
			random();
		}else if(tailrandom==0){
			random();
		}else if(headrandom==tailrandom){
			random();
		}else if(headrandom+tailrandom>(limit*0.4)){
			random();
		}
		else{
			rand=new Randoms(headrandom,tailrandom);
		
		}
		return rand;
		
		
	}
	public boolean gameFinished(){
		boolean endgame=false;
		if(p1.getValueP()==rows*cols&&p2.getValueP()==rows*cols&&p3.getValueP()==rows*cols){
			endgame=true;
		}
		return endgame;
	}
	
	public void order(Player win){
		
		if (position1==0){
			position1=win.getNum();
		}else if(position2==0){
			position2=win.getNum();
		}else if(position3==0){
			position3=win.getNum();
		}else{return;}
	}
	public String returnPositions(){
		int[] posiciones=new int[3];
		posiciones[0]=position1;
		posiciones[1]=position2;
		posiciones[2]=position3;
		String msj="Los Ganadores en orden son:\n Primer lugar, Jugador "+posiciones[0]+"\n Segundo lugar, jugador "+posiciones[1]+"\n Tercer lugar, jugador "+posiciones[2];
		return msj;
	}
	


	//* */

	//*Getters and Setters */

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}	

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

    public int getSize() {
        return rows*cols;
    }
	public Player getPlayer1(){
		return p1;
	}
	public Player getPlayer2(){
		return p2;
	}
	public Player getPlayer3(){
		return p3;
	}

	
	





}