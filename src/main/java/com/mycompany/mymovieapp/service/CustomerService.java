
package com.mycompany.mymovieapp.service;


import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerService {
    
    MoviesOnDemand mod = new MoviesOnDemand();
    
    private Map<Integer, Customer> allCustomers = mod.getAllCustomers();
    ArrayList<Customer> allCustomersList = new ArrayList<>(allCustomers.values());

    public ArrayList<Customer> getAllCustomers(){
        //Testing
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