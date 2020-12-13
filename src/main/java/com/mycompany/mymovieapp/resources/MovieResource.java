/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.service.MovieService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path ("/movie")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MovieResource {
    
    MovieService movieService = new MovieService();
    

    
    @GET
    @Path("/{movieID}")
    public Movie getMovie(@PathParam("movieID") int id){
        return movieService.getOneMovie(id);
    }
//**API 7, EXTRA - watched and recc*********************   
    @GET
    // display watched Movies
    public Movie recommended(){
        return
    }
    
    @GET
    // display watched Movies
    public Movie watched(){
        return
    }
    
}
