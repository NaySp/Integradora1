package model; 

public class Node {

	private int value;
	private Node next; 
	private Node previous; 

	public Node(int value) {
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString(){
		return "My value is: " + value; 
	}

    public Player[] getPlayers() {
        return null;
    }

    public Object getPlayer() {
        return null;
    }

}