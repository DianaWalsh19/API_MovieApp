/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.resources;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.service.CustomerService;
import java.util.ArrayList;
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


@Path ("/customers")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})


public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
     
     
    @GET
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GET
    @Path( "/{custID}" )
    public Customer getCustomerByID( @PathParam("custID") int custID){
        return customerService.getCustomerByID(custID);
    }

    @POST
    public Customer addCustomer(Customer c){
        return customerService.addCustomer(c);
    }

    @PUT
    @Path( "/{custID}" )
    public Customer updateCustomer( @PathParam("custID") int custID, Customer c ){
        c.setcustID(custID);
        return customerService.updateCustomer(c);
    }

    @DELETE
    @Path( "/{custID}" )
    public void deleteCustomer( @PathParam("custID") int custID){
        customerService.removeCustomer(custID);
    }
    
    //This is a sub-resource declaration.
    //It tells the system that whenever the path matches the one below ("/{custID}/accounts"),
    //the AccountResource is handed over the responsability to execute
    @Path("/{custID}/accounts")
    public AccountResource getAccountResource(){
        return new AccountResource();
    }
    
    /*
    CustomerService customerService = new CustomerService();
    
    // DW: TEST API TO CHECK IF CUSTOMERS ARRAYLIST IS BEING POPULATED
    @GET
    public ArrayList<Customer> getCustomers(){  
        return customerService.getAllCustomers();
    }
    
    // BH: THIS ONE IS FOR TESTING THE CUSTOMER LIST
    @GET
    @Path("/{custID}")
    public Customer getCustomerName(@PathParam("custID") int id) {
        return customerService.getCustomerByID(id);
    }
    
    //**API 1*********************
    //BH: RQST IS COMING THROUGH BUT THE CUSTOMER LIST IS THROWING NULL POINTER EXCEPTION
    @POST
    @Path("/{custID}")
    public Account createAccount(@PathParam("custID") int id, Account a){
        //Customer c = customerService.getCustomerByID(id);
        //NEEDS TO BE ADDED TO CUSTOMER LIST HERE, not sure how yet
        //c.setAccount(a);
        return customerService.addAccount(a); 
    }

    

//**API 8****EXTRA*****************
//    @GET
//        @Path("/{custID}")
//    public List<Account> getAccount(@PathParam("custID") int id){
//        return customerService.getAllAccounts(id);
//    }
    
    
    
//    @GET
//    public Account getAccount(@PathParam("accountID") int accountID){
//        return Account getOneAccount(int id);
//    }
    
    
    
 //THIS CHAINS THE PARENT RESOURCE, CUSTOMERS, WITH THE SUBRESOURCE, ACCOUNTS   
// IS THIS ONLY NEEDED WHEN CREATING A DATABASE LAYER?
    @Path("/{custID}/accounts")
    public AccountResource getAccountsResource() {
	System.out.println("Getting accounts subresoruces...");
	return new AccountResource();
    }*/
}
