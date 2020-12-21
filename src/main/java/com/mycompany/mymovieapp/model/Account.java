/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Account {
    
    private int accountID;
    private int custID;
    private String userName;
    private String password;
    //private ArrayList<Movie> movieList = new ArrayList<>();
    private Map<Integer, Movie> moviesInAccount = new HashMap<>();
    private static boolean child;

    public Account() {
    }

    public Account(int accountID, String userName, String password, boolean child, int custID) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.child = child;
        this.custID = custID;
    }
    
    public int getCustID() {
        return custID;
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

    /*
    public ArrayList<Movie> getMovieList() {
        return movieList;
    
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
    }*/
    
    public Map<Integer, Movie> getMoviesInAccount(){
        return moviesInAccount;
    }

    public void setMoviesInAccount(Map<Integer, Movie> moviesInAccount){
        this.moviesInAccount = moviesInAccount;
    }

    public static boolean isChild() {
        return child;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

}
