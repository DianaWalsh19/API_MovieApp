
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.model.Account;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    private static ArrayList<Customer> allCustomers = MoviesOnDemand.getCustomerList();
    private ArrayList<Account> allAccounts = MoviesOnDemand.getAccountList();
    private static int custId = 0;
    private static List<Account> accountList = Customer.getAccounts();
    

    public Account addAccount (Account a) {
	a.setAccountID(accountList.size() + 1);
	accountList.add(a);
	System.out.println("201 - resource created with path: /messages/" + String.valueOf(a.getAccountID()));
	return a;
    }

    //   *****BH: CUSTOMER LIST IS THROWING NULL POINTER EXCEPTION*********
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
        //System.out.println("getCustomerByID test 5");
                } 
            }
    }catch(NullPointerException e){
    System.out.println("Customer list throwing NullPointerException");
    }
    return found;
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
    }
}