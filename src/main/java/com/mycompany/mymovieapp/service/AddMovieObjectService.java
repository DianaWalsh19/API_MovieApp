
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.*;
import java.util.ArrayList;
import java.util.Map;

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
        
        public Account addMovie(AddMovieObject amo){
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
            a = null;
            message = "This is a child account and not child-friendly movies cannot be added";
            System.out.println("We reached the end of the method");//for testing
            return a;
        }
        else {
            m.setWatched(false);
            Map<Integer, Movie> accountMovies = allAccounts.get(accountID).getMoviesInAccount();
            accountMovies.put(movieID, m);
            
            System.out.println("We reached the end of the method");//for testing
            return a;
        }
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    } 
}
