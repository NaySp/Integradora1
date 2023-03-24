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
	

	public String printBoard() {
        String msj = "";
        return printBoard(this.tail, msj);
    }

    public String printBoard(Node current, String msj) {
        if(current == null) return msj;
        if (head.getNext() == tail) {
            return getString(head);
        }
        if (current == head&&this.cols!=1) {
            msj += "";
            return msj;
        } else if (cols % 2 == 0) {
            if (current.getValue() % (cols * 2) == 0)
                msj += printInOrder(current) + "\n";
            else if (current.getValue() % cols == 0)
                msj += printReverse(current) + "\n";
        } else {
            if (current.getValue() % cols == 0) {
                if (current.getValue() % 2 == 0)
                    msj += printInOrder(current) + "\n";
                else
                    msj += printReverse(current) + "\n";
            }
        }
        return printBoard(current.getPrevious(), msj);
    }

    public String printReverse(Node current) {
        if(current==null) return "";
        if (current == head || current.getPrevious().getValue() % cols == 0) {
            return getString(current);
        } else {
            return printReverse(current.getPrevious()) + getString(current);
        }

    }

    public String printInOrder(Node current) {
        if(current == null) return "";
        if (current == head || current.getPrevious().getValue() % cols == 0) {
            return getString(current);
        } else {
            return getString(current) + printInOrder(current.getPrevious());
        }

    }

    private String getString(Node current) {
        if (current.getMessage().length() == 6) {
            return "[" + current.getMessage() + "]";
        }
        if (current.getMessage().length() == 5) {
            return "[ " + current.getMessage() + "]";
        }
        if (current.getMessage().length() == 4) {
            return "[ " + current.getMessage() + " ]";
        }
        if (current.getMessage().length() == 3) {
            return "[ " + current.getMessage() + "  ]";
        }
        if (current.getMessage().length() == 2) {
            return "[ " + current.getMessage() + "   ]";
        }
        if (current.getMessage().length() == 1) {
            return "[ " + current.getMessage() + "    ]";
        } else {
            return "[ " + current.getMessage() + "     ]";
        }
    }
	
	
	//**  */


	public void configPlayers(Node current) {
		current = head;
		p1.setValue(current.getValue());
		current.setPlayer(p1);
		current = current.getNext();
		p2.setValue(current.getValue());
		current.setPlayer(p2);
		current = current.getNext();
		p3.setValue(current.getValue());
		current.setPlayer(p3);
	}




	//*  */


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