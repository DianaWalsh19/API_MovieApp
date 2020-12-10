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


@Path ("/movie")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    @POST
    @Path("/{custID}")
    public List<Account> createAccount(@PathParam("custID") int id){
        //input: String userName, String password, boolean child
        return customerService.createAccount();
    }
    
    @GET
    public List<movieList> getAccount{
        return customerService.getAllAccounts();
 }
    
    @GET
    public Account getAccount(@PathParam int accountID){
        return Account getOneAccount(int id);
    }
}
