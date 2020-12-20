/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.Movie;
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
import javax.ws.rs.core.Response;


//This path is blank to link up with the sub-resource declaration in the CustomerResource class
@Path ("/")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class AccountResource {
    
    AccountService accountService = new AccountService();
    
    /*//Test IP tp check sub-resource performance
    @GET
    @Path("/{accountID}")
    public String getAccountByID(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return "Method to return Customer ID "+ custID + " for account " + accountID;
        //return accountService.getAccountByID(accountID);
    }*/
    
    @GET
    public List<Account> getAllAccounts(@PathParam("custID") int custID){
        return accountService.getAllAccounts(custID);
    }
    
    @POST
    public Account addAccount(@PathParam("custID") int custID, Account a){
        return accountService.addAccount(custID, a);
    }
    
    @PUT
    @Path("/{accountID}")
    public Account updateAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID, Account a){
        a.setAccountID(accountID);
        return accountService.updateAccount(custID, a);
    }
    
    @DELETE
    @Path("/{accountID}")
    public void deleteAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        accountService.removeAccount(custID, accountID);
    }
    
    @GET
    @Path("/{accountID}")
    public Account getAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return accountService.getAccountByID(custID, accountID);
    }
    
//**API 2********************** 
//Need Noel’s notes on passing JSON objects, do we make new class within java file?
//I need an object to pass through to the services class and don’t have appropriate
// one that will have the three rqd ids. Do I maybe pass 3 diff objects?
    /*@POST
    public Movie addMovieToAccount(addMovieObject amo){
        //Body - movie id  (as JSON fragment}
        
        return accountService.addMovie(accountID, movieID);
    }*/

    
    /*
    
////**API 3********************** 
//POSSIBLY NEEDS TO HAVE CUSTID INCLUDED ALSO, MAY NEED TO LIVE IN ANOTHER RESOURCE??
//ALL INFO MUST BE PASSED AS PARAMETER FOR DELETE
    @DELETE
    @Path ("/{accountID}/{movieID}")
    public String removeMovieFromAccount(  
                                            @PathParam("accountID") int accountID,
                                            @PathParam("movieID") int movieID){
        return accountService.removeMovie(accountID, movieID);
    }
  
    
    
    
    
////**API 4**********************   
//POSSIBLY NEEDS TO HAVE CUSTID INCLUDED ALSO
    @GET
    @Path("{accountID}")
    public List listMoviesInAccount(@PathParam("accountID") int accountID){
    //From Diana: I changed the name of this because getAllMovies is a method in Movies on Demand.
    //The method in the Account Service class is 
        return accountService.getMoviesInAccount(accountID);
    }

    
    
    
    
    
// //**API 5**********************  
//POSSIBLY NEEDS TO HAVE CUSTID INCLUDED ALSO
    @GET
    @Path("/{accountID}/{movieID}")
    public Movie showOneMovie( @PathParam("accountID") int accountID,
                                @PathParam("movieID") int movieID){
        return accountService.getOneMovieInAccount(accountID, movieID);
    }
    
    
    
    
    
// //**API 6**********************  
//POSSIBLY NEEDS TO HAVE CUSTID INCLUDED ALSO
    @PUT
    @Path("/{accountID}/movie/{movieID}")
        public String transferMovie(@PathParam("accountID") int accountID,
                                    @PathParam("movieID") int movieID,
                                    Account a){
        return accountService.transferMovie(accountID, movieID, a);
    }

        
        
        
        
        
    //THIS CHAINS THE ACCOUNTS RESOURCE TO THE SUBRESOURCE - MOVIES
    //NOT SURE IF THIS IS NEEDED, NEED TO ASK NOEL
    @Path("/{accountID}/movie")
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

