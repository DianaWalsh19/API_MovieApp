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

@Path ("/customer/account")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AccountResource {
    
    AccountService accountService = new AccountService();
    
    // 

    
    @POST
    public String addMovieToAccount(){
       //resource content: custID, movieID, accountID
        return accountService.addMovie();
    }
    
    @DELETE
    public String removeMovieFromAccount(){
       //resource content: custID, movieID, accountID
        return accountService.removeMovie();
    }
    
    @PUT
    @Path("/{custID}/{accountID}/{movieID}")
        public String transferMovie(@PathParam("custID") int custid, @PathParam("accountID") int accountid, @PathParam("movieID") int movieid){
        //resource content:  new accountID
        return accountService.transferMovie();
    }
    
    @GET
    @Path("/{custID}/{accountID}")
    public movieList getMovie(@PathParam("custID") int id, @PathParam("accountID")){
        return movieService.getAllMovies();
    }
    
    //where to put watched movies list?
    //where to out recommened list?

    
    
}

