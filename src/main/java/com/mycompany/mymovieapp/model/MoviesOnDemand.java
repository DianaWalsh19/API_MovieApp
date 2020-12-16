/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mymovieapp.model;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.mymovieapp.model.Movie;

public class MoviesOnDemand {
    
    private static ArrayList<Customer> allCustomers;
    private static ArrayList<Movie> allMovies;
    
    public MoviesOnDemand() {

        allMovies = new ArrayList<Movie>();
        allCustomers = new ArrayList<Customer>();

        allMovies.add(new Movie(1, "Raiders of the Lost Ark", 1981, false, false, "1981 American action-adventure film directed by Steven Spielberg and written by Lawrence Kasdan based on a story by George Lucas and Philip Kaufman.", false));
        allMovies.add(new Movie(2, "The Other Guys", 2010, false, false, "2010 American buddy cop action comedy film directed by Adam McKay, who co-wrote it with Chris Henchy.", false));
        allMovies.add(new Movie(3, "Jurassic Park", 1993, false, false, "1993 American science fiction adventure film directed by Steven Spielberg and produced by Kathleen Kennedy and Gerald R. Molen.", false));

        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        allCustomers.add(new Customer(1, "Peter Mark", "123 Crescent View, Dublin", "peter@petermark.com"));
        allCustomers.add(new Customer(2, "Mary Smith", "123 New Avenue, Waterford", "mary@gmail.com"));
        allCustomers.add(new Customer(3, "Peter D", "123 Magic Road, Kilkenny", "peter@anotherpeter.com"));
    }

    public static ArrayList<Customer> getCustomerList() {
        return allCustomers;
    }

    public static ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    public static Customer getCustomerByID(int custID) {
        Customer found = null;
        for (Customer c : allCustomers) {
            if (c.getCustID() == custID) {
                found = c;
            } 
        }
        return found;
    }
    
}