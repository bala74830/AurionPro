package com.aurionpro.assignments;

import java.io.Serializable;

public class Movie implements Serializable{
	int id;
	String name;
	int year;
	String genre;
	
	public Movie()
	{
		
	}
	public Movie(int id, String name, int year, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void printDetails() {
		System.out.println("Movie Id: "+id);
		System.out.println("Movie Name: "+name);
		System.out.println("Movie Year: "+year);
		System.out.println("Movie Genre: "+genre);
	}
	
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", genre=" + genre + "]";
	}
	
	class CapacityFullException extends Exception { 
	    public CapacityFullException(String message) { 
	        super(message); 
	    } 
	} 
	 
	class NoSuchMovieFoundException extends Exception { 
	    public NoSuchMovieFoundException(String message) { 
	        super(message); 
	    } 
	} 
}
