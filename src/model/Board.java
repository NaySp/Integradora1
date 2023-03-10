package model; 

public class Board {

	private Node head; 
	private Node tail; 
    private Node current;
	

	public Board() { }

	public void addLast(Node node){
		if(this.head == null && this.tail == null){
			this.tail = node; 
			this.head = node; 
		}
		else{
			this.tail.setNext(node);
			this.tail = node; 
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

	// Método de activación
	public void print(){
		print(this.head); 
	}

	private void print(Node current){

		// Casos base
		if(this.head == null && this.tail == null){
			System.out.println("La lista esta vacia");
			return; 
		}
		if(current == this.tail){
			System.out.println(current.getValue());
			return; 
		}
		System.out.println(current.getValue());
		print(current.getNext());

	}

	public String printList(){
		return printList(this.head, "[ "); 
	}

	private String printList(Node current, String msj){
		if(current == null){
			return msj + "]"; 
		}

		msj += current.getValue() + " "; 
		return printList(current.getNext(), msj); 
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

		return search(goal, current.getNext()); 
	}

	// triger de la función
	public void delete(int goal){
		delete(goal, null, head);
	}

	private void delete(int goal, Node previous, Node current){
		//Casos base
		if(current == null){
			return;
		}
		//Caso borde: eliminar la cabeza
		if(head.getValue() == goal){
			head = current.getNext();
			return;
		}
		// Segundo caso borde elimina la cabeza 
		if(tail.getValue() == goal && tail == current){
			previous.setNext(null);
			tail = previous;
			return;
		}
		// Caso intermedio 
		if(current.getValue() == goal){
			previous.setNext(current.getNext());
			return;
		}
		//Llamado recursivo
		delete(goal, current, current.getNext());
		//      ^       ^           ^
		//      |       |           | 
		// objetivo  previous    current
	}
	public void printBoard(int rows, int cols) {
		current = head;
        int row = 0;
        int col = 0;
        while (current != null) {
            if (col == 0) {
                for (int i = 0; i < cols; i++) {
                    System.out.print("+---");
                }
                System.out.println("+");
            }
            System.out.printf("| %d ", current.getValue());

            col++;
            if (col == cols) {
                System.out.println("|");
                col = 0;
                row++;
                for (int i = 0; i < cols; i++) {
                    System.out.print("+---");
                }
                System.out.println("+");
            }

            current = current.getNext();
        }
	}
}

