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
        //This method checks first if the account is a child one. 
        //If so, the movie must be childFriendly to be added to the list
        boolean childAccount = false;
        Account a = new Account();
        a = CustomerService.getAccountByID(accountID);
        childAccount = Account.isChild();
        
        boolean childFriendlyMovie = false;
        Movie m = getOneMovie(movieID);
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
       
    public String removeMovie(){
        //add movie to movieList by ID
        return "Movie successfully added";
        //Response: Code 200 / 404 ‘Movie successfully removed’
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
    
    public ArrayList<Movie> getAllMovies(){
        //Movie m1 = new Movie(001, "Jurassic Park", 1900, false, true, "Movie about dinasaurs killing people", false);
        return movieList;
    }
//    
    public Movie getOneMovie(int id){
        return movieList.get(id);
    }
    
    public String transferMovie(){
        //removeMovie() from accountID as param
        //msg to say if successful, method stops here if unnsuccessful
        //resource not found error
        //addMovie() to accountID from resource content
        //check for child-friendly
        //msg to say if successfully transferred
        //revert watched to 'false'
        return "transferred successfully";
        //Response: Code 200 / 404 ‘Movie successfully removed’
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
