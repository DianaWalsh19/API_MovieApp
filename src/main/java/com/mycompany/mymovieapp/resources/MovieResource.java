/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.*;
import com.mycompany.mymovieapp.service.MovieService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path ("/")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//Keeping produces in causes a ModelValidationException "ambiguous (sub-)resource method
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MovieResource {
    
    MovieService movieService = new MovieService();
    
//******* API 3: REMOVE MOVIE **************************************************
    
    @DELETE
    @Path("/{movieID}")
    public String removeMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID){
        return movieService.removeMovie(custID, accountID, movieID);
    }
      
//******** API 4: LIST MOVIES IN ACCOUNT ***************************************
    @GET
    public List<Movie> listMovies(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return movieService.getMoviesInAccount(custID, accountID);
    }

//********* API 5: SHOW ONE MOVIE **********************************************
    @GET
    @Path("/{movieID}")
    public Movie showOneMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID){
        return movieService.getOneMovieInAccount(custID, accountID, movieID);
    }
    
//********* API 6: TRANSFER MOVIE **********************************************   
    @PUT
    @Path("/{movieID}/transfer")
    public String transferMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, @PathParam("movieID") int movieID, Account a){
        return movieService.transferMovie(custID, accountID, movieID, a);
    }
    
    
//    @POST
//    public String addMovie(@PathParam("custID") int custID, @PathParam("accountID") int accountID, Movie m){
//        return movieService.addMovie(custID, accountID, m);
//    }
//
//    @POST
//    public String addMovieToAccount(AddMovieObject amo){
//        return movieService.addMovie(amo);
//    }   
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
