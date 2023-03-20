package model;

public class Player {
    private int value;
    private String token;
   

    public Player(String token){
        this.token = token;
    }
    public int getValue(){
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


    
}