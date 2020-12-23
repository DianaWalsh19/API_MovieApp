/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.AddMovieObject;
import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import static com.mycompany.mymovieapp.model.MoviesOnDemand.allMovies;
import java.util.ArrayList;
import java.util.Map;
import static org.eclipse.persistence.expressions.ExpressionOperator.as;

/**
 *
 * @author Bebhin
 */
public class AddMovieObjectService {
    
    MoviesOnDemand mod = new MoviesOnDemand();
    
    private Map<Integer, Customer> allCustomers = mod.getAllCustomers();
    private Map<Integer, Account> allAccounts = MoviesOnDemand.getAllAccounts();
    ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
    private Map<Integer, Movie> allMovies = MoviesOnDemand.getAllMovies();
    ArrayList<Movie> allMoviesList = new ArrayList<>(allMovies.values());
    AccountService as = new AccountService();
        
        public String addMovie(AddMovieObject amo){
        //System.out.println("Add movie call");//for testing
        
        String message;
        //boolean childAccount = false;
        //boolean childFriendlyMovie = false;
        int custID = amo.getCustID();
        int accountID = amo.getAccountID();
        System.out.println("Account ID: "+accountID);
        int movieID = amo.getMovieID();
        //System.out.println("Customer ID: "+ custID +" - Account ID: " + accountID + " - movieID: " + movieID);//for testing
        
        Movie m = allMovies.get(movieID);
        
        //Account a = new Account();
        Account a = as.getAccountByID(custID, accountID);
        boolean childAccount = a.isChild();
        System.out.println(childAccount);
        
        boolean childFriendlyMovie = Movie.isChildFriendly();
        System.out.println(childFriendlyMovie);
        
        if (childAccount == true && childFriendlyMovie == false){
            message = "This is a child account and not child-friendly movies cannot be added";
            System.out.println("We reached the end of the method");//for testing
            return message;
        }
        else {
            m.setWatched(false);
            Map<Integer, Movie> accountMovies = allAccounts.get(accountID).getMoviesInAccount();
            accountMovies.put(movieID, m);
            
            System.out.println("We reached the end of the method");//for testing
            return "Movie successfully added";
        }
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    } 
}
