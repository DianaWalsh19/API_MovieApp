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
    
 //Commenting this method out, see issue #9 in GitHub
 /*  
    public String markAsRecommendedMovie(int movieID){
        m = Movie.getMovieID(movieID);
        m.setRecommended (true);
        return "successfully added to recommended";
    }
   */ 
}