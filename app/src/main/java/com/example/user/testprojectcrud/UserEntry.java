package com.example.user.testprojectcrud;

/**
 * Created by user on 7/28/2017.
 */

public class UserEntry {

    private String info;

    public UserEntry(){
        info ="";
    }

    public UserEntry(String message){
        info = message;
    }

    public String getEntry(){
        return info;
    }

    public void setEntry(String message){

        info = message;
    }

}
