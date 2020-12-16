/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mymovieapp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
    private int movieID;
    private String movieName;
    private int releaseDate;
    private boolean watched;
    private boolean recommended;
    private String summary;      
    private static boolean childFriendly; 

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

    public String getMovieName() {
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
    
}
