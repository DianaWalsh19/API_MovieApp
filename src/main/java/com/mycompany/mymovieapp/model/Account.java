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
    //private int custID;
    private String userName;
    private String password;
    private static boolean child;
    private Map<Integer, Movie> moviesInAccount = new HashMap<>();
    //private List<Movie> moviesInAccount;

    public Account() {
    }
    
    public Account(int accountID, String userName, String password, boolean child, Map<Integer, Movie> moviesInAccount) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.child = child;
        //this.custID = custID;
        this.moviesInAccount = moviesInAccount;
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

    public static boolean isChild() {
        return child;
    }

    public Map<Integer, Movie> getMoviesInAccount() {
        return moviesInAccount;
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

    public static void setChild(boolean child) {
        Account.child = child;
    }

    public void setMoviesInAccount(Map<Integer, Movie> moviesInAccount) {
        this.moviesInAccount = moviesInAccount;
    }
    
}
