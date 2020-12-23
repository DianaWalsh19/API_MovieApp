
package com.mycompany.mymovieapp.resources;


import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.service.CustomerService;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path ("/customers")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})


public class CustomerResource {
    

     
////***********Additional methods used for testing throughout development*********   
    
    CustomerService customerService = new CustomerService();
    
    @GET
    public ArrayList<Customer> getAllCustomers(){
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
//    
//// DW: TEST API TO CHECK IF CUSTOMERS ARRAYLIST IS BEING POPULATED
//    @GET
//    public ArrayList<Customer> getCustomers(){  
//        return customerService.getAllCustomers();
//    }
//    
//    // BH: THIS ONE IS FOR TESTING THE CUSTOMER LIST
//    @GET
//    @Path("/{custID}")
//    public Customer getCustomerName(@PathParam("custID") int id) {
//        return customerService.getCustomerByID(id);
//    }
    
     //THIS CHAINS THE PARENT RESOURCE, CUSTOMERS, WITH THE SUBRESOURCE, ACCOUNTS  
    //It tells the system that whenever the path matches the one below ("/{custID}/accounts"),
    //the AccountResource is handed over the responsability to execute
    @Path("/{custID}/accounts")
    public AccountResource getAccountResource(){
        return new AccountResource();
    }
    
}
