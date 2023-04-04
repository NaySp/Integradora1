package model;

public class Snake {

    private int head;
    private int tail;
    private Node headNode;
    private Node tailNode;


    private int id;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
     
    }
    public void setHeadNode(Node node) {
        this.headNode = node;
    }
    
    public void setTailNode(Node node) {
        this.tailNode = node;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}