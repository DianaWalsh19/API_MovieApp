
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


//This path is blank to link up with the sub-resource declaration in the CustomerResource class
@Path ("/")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class AccountResource {
    
    AccountService accountService = new AccountService();

//**** API 1 ADD ACCOUNT ********************************
    @POST
    @Path("/new")
    public Response addAccount(@PathParam("custID") int custID, Account a){
        Account newAccount = accountService.addAccount(custID, a);
            if (newAccount != null) {
            String output = "New account created: " + newAccount.toString();
                return Response.status(201).entity(output).build();
        } else {
            String output = "Account not created";
                throw new WebApplicationException(Response.status(400).entity(output).build());
        }
    }
   
//THIS CHAINS THE ACCOUNTS RESOURCE TO THE SUBRESOURCE - MOVIES
    @Path("/{accountID}/movies")
    public MovieResource getMovieResource(){
        return new MovieResource();
    }
    
////***********Additional methods used for testing throughout development*********
    @GET
    public List<Account> getAllAccounts(@PathParam("custID") int custID){
        return accountService.getCustomerAccounts(custID);
    }
    
    @PUT
    @Path("/{accountID}")
    public Account updateAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID, Account a){
        return accountService.updateAccount(accountID, a);
    }
    
    @DELETE
    @Path("/{accountID}")
    public String removeAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return accountService.removeAccount(custID, accountID);
    }
    
    @GET
    @Path("/{accountID}")
    public Account getAccount(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
        return accountService.getAccountByID(custID, accountID);
    }
//    
//    //Test IP tp check sub-resource performance
//    @GET
//    @Path("/{accountID}")
//    public String getAccountByID(@PathParam("custID") int custID, @PathParam("accountID") int accountID){
//        return "Method to return Customer ID "+ custID + " for account " + accountID;
//        //return accountService.getAccountByID(accountID);
//    }
    
}

