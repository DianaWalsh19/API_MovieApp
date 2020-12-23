
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import java.util.ArrayList;
import java.util.Map;

public class CustomerService {
    
    MoviesOnDemand mod = new MoviesOnDemand();
    
    private Map<Integer, Customer> allCustomers = mod.getAllCustomers();
    ArrayList<Customer> allCustomersList = new ArrayList<>(allCustomers.values());

    public ArrayList<Customer> getAllCustomers(){
        // for Testing
        for (int i = 0; i < allCustomersList.size(); i++){
            System.out.println(allCustomersList.get(i).getName()+"\n");
        }
        return allCustomersList;
    }

    public Customer getCustomerByID(int custID){
        return allCustomers.get(custID);
    }

    public Customer addCustomer(Customer c){
        c.setCustID(allCustomers.size() + 1 );
        allCustomers.put(c.getCustID(), c );
        return c;
    }

    public Customer updateCustomer(Customer c){
        if ( c.getCustID() < 0 ){
            c = null;
        } else{
            allCustomers.put(c.getCustID(), c );
        } 
        return c;
    }

    public Customer removeCustomer(int custID){
        return allCustomers.remove(custID);
    }
        
   // for testing empty customer list that threw a NullPointerException 
//    public static Customer getCustomerByID(int custID) {
//    Customer found = null;
//    //System.out.println("getCustomerByID test 1");
//    //System.out.println("Customer id;" +custID);
//        //NOTE:
//        try{
//        //System.out.println("getCustomerByID test 2");
//        //System.out.println("getCustomerByID test 2.1 "+allCustomers.toString());
//            for (Customer c : allCustomers) {
//        //System.out.println("getCustomerByID test 3");
//                if (c.getCustID() == custID) {
//        //System.out.println("getCustomerByID test 4");
//                    found = c;
//                    return found;
//        //System.out.println("getCustomerByID test 5");
//                } 
//            }
//    }catch(NullPointerException e){
//    System.out.println("Customer list throwing NullPointerException");
//    }
//    return found;
//    }

}