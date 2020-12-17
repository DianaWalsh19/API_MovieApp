/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.service.*;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    
    public static List<Movie> list = new ArrayList<>();
    
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
    
    
    
 //THIS IS AN EXTRA, MY NOTES ONLY INCLUDE LISTING ALL RECOMMENDED MOVIES
// IS THIS METHOD NEEDED?
    
    
    public String markAsRecommendedMovie(int movieID){
        m = Movie.getMovieID(movieID);
        m.setRecommended (true);
        return "successfully added to recommended";
    }
    
    
 // I'm not sure this is needed as a separate method, this can set be included
// in the transfer movie method as one lne of code I think
    
    public String markAsWatchedMovie(int accountID, int movieID){
        Movie m = getOneMovie(accountID, movieID);
        m.setWatched (true);
        return "successfully added to watched";
    }
    
//        
//    public List getWatched(int id){
//        return list.get(id);
//    }
    

    

    
}