package model;
import java.util.Random;

public class Snake {
    public static Random random=new Random();
    private Node head;
    private Node tail;
    public Snake(int head,int tail){
        this.head=new Node(head);
        this.tail=new Node(tail);
        this.head.setNext(this.tail);
    }
    public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

   public Node getTail(){
        return tail;
   }

	public void setTail(Node tail) {
		this.tail = tail;
	}
}

    