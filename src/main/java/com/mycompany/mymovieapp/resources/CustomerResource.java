/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.service.CustomerService;
import com.mycompany.mymovieapp.model.Account;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


@Path ("/customer")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
//**API 1*********************
    @POST
    @Path("/{custID}")
    public void createAccount(@PathParam("custID") int id, @QueryParam("userName") String userName, @QueryParam("password") String password, @QueryParam("child") boolean child){
        //input: String userName, String password, boolean child
        return customerService.createAccount(userName, password, child);
    }

//**API 8****EXTRA*****************
    @GET
    public List<accountList> getAccount(){
        return customerService.getAllAccounts();
    }
    
    
    
    @GET
    public Account getAccount(@PathParam("accountID") int accountID){
        return Account getOneAccount(int id);
    }
    
    
    
 //THIS CHAINS THE PARENT RESOURCE, CUSTOMERS, WITH THE SUBRESOURCE, ACCOUNTS   
// IS THIS ONLY NEEDED WHEN CREATING A DATABASE LAYER?
    @Path("/{custID}/accounts")
    public AccountResource getAccountsResource() {
	System.out.println("Getting accounts subresoruces...");
	return new AccountResource();
    }
}
