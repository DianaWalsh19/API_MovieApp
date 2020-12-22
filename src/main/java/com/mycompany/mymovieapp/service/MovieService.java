/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.service.AccountService;
import com.mycompany.mymovieapp.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieService {
    
    MoviesOnDemand mod = new MoviesOnDemand();
    
    private Map<Integer, Customer> allCustomers = mod.getAllCustomers();
    private Map<Integer, Account> allAccounts = MoviesOnDemand.getAllAccounts();
    ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
    private Map<Integer, Movie> allMovies = MoviesOnDemand.getAllMovies();
    ArrayList<Movie> allMoviesList = new ArrayList<>(allMovies.values());
    AccountService as = new AccountService();
    
    public ArrayList<Movie> getMoviesInAccount(int custID, int accountID){
        Customer c = allCustomers.get(custID);
        Map<Integer, Account> customerAccounts = c.getCustomerAccounts();
        Account a = customerAccounts.get(accountID);
        Map<Integer, Movie> accountMovies = a.getMoviesInAccount();
        Set<Map.Entry<Integer, Movie> > entrySet = accountMovies.entrySet(); 
        ArrayList<Movie> listOfAccountMovies = accountMovies.values().stream().collect( 
                Collectors.toCollection(ArrayList::new)) ;
        return listOfAccountMovies;
    }
    
    public Movie getOneMovieInAccount(int custID, int accountID, int movieID){
        Account a = allAccounts.get(accountID);
        Map<Integer, Movie> accountMovies = a.getMoviesInAccount();
        Movie m = accountMovies.get(movieID);
        return m;
    }
    
    public Movie addMovie(int custID, int accountID, Movie m){
        boolean childAccount = false;
        Account a = new Account();
        a = as.getAccountByID(custID, accountID);
        childAccount = Account.isChild();
        
        boolean childFriendlyMovie = false;
        int movieID = m.getMovieID();
        m = allMovies.get(movieID);
        childFriendlyMovie = Movie.isChildFriendly();
        
        if (childAccount == true && childFriendlyMovie == false){
            m = null;
        }
        else {
            m.setWatched(false);
            Map<Integer, Movie> accountMovies = a.getMoviesInAccount();
            accountMovies.put(movieID, m);
        }
        return m;
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    } 
    
    public String removeMovie(int custID, int accountID, int movieID){
        Account a = new Account();
        a = as.getAccountByID(custID, accountID);
        Map<Integer, Movie> accountMovies = a.getMoviesInAccount();
        accountMovies.remove(movieID);
        return "Movie successfully deleted";
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
    
    /*//Proposal for transferMovie
    
    public String transferMovie(int custID, int accountID, int movieID, int newAccountID){
        String message;
        Customer c = allCustomers.get(custID);
        Map<Integer, Account> customerAccounts = c.getCustomerAccounts();
        Account from = customerAccounts.get(accountID);
        Map<Integer, Movie> fromAccountMovies = from.getMoviesInAccount();
        
        Account to = customerAccounts.get(newAccountID);
        Map<Integer, Movie> toAccountMovies = to.getMoviesInAccount();
        
        if (fromAccountMovies.containsKey(movieID) == true){
            removeMovie(custID, accountID, movieID);
            addMovie(custID, newAccountID, movieID);
            message = "Movie successfully transferred";
        }else{
            message = "Movie could not be transferred";
        }
        return message;
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }*/
    
    /*public String transferMovie(int custID, int fromAccountID, int movieID, Account a){
        removeMovie(fromAccountID, movieID);
        //should have response if movie not on account, 404 resource not found. 
        addMovie(a.getAccountID(), movieID);
        return "Code 200 - transferred successfully";
        //needs error msg 404 resource not found
        //Response: Code 200 / 404 ‘Movie successfully removed’
    } */
    
    
    /*
    public List<Movie> getRecommended(int accountID){
            return list;
    }
        
    public Movie getOneMovie(int movieID){
        Movie found = null;

        for (Movie m : list) {
            if (m.getMovieID() == movieID) {
                found = m;
            } 
        }
        return found;
    }
    
 //Commenting this method out, see issue #9 in GitHub
 /*  
    public String markAsRecommendedMovie(int movieID){
        m = Movie.getMovieID(movieID);
        m.setRecommended (true);
        return "successfully added to recommended";
    }
   */
}