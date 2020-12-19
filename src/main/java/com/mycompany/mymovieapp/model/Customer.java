/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private int custID;
    private String name;
    private String address;
    private String email;
    private static List<Account> accountList;

    public Customer(){  
    }

    public Customer (int custID, String name, String address, String email, List accountList){
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.accountList = accountList;
    }
    
    public void setcustID(int custID){
        this.custID = custID;
    }
    
    public int getCustID(){
        return custID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setAccount(List<Account> accountList){
        this.accountList = accountList;
    }
    
    public static List<Account> getAccounts(){
        return accountList;
    }
}

