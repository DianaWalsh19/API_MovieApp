/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.model;

/**
 *
 * @author Bebhin
 */
public class AddMovieObject {
    
    int custID;
    int movieID;
    int accountID;
    
    public AddMovieObject(){
    
    }

    public AddMovieObject(int custID, int movieID, int accountID) {
        this.custID = custID;
        this.movieID = movieID;
        this.accountID = accountID;
    }

    public int getCustID() {
        return custID;
    }

   

    public int getMovieID() {
        return movieID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
}
