/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.service.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path ("/account")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AccountResource {
    
    AccountService accountService = new AccountService();
    

//**API 2********************** 
    @POST
    public String addMovieToAccount(@QueryParam("custID") int custID,
                                    @QueryParam("accountID") int accountID,
                                    @QueryParam("movieID") int movieID){
        return accountService.addMovie();
    }
    
    
//**API 3********************** 
    @DELETE
    @Path ("/{custID}/{accountID}")
    public String removeMovieFromAccount(   @PathParam("custID") int custID,
                                            @PathParam("accountID") int accountID,
                                            @QueryParam("movieID") int movieID){
        return accountService.removeMovie();
    }
    
    
//**API 4**********************     
    @GET
    @Path("/{custID}/account/{accountID}")
    public List showAllMovies(  @PathParam("custID") int id,
                                @PathParam("accountID") int accountID){
        return accountService.getAllMovies();
    }

 //**API 5**********************  
    @GET
    @Path("/{custID}/account/{accountID}/movie/{movieID}")
    public List showOneMovie(   @PathParam("custID") int id,
                                @PathParam("accountID") int accountID,
                                @PathParam("movieID") int movieID){
        return accountService.getOneMovie(movieID);
    }
    
 //**API 6**********************  
    @PUT
    @Path("/{custID}/account/{accountID}/movie/{movieID}")
        public String transferMovie(@PathParam("custID") int custID,
                                    @PathParam("accountID") int accountID,
                                    @PathParam("movieID") int movieID,
                                    @QueryParam("accountID") int newAccountID){
        return accountService.transferMovie();
    }
    

    


    //THIS CHAINS THE ACCOUNTS RESOURCE TO THE SUBRESOURCE - MOVIES
    //NOT SURE IF THIS IS NEEDED, NEED TO ASK NOEL
    @Path("/{accountID}/movies")
    public MovieResource getMoviesResource() {
	System.out.println("Getting movies subresoruces...");
	return new MovieResource();
    }
    
    
        
//EXAMPLE OF FILTERING
 /*   @GET
    public List<Message> getFilteredMessages(@QueryParam("message") String message, @QueryParam("author") String author) {
        if ((message != null) || (author != null)) {
                     return messageService.getSearchMessages(message, author);
        }
        return messageService.getAllMessages();
}*/
}

