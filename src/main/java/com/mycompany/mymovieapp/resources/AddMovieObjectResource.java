
package com.mycompany.mymovieapp.resources;

import javax.ws.rs.POST;
import com.mycompany.mymovieapp.model.*;
import com.mycompany.mymovieapp.service.AddMovieObjectService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path ("/customers/accounts/movies")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AddMovieObjectResource {
    
    AddMovieObjectService addMovieObjectService = new AddMovieObjectService();

//***** API 2 - ADD MOVIE TO ACCOUNT ***************************************************    
    @POST
    public Response addMovieToAccount(AddMovieObject amo){
        Account account = addMovieObjectService.addMovie(amo);
        if (account != null) {
            String output = "Movie added to the following account: " + account.toString();
                return Response.status(200).entity(output).build();
        } else {
            String output = "The movie could not be added to the account";
            throw new WebApplicationException(Response.status(400).entity(output).build());
        }
    }
}
