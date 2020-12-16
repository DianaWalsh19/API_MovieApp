
package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.MoviesOnDemand;
import com.mycompany.mymovieapp.model.Account;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    private ArrayList<Customer> allCustomers = MoviesOnDemand.getCustomerList();
    private static int custId = 0;
    private static List<Account> accountList = Customer.getAccounts(custId);
    
    public static Account getAccountByID(int accountID) {
        Account found = null;
        for (Account a : accountList) {
            if (a.getAccountID() == accountID) {
                found = a;
            } 
        }
        return found;
    }
    
    public Account addAccount(int custID, String userName, String password, boolean child){
        //We need to start by bringing in the Customer profile
        Customer c = MoviesOnDemand.getCustomerByID(custID); 
        //Now we create an account object and set the variable
        Account a = new Account();
        //We set the arguments into the variable
        a.setAccountID(accountList.size() + 1);
        a.setUserName(userName);
        a.setPassword(password);
        a.setChild(child);
        //we add the account object into the list of accounts
        accountList.add(a);
        
        return a;//return the instance let resources render as JSON
    }
    
    public List<Account> getAllAccounts(){
        return accountList;
    }
    
    public Account getOneAccount(int id){
        return accountList.get(id);
    }
}