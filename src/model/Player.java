package model;

public class Player {

    private int num=0;
    private int value=0;
    private String token;
   
    private double score;

    public Player(String token){
        this.token = token;
    }

    public int getValueP(){
        return value;
    }

    public void setValue(int value){
        this.value=value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Player getHead() {
        return null;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    
}