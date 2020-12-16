/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.model.MoviesOnDemand;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    
    public Movie addMovie(int accountID, int movieID){
        boolean childAccount = false;
        Account a = new Account();
        a = CustomerService.getAccountByID(accountID);
        childAccount = Account.isChild();
        
        boolean childFriendlyMovie = false;
        Movie m = getOneMovie(accountID, movieID);
        childFriendlyMovie = Movie.isChildFriendly();
        
        if (childAccount == true && childFriendlyMovie == false){
            m = null;
        }
        else {
            List<Movie> movieList = a.getMovieList();
            movieList.add(m);
        }
        return m;
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
       
    public String removeMovie(int accountID, int movieID){
        Movie m = getOneMovie(accountID, movieID);
        Account a = CustomerService.getAccountByID(accountID);
        List<Movie> movieList = a.getMovieList();
        movieList.remove(movieID);
        return "Movie successfully added";
        //Response: Code 200 / 404 ‘Movie successfully removed’
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
//    
    public ArrayList<Movie> getMoviesInAccount(int accountID){
        Account a = new Account();
        ArrayList<Movie> movieList = a.getMovieList();
        return movieList;
    }
    
    public Movie getOneMovie(int accountID, int movieID){
        Movie found = null;
        Account a = new Account();
        List<Movie> movieList = a.getMovieList();
        for (Movie m : movieList) {
            if (m.getMovieID() == movieID) {
                found = m;
            } 
        }
        return found;
    }
    
    public String transferMovie(int fromAccountID, int toAccountID, int movieID){
        removeMovie(fromAccountID, movieID);
        addMovie(toAccountID, movieID);
        return "transferred successfully";
        //Response: Code 200 / 404 ‘Movie successfully removed’
    }
    
    public String markAsRecommendedMovie(int accountID, int movieID){
        Movie m = getOneMovie(accountID, movieID);
        m.setRecommended (true);
        return "successfully added to recommended";
    }
    
    public String markAsWatchedMovie(int accountID, int movieID){
        Movie m = getOneMovie(accountID, movieID);
        m.setWatched (true);
        return "successfully added to watched";
    }
    
    //EXAMPLE OF FILTERING
    /*public List<Message> getSearchMessages(String message, String author) {
        List<Message> matcheslist = new ArrayList<>();
        
        for (Message q: getAllMessages()) {
            if ((message == null || q.getMessage().equals(message)) 
                   && (author == null || q.getAuthor().equals(author))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
*/
    
}
