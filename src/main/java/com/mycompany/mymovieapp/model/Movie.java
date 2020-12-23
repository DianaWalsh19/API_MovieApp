
package com.mycompany.mymovieapp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable{
    @Id
    private int movieID;
    private String movieName;
    private int releaseDate;
    private boolean watched;
    private boolean recommended;
    private String summary;      
    private static boolean childFriendly;
    //@ManytoMany(mappedBy = "movie")
    private Map<Integer, Movie> moviesInAccount = new HashMap<>();

    public Movie() {
    }

    public Movie(int movieID, String movieName, int releaseDate, boolean watched, boolean recommended, String summary, boolean childFriendly) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.watched = watched;
        this.recommended = recommended;
        this.summary = summary;
        this.childFriendly = childFriendly;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getMovieName(int movieID) {
        return movieName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public boolean isWatched() {
        return watched;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public String getSummary() {
        return summary;
    }

    public static boolean isChildFriendly() {
        return childFriendly;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setChildFriendly(boolean childFriendly) {
        this.childFriendly = childFriendly;
    } 
    
    @Override
    public String toString(){
        return "\n{ID: " +movieID+ "\nName: " + movieName +"\nRelease Date: "+releaseDate + "\nSummary: " +summary + "\nWatched: " +watched + "\nRecommended: " +recommended +"}";
 
    }
    
}
