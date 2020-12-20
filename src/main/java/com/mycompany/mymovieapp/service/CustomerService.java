
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerService {
    
    private Map<Integer, Customer> allCustomers = MoviesOnDemand.getAllCustomers();
    //private static List<Account> accountList = Customer.getAccounts();

    public CustomerService(){
        //allCustomers.put(1, new Customer("Peter Mark", "123 Crescent View, Dublin", "peter@petermark.com", accountList));
        //allCustomers.put(2, new Customer("Mary Smith", "123 New Avenue, Waterford", "mary@gmail.com",accountList));
        //allCustomers.put(3, new Customer("Peter D", "123 Magic Road, Kilkenny", "peter@anotherpeter.com",accountList) );
        
        Customer customer1 = new Customer(1, "Peter Mark Cust1", "123 Crescent View, Dublin", "peter@petermark.com");
        Customer customer2 = new Customer(2, "Mary Smith Cust2", "123 New Avenue, Waterford", "mary@gmail.com");
        Customer customer3 = new Customer(3, "Peter D Cust3", "123 Magic Road, Kilkenny", "peter@anotherpeter.com");
        
        allCustomers.put(customer1.getCustID(), customer1);
        allCustomers.put(customer2.getCustID(), customer2);
        allCustomers.put(customer3.getCustID(), customer3);
        
        Set<Map.Entry<Integer, Customer>> entries = allCustomers.entrySet();
    }

    public List<Customer> getAllCustomers(){
        return new ArrayList<>(allCustomers.values());
    }

    public Customer getCustomerByID(int custID){
        return allCustomers.get(custID);
    }

    public Customer addCustomer(Customer c){
        c.setcustID(allCustomers.size() + 1 );
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
    
    
    /* ********************
    
    private static ArrayList<Customer> allCustomers = MoviesOnDemand.getCustomerList();
    private ArrayList<Account> allAccounts = MoviesOnDemand.getAccountList();
    private static int custId = 0;
    private static List<Account> accountList = Customer.getAccounts();
    
    
    public ArrayList<Customer> getAllCustomers(){        
        return allCustomers;
    }
    
    
    public static Customer getCustomerByID(int custID) {
    Customer found = null;
    //System.out.println("getCustomerByID test 1");
    //System.out.println("Customer id;" +custID);
        //NOTE:
        try{
        //System.out.println("getCustomerByID test 2");
        //System.out.println("getCustomerByID test 2.1 "+allCustomers.toString());
            for (Customer c : allCustomers) {
        //System.out.println("getCustomerByID test 3");
                if (c.getCustID() == custID) {
        //System.out.println("getCustomerByID test 4");
                    found = c;
                    return found;
        //System.out.println("getCustomerByID test 5");
                } 
            }
    }catch(NullPointerException e){
    System.out.println("Customer list throwing NullPointerException");
    }
    return found;
    }
    
    
    public Account addAccount (Account a) {
	a.setAccountID(allAccounts.size() + 1);
	accountList.add(a); //Account is added in the Customer Account list
	allAccounts.add(a); //The list of all accounts in the app is updated
        System.out.println("201 - resource created with path: /messages/" + String.valueOf(a.getAccountID()));
	return a;
    }
    
   
    public List<Account> getAllAccounts(int custID) {
        int i = Math.toIntExact(custID);
        return allCustomers.get(i-1).getAccounts();
    }
//    public List<Account> getAllAccounts(int custID){
//        return accountList;
//    }
        
    public static Account getAccountByID(int accountID) {
        Account found = null;
        for (Account a : accountList) {
            if (a.getAccountID() == accountID) {
                found = a;
            } 
        }
        return found;
    }*/
}