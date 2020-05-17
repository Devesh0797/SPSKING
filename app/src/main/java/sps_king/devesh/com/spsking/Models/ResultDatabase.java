package sps_king.devesh.com.spsking.Models;

public class ResultDatabase {

    String Player1;
    String Player2;


    public ResultDatabase(){

    }

    public ResultDatabase(String Player1,String Player2) {
        this.Player1 = Player1;
        this.Player2=Player2;


    }

    public String getPlayer1() {
        return Player1;
    }
    public String getPlayer2() {
        return Player2;
    }


}
