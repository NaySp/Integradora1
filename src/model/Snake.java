package model;

public class Snake {

    private int head;
    private int tail;
    private int id;
    public Snake(int head,int tail){
        this.head=head;
        this.tail=tail;

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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

}

    

