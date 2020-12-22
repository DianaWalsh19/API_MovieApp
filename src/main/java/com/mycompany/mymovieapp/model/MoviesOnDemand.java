/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.mymovieapp.model.*;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class MoviesOnDemand {
    
    public static Map<Integer, Customer> allCustomers = new HashMap<>();
    public static Map<Integer, Account> allAccounts = new HashMap<>();
    public static Map<Integer, Movie> allMovies = new HashMap<>();
    
    public static Map<Integer, Account> accCust1 = new HashMap<>();
    public static Map<Integer, Account> accCust2 = new HashMap<>();
    public static Map<Integer, Account> accCust3 = new HashMap<>();
    
    public static Map<Integer, Movie> moviesAcc1 = new HashMap<>();
    public static Map<Integer, Movie> moviesAcc2 = new HashMap<>();
    public static Map<Integer, Movie> moviesAcc3 = new HashMap<>();
    public static Map<Integer, Movie> moviesAcc4 = new HashMap<>();
    public static Map<Integer, Movie> moviesAcc5 = new HashMap<>();
    public static Map<Integer, Movie> moviesAcc6 = new HashMap<>();
    
    
    public static boolean inIt = true;
    
    public MoviesOnDemand(){
        
        if (inIt) {
            
            Customer c1 = new Customer(1, "Peter Mark Cust1", "123 Crescent View, Dublin", "peter@petermark.com", accCust1);
            Customer c2 = new Customer(2, "Mary Smith Cust2", "123 New Avenue, Waterford", "mary@gmail.com", accCust2);
            Customer c3 = new Customer(3, "Peter D Cust3", "123 Magic Road, Kilkenny", "peter@anotherpeter.com", accCust3);
        
            allCustomers.put(c1.getCustID(), c1);
            allCustomers.put(c2.getCustID(), c2);
            allCustomers.put(c3.getCustID(), c3);
            
            Movie m1 = new Movie(1, "Raiders of the Lost Ark", 1981, false, false, "1981 American action-adventure film directed by Steven Spielberg and written by Lawrence Kasdan based on a story by George Lucas and Philip Kaufman.", false);
            Movie m2 = new Movie(2, "The Other Guys", 2010, false, false, "2010 American buddy cop action comedy film directed by Adam McKay, who co-wrote it with Chris Henchy.", false);
            Movie m3 = new Movie(3, "Jurassic Park", 1993, false, false, "1993 American science fiction adventure film directed by Steven Spielberg and produced by Kathleen Kennedy and Gerald R. Molen.", false);
            
            allMovies.put(m1.getMovieID(), m1);
            allMovies.put(m2.getMovieID(), m2);
            allMovies.put(m3.getMovieID(), m3);
            
            moviesAcc1.put(m1.getMovieID(), m1);
            moviesAcc1.put(m2.getMovieID(), m2);
            
            moviesAcc2.put(m3.getMovieID(), m3);
            moviesAcc2.put(m1.getMovieID(), m1);
            
            moviesAcc3.put(m2.getMovieID(), m2);
            moviesAcc3.put(m3.getMovieID(), m3);
            
            moviesAcc4.put(m1.getMovieID(), m1);
            moviesAcc4.put(m2.getMovieID(), m2);
            
            moviesAcc5.put(m3.getMovieID(), m3);
            moviesAcc5.put(m1.getMovieID(), m1);
            
            moviesAcc6.put(m2.getMovieID(), m2);
            moviesAcc6.put(m3.getMovieID(), m3);
            
            
            Account a1 = new Account (1, "Father in Account 1", "password Father 1", false, moviesAcc1);
            Account a2 = new Account (2, "Mother in Account 1", "password Mother 1", false, moviesAcc2);
            Account a3 = new Account (3, "Child in Account 1", "password Child 1", true, moviesAcc3);
            Account a4 = new Account (4, "Mother in Account 2", "password Mother 2", false, moviesAcc4);
            Account a5 = new Account (5, "Uncle in Account 3", "password Uncle 3", false, moviesAcc5);
            Account a6 = new Account (6, "Niece in Account 3", "password Niece 3", true, moviesAcc6);

            allAccounts.put(a1.getAccountID(), a1);
            allAccounts.put(a2.getAccountID(), a2);
            allAccounts.put(a3.getAccountID(), a3);
            allAccounts.put(a4.getAccountID(), a4);
            allAccounts.put(a5.getAccountID(), a5);
            allAccounts.put(a6.getAccountID(), a6);
            
            
            accCust1.put(a1.getAccountID(), a1);
            accCust1.put(a2.getAccountID(), a2);
            accCust1.put(a3.getAccountID(), a3);
            
            accCust2.put(a4.getAccountID(), a4);
            
            accCust3.put(a5.getAccountID(), a5);
            accCust1.put(a6.getAccountID(), a6);
            
            inIt = false;
        }
    }
   
    public static Map<Integer, Customer> getAllCustomers(){
        return allCustomers;
    }
    
    public static Map<Integer, Account> getAllAccounts(){
        return allAccounts;
    }
    
    public static Map<Integer, Movie> getAllMovies(){
        return allMovies;
    }

    /*
    public void setAllAccounts(Map<Integer, Account> allAccounts){
       this.allAccounts = allAccounts;
    }*/
}