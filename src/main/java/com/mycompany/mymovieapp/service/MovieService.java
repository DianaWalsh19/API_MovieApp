/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    
    public static List<Movie> list = new ArrayList<>();
    
    public List<Movie> getAllMovies(){
        Movie m1 = new Movie(001, "Jurassic Park", 1900, false, true, "Movie about dinasaurs killing people", false);
        return list;
    }
    
    public Movie getOneMovie(int id){
        return list.get(id);
    }
}