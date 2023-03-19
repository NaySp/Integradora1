package model;
import java.util.Random;

public class Ladder {
    public static Random random=new Random();
    private int head;
    private int tail;
    public Ladder(int head,int tail){
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
    }
=======
	public void setTail(int tail) {
		this.tail = tail;
	}
>>>>>>> de28511 (Cambios Adds)
}
