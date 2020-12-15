/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.service;

import com.mycompany.mymovieapp.model.Account;

import java.util.ArrayList;
import java.util.List;


public class AccountService {
    

    public static List movieList = new ArrayList<>();
    
    
    public String addMovie(){
        //add movie to movieList by ID
        //check for child-friendly
        return "Movie successfully added";
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
       
    public String removeMovie(){
        //add movie to movieList by ID
        return "Movie successfully added";
        //Response: Code 200 / 404 ‘Movie successfully removed’
        //System.out.println("201 - new resource created: /messages/" + String.valueOf(m.getId()));
    }
    
//    public List<movieList> getAllMovies(){
//        //Movie m1 = new Movie(001, "Jurassic Park", 1900, false, true, "Movie about dinasaurs killing people", false);
//        return list;
//    }
//    
//    public Movie getOneMovie(int id){
//        return list.get(id);
//    }
    
    public String transferMovie(){
        //removeMovie() from accountID as param
        //msg to say if successful, method stops here if unnsuccessful
        //resource not found error
        //addMovie() to accountID from resource content
        //check for child-friendly
        //msg to say if successfully transferred
        //revert watched to 'false'
        return "transferred successfully";
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
