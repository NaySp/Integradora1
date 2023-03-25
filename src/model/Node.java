package model;

public class Node {

    private int value;
    private Player player;
    private Node next;
    private Node previous;
	private String msj;

    public Node(int value) {
        this.value = value;
		this.msj = msj+"";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

	public String getMessage(){
		return msj;
	}

	public void setMessage(String msj) {
        this.msj = msj;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }


    //**  */
    

}
