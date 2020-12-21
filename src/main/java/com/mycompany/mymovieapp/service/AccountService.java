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
import java.util.Set;

public class AccountService {
    
    private Map<Integer, Customer> allCustomers = MoviesOnDemand.getAllCustomers();
    private Map<Integer, Account> allAccounts = MoviesOnDemand.getAllAccounts();
    
    public AccountService(){
        
        Account account1 = new Account(1, "Father in Account 1", "password Father 1", false, 1);
        Account account2 = new Account(2, "Mother in Account 1", "password Mother 1", false, 1);
        Account account3 = new Account(3, "Child in Account 1", "password Child 1", true, 1);
        Account account4 = new Account(4, "Mother in Account 2", "password Mother 2", false, 2);
        Account account5 = new Account(5, "Uncle in Account 3", "password Uncle 3", false, 3);
        Account account6 = new Account(6, "Niece in Account 3", "password Niece 3", true, 3);
        
        allAccounts.put(account1.getAccountID()+1, account1);
        allAccounts.put(account2.getAccountID()+1, account2);
        allAccounts.put(account3.getAccountID()+1, account3);
        allAccounts.put(account4.getAccountID()+1, account4);
        allAccounts.put(account5.getAccountID()+1, account5);
        allAccounts.put(account6.getAccountID()+1, account6);
        
        Set<Map.Entry<Integer, Account>> entries = allAccounts.entrySet();
    }

    public ArrayList<Account> getCustomerAccounts(int custID){
        ArrayList<Account> listOfCustomerAccounts = new ArrayList<>();
        Customer c = new Customer();
        ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
        
        try{
            for(int i = 0; i < allAccountsList.size(); i++){
                Account a = allAccountsList.get(i);
                if (a.getCustID() == custID){
                    listOfCustomerAccounts.add(a);
                }c.setListCustomerAccounts(listOfCustomerAccounts);  
            }
        }catch(NullPointerException e){
        System.out.println("Customer list throwing NullPointerException");
        }return listOfCustomerAccounts;
    }
    
    public Account getAccountByID(int custID, int accountID){
        ArrayList<Account> listOfCustomerAccounts = getCustomerAccounts(custID);
        ArrayList<Account> allAccountsList = new ArrayList<>(allAccounts.values());
        Account a = allAccountsList.get(accountID - 1);
        if(a.getCustID() != custID){
            a = null;
        }
        return a;
    }
    
    public Account addAccount(int custID, Account a){
        //Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        a.setAccountID(allAccounts.size()+1);
        a.setCustID(custID);
        //customerAccounts.put(a.getAccountID(), a);
        allAccounts.put(a.getAccountID(), a);
        /*for(int i =0; i < allAccounts.size(); i++){
            System.out.println("This is the list of accounts: "+allAccounts.get(i).getAccountID() + "\n" + allAccounts.get(i).getUserName() + "\n");
        }*/
        return a;        
    }

    public Account updateAccount(int custID, Account a){
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        if (a.getAccountID() < 0){
            return null;
        }
        customerAccounts.put(a.getAccountID(), a);
        allAccounts.put(a.getAccountID(), a);
        return a;
    }

    public Account removeAccount(int custID, int accountID){
        ArrayList<Account> listOfCustomerAccounts = getCustomerAccounts(custID);
        Account a = listOfCustomerAccounts.get(accountID-1);
        //Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        //allAccounts.remove(accountID-1);
        return listOfCustomerAccounts.remove(accountID-1);
    }
    
    
    
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
