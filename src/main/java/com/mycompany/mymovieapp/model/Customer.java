

package com.mycompany.mymovieapp.model;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

public class Customer {
    
    private int custID;
    private String name;
    private String address;
    private String email;

    private Map<Integer, Account> customerAccounts = new HashMap<>();

    public Customer(){  
    }

    public Customer (int custID, String name, String address, String email, Map<Integer, Account> customerAccounts){
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.customerAccounts = customerAccounts;
    }

    public int getCustID() {
        return custID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Map<Integer, Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerAccounts(Map<Integer, Account> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }
    
    @Override
    public String toString(){
        return "Customer{"+"custID: "+custID+ ", name: "+name+" email: "+email+"}";
    }

    public void setcustID(int custID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

