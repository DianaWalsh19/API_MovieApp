/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.service.*;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    
    public static List<Movie> list = new ArrayList<>();
    
    /*
    public Movie addMovie(int accountID, int movieID){
        boolean childAccount = false;
        Account a = new Account();
        a = CustomerService.getAccountByID(accountID);
        childAccount = Account.isChild();
        
        boolean childFriendlyMovie = false;
        Movie m = getOneMovieInAccount(accountID, movieID);
        childFriendlyMovie = Movie.isChildFriendly();
        
        if (childAccount == true && childFriendlyMovie == false){
            m = null;
        }
        else {
            Movie.setWatched(false);
            List<Movie> movieList = a.getMovieList();
            movieList.add(m);
        }
        return m;
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    } 
    
//BH:  ARE WE  GIVING ACCOUNTS UNIQUE IDS? 
    //DW: Yes, we are taking an array that stores all accounts in app and adding one to create ID
//BH: DO METHODs INVOLVING ACCOUNTS ALSO NEED TO TAKE IN CUSTID TO GO PATH CUSTOMER:ACCOUNT:MOVIE. 
//This is best practice and was discussed with Noel but we can not do. Do you think this will be possible?
    //DW: Working on it
//BH: the resource is currently only passing accountID and movieID but can be easily changed back
    
    public String removeMovie(int accountID, int movieID){
        Movie m = getOneMovieInAccount(accountID, movieID);
        Account a = CustomerService.getAccountByID(accountID);
        List<Movie> movieList = a.getMovieList();
        movieList.remove(movieID);
        return "Movie successfully added";
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
    
// BH: THIS NEEDS TO BE LINKED TO A CUSTOMER, AS ABOVE   
    public ArrayList<Movie> getMoviesInAccount(int accountID){
        Account a = new Account();
        ArrayList<Movie> movieList = a.getMovieList();
        return movieList;
    }
    
    
    public Movie getOneMovieInAccount(int accountID, int movieID){
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
    
    public String transferMovie(int fromAccountID, int movieID, Account a){
        removeMovie(fromAccountID, movieID);
        //should have response if movie not on account, 404 resource not found. 
        addMovie(a.getAccountID(), movieID);
        return "Code 200 - transferred successfully";
        //needs error msg 404 resource not found
        //Response: Code 200 / 404 ‘Movie successfully removed’
    } */
    
    
    
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