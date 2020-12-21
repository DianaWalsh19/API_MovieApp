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

public class MoviesOnDemand {
    
    private static Map<Integer, Customer> allCustomers = new HashMap<>();
    private static Map<Integer, Account> allAccounts = new HashMap<>();
    private static Map<Integer, Movie> allMovies = new HashMap<>();
    
    public static Map<Integer, Customer> getAllCustomers(){
        return allCustomers;
    }
    
    public static Map<Integer, Account> getAllAccounts(){
        return allAccounts;
    }
    
    public static Map<Integer, Movie> getAllMovies(){
        return allMovies;
    }
    
    public void setAllAccounts(Map<Integer, Account> allAccounts){
       this.allAccounts = allAccounts;
    }
    
    /*
    private static ArrayList<Customer> allCustomers = allCustomers = new ArrayList<Customer>();;
    private static ArrayList<Movie> allMovies = allMovies = new ArrayList<Movie>();
    //allAccounts stores all accounts in the app, regardless of customer association. 
    //Used in the generation of unique account ID´s (CustomerService class - Add Account method)
    private static ArrayList<Account> allAccounts = allAccounts = new ArrayList<Account>();
    //This list stores only the accounts associated with a specfic Customer
    private static ArrayList<Account> accountList = accountList = new ArrayList<Account>();
    
    public static ArrayList<Customer> getCustomerList() {
        allCustomers.add(new Customer(1, "Peter Mark", "123 Crescent View, Dublin", "peter@petermark.com", accountList));
        allCustomers.add(new Customer(2, "Mary Smith", "123 New Avenue, Waterford", "mary@gmail.com",accountList));
        allCustomers.add(new Customer(3, "Peter D", "123 Magic Road, Kilkenny", "peter@anotherpeter.com",accountList));
        return allCustomers;
    }
    
    public static ArrayList<Account> getAccountList() {
        allAccounts.add(new Account(1, "Father", "password1", false));
        allAccounts.add(new Account(1, "Mother", "password2", false));
        allAccounts.add(new Account(1, "Child", "password3", true));
        allAccounts.add(new Account(2, "Father - Account 2", "password1", false));
        allAccounts.add(new Account(2, "Customer's 2 child", "password3", true));
        allAccounts.add(new Account(3, "Uncle", "password3", true));
        return allAccounts;
    }

    public static ArrayList<Movie> getAllMovies() {
        allMovies.add(new Movie(1, "Raiders of the Lost Ark", 1981, false, false, "1981 American action-adventure film directed by Steven Spielberg and written by Lawrence Kasdan based on a story by George Lucas and Philip Kaufman.", false));
        allMovies.add(new Movie(2, "The Other Guys", 2010, false, false, "2010 American buddy cop action comedy film directed by Adam McKay, who co-wrote it with Chris Henchy.", false));
        allMovies.add(new Movie(3, "Jurassic Park", 1993, false, false, "1993 American science fiction adventure film directed by Steven Spielberg and produced by Kathleen Kennedy and Gerald R. Molen.", false));
        return allMovies;
    }

    */
}