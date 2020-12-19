/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    
    private int accountID;
    private int customID;
    private String userName;
    private String password;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private static boolean child;

    public Account() {
    }

    public Account(int customID, String userName, String password, boolean child) {
        this.customID = customID;
        this.userName = userName;
        this.password = password;
        this.child = child;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public static boolean isChild() {
        return child;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

}
