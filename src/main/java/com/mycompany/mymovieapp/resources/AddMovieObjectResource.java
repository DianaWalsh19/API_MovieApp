/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.resources;

import javax.ws.rs.POST;
import com.mycompany.mymovieapp.model.*;
import com.mycompany.mymovieapp.service.AddMovieObjectService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bebhin
 */
@Path ("/customers/accounts/movies")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AddMovieObjectResource {
    
    AddMovieObjectService addMovieObjectService = new AddMovieObjectService();


//***** ADD MOVIE TO ACCOUNT ***************************************************    
    @POST
    public String addMovieToAccount(AddMovieObject amo){
        return addMovieObjectService.addMovie(amo);
    }
}
