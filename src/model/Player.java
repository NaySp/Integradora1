package model;

public class Player extends Node {

    private char token;
    private Player head;


    public Player(int i) {
        super(0);
        this.head = null;

    }


    public void addPlayer(Player node) {
        if (head == null) {
            this.head = node;
            node.setNext(node);
        } else {
            addPlayer(node, head);
        }
    }

    public void addPlayer(Player node, Player current) {
        if (current.getNext() == head) {
            current.setNext(node);
            current.getNext().setNext(head);
        } else {
            addPlayer(node, (Player) current.getNext());
        }
    }

    public boolean validatePlayer(char id) {
        return validatePlayer(id, head, 0);
    }

    public boolean validatePlayer(char id, Player current, int i) {
        if (head == null) {
            return false;
        }
        if (i == 3) {
            return false;
        }
        if (current.getToken() == id) {
            return true;
        } else {
            return validatePlayer(id, (Player) current.getNext(), ++i);
        }
    }

    public Player getHead() {
        return head;
    }

    public void setHead(Player head) {
        this.head = head;
    }

    public char getToken() {
        return token;
    }



    public void setCurrent(Node node) { }


    public Node getCurrent() {
        return null;
    }


}
