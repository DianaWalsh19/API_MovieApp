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

    public ArrayList<Account> getAllAccounts(int custID){      
        
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
    
    // DW: This one works, the ID is correctly mapped, but in the response for some reason the Account ID still shows as 0
    public Account getAccountByID(int custID, int accountID){
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        return customerAccounts.get(accountID);
    }
    /*
    public List<Account> getCustomerAccounts(int customID){
        Map<Integer, Account> customerAccounts = Customer.getCustomerAccounts(customID);
        return new ArrayList<>(customerAccounts.values());
        customerAccounts = null;
        for(int i = 0; i < allAccounts.size(); i++) {
                System.out.println(allAccounts.get(i).getUserName());
            }
        try{
            for (Account a : allAccounts.values() ){
                if (a.getCustomID() == customID) {
                    customerAccounts.add(a);
                    return customerAccounts;
                } 
            }
        }catch(NullPointerException e){
        System.out.println("Customer list throwing NullPointerException");
        }
        return customerAccounts;
    }
    */

    public Account addAccount(int custID, Account a){
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        a.setAccountID(customerAccounts.size()+1);
        customerAccounts.put(a.getAccountID(), a);
        allAccounts.put(a.getAccountID(), a);
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
        Map<Integer, Account> customerAccounts = allCustomers.get(custID).getCustomerAccounts();
        allAccounts.remove(accountID);
        return customerAccounts.remove(accountID);
    }
    
    
    
    /*
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    
    
//THIS LINKS TO A POST REQUEST AND NEEDS A JSON OBJECT TO BE PASSED THROUGH, IT CANNOT
// BE USED WITH PARAMETERS AS IS, WAITING FOR NOEL'S NOTES TO LEARN HOW TO DO THIS
    
    public Movie addMovie(int accountID, int movieID){
        boolean childAccount = false;
        Account a = new Account();
        a = CustomerService.getAccountByID(accountID);
        childAccount = Account.isChild();
        
        boolean childFriendlyMovie = false;
        Movie m = getOneMovieInAccount(accountID, movieID);
        childFriendlyMovie = Movie.isChildFriendly();
        
        if (childAccount == true && childFriendlyMovie == false){
            m = null;
        }
        else {
            Movie.setWatched(false);
            List<Movie> movieList = a.getMovieList();
            movieList.add(m);
        }
        return m;
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    } 
    
//BH:  ARE WE  GIVING ACCOUNTS UNIQUE IDS? 
    //DW: Yes, we are taking an array that stores all accounts in app and adding one to create ID
//BH: DO METHODs INVOLVING ACCOUNTS ALSO NEED TO TAKE IN CUSTID TO GO PATH CUSTOMER:ACCOUNT:MOVIE. 
//This is best practice and was discussed with Noel but we can not do. Do you think this will be possible?
    //DW: Working on it
//BH: the resource is currently only passing accountID and movieID but can be easily changed back
    
    public String removeMovie(int accountID, int movieID){
        Movie m = getOneMovieInAccount(accountID, movieID);
        Account a = CustomerService.getAccountByID(accountID);
        List<Movie> movieList = a.getMovieList();
        movieList.remove(movieID);
        return "Movie successfully added";
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
    
// BH: THIS NEEDS TO BE LINKED TO A CUSTOMER, AS ABOVE   
    public ArrayList<Movie> getMoviesInAccount(int accountID){
        Account a = new Account();
        ArrayList<Movie> movieList = a.getMovieList();
        return movieList;
    }
    
    
    public Movie getOneMovieInAccount(int accountID, int movieID){
        Movie found = null;
        Account a = new Account();
        List<Movie> movieList = a.getMovieList();
        for (Movie m : movieList) {
            if (m.getMovieID() == movieID) {
                found = m;
            } 
        }
        return found;
    }
    
    public String transferMovie(int fromAccountID, int movieID, Account a){
        removeMovie(fromAccountID, movieID);
        //should have response if movie not on account, 404 resource not found. 
        addMovie(a.getAccountID(), movieID);
        return "Code 200 - transferred successfully";
        //needs error msg 404 resource not found
        //Response: Code 200 / 404 ‘Movie successfully removed’
    }

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
