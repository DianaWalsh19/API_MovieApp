
package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Account {
    
    private int accountID;
    private String userName;
    private String password;
    private boolean child;
    
    private Map<Integer, Movie> moviesInAccount = new HashMap<>();

    public Account() {
    }
    
    public Account(int accountID, String userName, String password, boolean child, Map<Integer, Movie> moviesInAccount) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.child = child;
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

    public boolean isChild() {
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

    public void setChild(boolean child) {
        this.child = child;
    }

    public void setMoviesInAccount(Map<Integer, Movie> moviesInAccount) {
        this.moviesInAccount = moviesInAccount;
    }
    
    @Override
    public String toString(){
        return "\nAccount: \n {"+"accountID: "+accountID+ ",\n name: "+userName+"\n password: "+password+"}";
    }
    
}
