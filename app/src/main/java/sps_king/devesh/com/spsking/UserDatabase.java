package sps_king.devesh.com.spsking;

import android.media.Image;

public class UserDatabase {

    String name;
    String userID;
    String age;
    String Image;



    public UserDatabase(){

    }
    public UserDatabase(String Name,String UserID,String Age) {
        this.name = Name;
        this.userID=UserID;
        this.age=Age;


    }

    public UserDatabase(String Name,String UserID,String Age,String Image) {
        this.name = Name;
        this.userID=UserID;
        this.age=Age;
        this.Image= Image;

    }



    public String getName() {
        return name;
    }
    public String getUserID() {
        return userID;
    }
    public String getAge(){
        return age;
    }
    public String getImage(){
        return Image;
    }






}
