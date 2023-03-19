package model;

public class Snake {

    private int head;
    private int tail;
    private int id;
    public Snake(int head,int tail){
        this.head=head;
        this.tail=tail;
    }
<<<<<<< HEAD
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail(){
=======
    public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

   public int getTail(){
>>>>>>> de28511 (Cambios Adds)
        return tail;
    }

<<<<<<< HEAD
    public void setTail(Node tail) {
        this.tail = tail;
=======
	public void setTail(int tail) {
		this.tail = tail;
	}
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
>>>>>>> de28511 (Cambios Adds)
    }
}

