package model;
import java.util.Random;

public class Ladder {
    
    public static Random random=new Random();
    private int head;
    private int tail;
    private int id;
    

    public Ladder(int head,int tail){
        this.head=head;
        this.tail=tail;
       
    }
    public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

    public int getTail(){
        return tail;
    }

	public void setTail(int tail) {
		this.tail = tail;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}