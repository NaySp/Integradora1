package model;

public class Player {
    private int value=0;
    private String token;
   

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


    
}