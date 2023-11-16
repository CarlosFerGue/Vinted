package com.example.vinted.login_user.model.data;

import com.example.vinted.beans.User;

import java.util.ArrayList;

public class MyData {
    private String message;

    private ArrayList<User> lstUsers;

    public String getMessage(){
        return message;
    }

    public ArrayList<User> getLstUsers(){
        return lstUsers;
    }

    public void setLstUsers(ArrayList<User> lstUsers){
        this.lstUsers = lstUsers;
    }
}
