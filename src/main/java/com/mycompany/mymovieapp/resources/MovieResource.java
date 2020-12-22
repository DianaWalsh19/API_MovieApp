/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.service.MovieService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path ("/")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MovieResource {
    
    MovieService movieService = new MovieService();
    
    
    //**API 5: List Movies *********
    
    @GET
    public List<Movie> getMoviesInAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return movieService.getMoviesInAccount(custID, accountID);
    }
    
    @POST
    public String addMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, Movie m){
        return movieService.addMovie(custID, accountID, m);
    }

    @GET
    @Path("/{movieID}")
    public Movie getMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID){
        return movieService.getOneMovieInAccount(custID, accountID, movieID);
    }
    
    //**API 4: Remove a movie *********
    
    @DELETE
    @Path("/{movieID}")
    public String removeMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID){
        return movieService.removeMovie(custID, accountID, movieID);
    }
    
    /*
    @POST
    @Path("/{movieID}/transfer/{newAccountID)")
    public String transferMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID, @PathParam("newAccountID") int newAccountID){
        return movieService.transferMovie(custID, accountID, movieID, newAccountID);
    }*/
    
    
//**API 7, EXTRA - watched and recc*********************   
//    @GET
//    // display watched Movies
//    public Movie recommended(){
//        return
//    }
//    
//    @GET
//    // display watched Movies
//    public Movie watched(){
//        return
//    }
//    
}
