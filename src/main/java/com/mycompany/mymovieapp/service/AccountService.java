/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;
import com.mycompany.mymovieapp.model.Customer;
import com.mycompany.mymovieapp.model.Movie;
import com.mycompany.mymovieapp.model.MoviesOnDemand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountService {
    
    MoviesOnDemand mod = new MoviesOnDemand();
    
    private Map<Integer, Customer> allCustomers = mod.getAllCustomers();
    ArrayList<Customer> allCustomersList = new ArrayList<>(allCustomers.values());
    private Map<Integer, Account> allAccounts = mod.getAllAccounts();
    //ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
    
    
    public ArrayList<Account> getCustomerAccounts(int custID){
        Customer c = allCustomers.get(custID);
        Map<Integer, Account> customerAccounts = c.getCustomerAccounts();
        Set<Entry<Integer, Account> > entrySet = customerAccounts.entrySet(); 
        ArrayList<Account> listOfCustomerAccounts = customerAccounts.values().stream().collect( 
                Collectors.toCollection(ArrayList::new)) ; 
        /*ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
        
        try{
            for(int i = 0; i < allAccountsList.size(); i++){
                Account a = allAccountsList.get(i);
                if (a.getCustID() == custID){
                    listOfCustomerAccounts.add(a);
                }c.setListCustomerAccounts(listOfCustomerAccounts);  
            }
        }catch(NullPointerException e){
        System.out.println("Customer list throwing NullPointerException");
        }*/
        return listOfCustomerAccounts;
    }
    
    public Account getAccountByID(int custID, int accountID){
        Customer c = allCustomers.get(custID);
        Map<Integer, Account> customerAccounts = c.getCustomerAccounts();
        Account a = customerAccounts.get(accountID);
        return a;
    }
    
    public Account addAccount(int custID, Account a){
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        a.setAccountID(allAccounts.size()+1);
        allAccounts.put(allAccounts.size(), a);
        customerAccounts.put(a.getAccountID(), a);
        return a;        
    }

    public String removeAccount(int custID, int accountID){
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        customerAccounts.remove(accountID);
        //Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        //allAccounts.remove(accountID-1);
        return "Account succesfully deleted";
    }
    
    public Account updateAccount(int custID, Account a){
        int accountID = a.getAccountID();
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        customerAccounts.remove(accountID);
        Account newAcccount = a;
        a.setAccountID(a.getAccountID());
        allAccounts.put(accountID, a);
        customerAccounts.put(accountID, a);
        return a;   
    }
    //*************************************************************************************************
    
    /*
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    //EXAMPLE OF FILTERING
    /*public List<Message> getSearchMessages(String message, String author) {
        List<Message> matcheslist = new ArrayList<>();
        
        for (Message q: getAllMessages()) {
            if ((message == null || q.getMessage().equals(message)) 
                   && (author == null || q.getAuthor().equals(author))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;

    */
}
