package model;

public class Board {
	
	private Node head; 
	private Node tail; 
	
	
	private int rows;
	private int cols;

	private Player p1=new Player("*");
	private Player p2=new Player("+");
	private Player p3=new Player("?");

	public Board(int rows, int cols) {
		this.head = null;
		this.tail = null;
		this.rows = rows;
		this.cols = cols;
		
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
	
	private void reverse(Node current, int cols, int count) {
		if (current == null || count > cols) {
			return;
		}
		reverse(current.getPrevious(), cols, count + 1);
		System.out.print("[ " + current.getValue() + " ]");
	}

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
	


	private void reversePrint(Node current, int cols) {
		if (current == null) {
			return;
		}
		reversePrint(current.getNext(), cols);
		System.out.print("[ " + current.getValue() + " ] ");
	}
	
	
	public void configPlayers(Node current){
		current=head;
		p1.setValue(current.getValue());
		p2.setValue(current.getValue());
		p3.setValue(current.getValue());
		

	}

	
	//*  */

	public void addSnakes(){
		addSnakes(null, head);
	}
	
	private void addSnakes(Snake snake, Node current) {
		if (snake == null || current == null) {
			return; // do nothing if either snake or current is null
		}
		if (snake.getHead() == 0) {
			snake.setHead(current.getValue()); // set the head of the snake to current if it is not already set
			return;
		}
		
		if (snake.getHead() == current.getValue()) {
			snake.setHead(current.getValue()); // actualizamos la cabeza de la serpiente con el nodo actual
			return;
		}
		addSnakes(snake, current.getNext());
	}
	
	public void addLadders(){
		addLadders(null, head);
	}

	private void addLadders(Ladder ladder, Node current) {
		if (ladder == null || current == null) {
			return; // do nothing if either snake or current is null
		}
		if (ladder.getHead() == 0) {

			ladder.setHead(current.getValue()); // set the head of the snake to current if it is not already set
			return;
		}
		if (ladder.getTail() == current.getValue()) {
			ladder.setHead(current.getValue());
			return;
		}
		addLadders(ladder, current.getNext());
	}

	//** */

	



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

	


}