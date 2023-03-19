package model;

public class Board {

	private Node head;
	private Node tail;


	private int rows;
	private int cols;


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

		if (colCount % 2 == 1) {
			reverse(current, cols, 1);
		} else {
			System.out.print("[ " + current.getValue() + " ] ");
			colCount++;
		}

		printBoard(current.getPrevious(), rows, cols, count + 1); // Avanzar al nodo anterior
	}

	private void reverse(Node current, int cols, int count) {
		if (current == null || count > cols) {
			return;
		}
		reverse(current.getPrevious(), cols, count + 1);
		System.out.print("[ " + current.getValue() + " ] ");
	}



	private void reversePrint(Node current, int cols) {
		if (current == null) {
			return;
		}
		reversePrint(current.getNext(), cols);
		System.out.print("[ " + current.getValue() + " ] ");
	}



	public Node search(int goal){
		return search(goal, this.head);
	}

	private Node search(int goal, Node current){
		// Caso base
		if(current == null){
			return null;
		}

		// caso borde
		if(goal == head.getValue() && current.equals(this.head)){
			return this.head;
		}

		if(goal == tail.getValue() && current.equals(this.tail)){
			return this.tail;
		}
		if(goal == current.getValue()){
			return current;
		}
		if(current == this.tail && goal != this.tail.getValue()){
			return null;
		}

		return search(goal, current.getNext());
	}

	// triger de la función
	public void delete(int goal){
		delete(goal, head);
	}

	private void delete(int goal, Node current){
		//Casos base
		if(current == null){
			return;
		}
		//Caso borde: eliminar la cabeza
		if(head.getValue() == goal){
			head = current.getNext();
			return;
		}
		// Segundo caso borde elimina la cola
		if(tail.getValue() == goal && tail == current){
			current.getPrevious().setNext(null); //  previous.setNext(null);
			tail = current.getPrevious(); // previous;
			return;
		}
		// Caso intermedio
		if(current.getValue() == goal){
			current.getPrevious().setNext(current.getNext()); // previous.setNext(current.getNext());
			return;
		}
		//Llamado recursivo
		delete(goal, current.getNext());
		//      ^       ^           ^
		//      |       |           |
		// objetivo  previous    current
	}

<<<<<<< HEAD
<<<<<<< HEAD
	//*  */
	public void addSnakes(Snake snake, Node current) {
		if (snake.getHead().getValue() == current.getValue()) {
			current=snake.getHead();
			return;
		}
		addSnakes(snake, current.getNext());
	}
	public void addLadders(Ladder ladder, Node current) {
		if (ladder.getTail().getValue() == current.getValue()) {
			current=ladder.getTail();
			return;
		}
		addLadders(ladder, current.getNext());
	}


=======
=======
>>>>>>> de28511 (Cambios Adds)
	public void addSnake(Node node, int head, int tail, int id) {
        if (node == null) {
            return;
        }
        if (node.getValue() == head) {
            Node endNode = getNode(head + 1, node.getNext(), tail);
            node.setNext(endNode);
        } else {
            addSnake(node.getNext(), head, tail, id);
        }
    }
  
	public void addLadder(Node node, int head, int tail, int id) {
        if (node == null) {
            return;
        }
        if (node.getValue() == head) {
            Node endNode = getNode(head + 1, node.getNext(), tail);
            node.setNext(endNode);
        } else {
            addSnake(node.getNext(), head, tail, id);
        }
    }
	private Node getNode(int current, Node node, int target) {
        if (node == null) {
            return null;
        }
        if (current == target) {
            return node;
        }
        return getNode(current + 1, node.getNext(), target);
    }
<<<<<<< HEAD
>>>>>>> de28511 (Cambios Adds)
=======
>>>>>>> de28511 (Cambios Adds)
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