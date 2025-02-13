package com.aurionpro.assignments;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.assignments.Movie.CapacityFullException;

public class MovieManager {
	
		List<Movie> movies;
		public static final String filepath="C:\\Users\\bala.konar\\Desktop\\Aurionpro\\MovieNames.txt";
		public static final int MaxMovies=5;
		public MovieManager()
		{
			movies=new ArrayList<Movie>();
			loadMovies();
		}
		
		public void addMovie(Movie movie) throws CapacityFullException
		{
			if(movies.size()>MaxMovies)
			{
				System.out.println("Only 5 movies can be added");
			}
			movies.add(movie);
			saveMovies();
		}
		
		public void clearMovies()  {
			movies.clear();
			saveMovies();
		}
		
		public List<Movie> getMovies()
		{
			return movies;
		}
		
		public int getMovieId(Movie movie) {
			return movie.getId();
		}
		
		public void saveMovies()
		{
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
				out.writeObject(movies);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void deleteAllMovies()
		{
			movies.clear();
			System.out.println("All movies deleted");
		}
		
		public void loadMovies()  {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath));
				movies=(List<Movie>) in.readObject();
			}  catch (IOException | ClassNotFoundException e) { 
	            movies = new ArrayList<>(); 
	        } 
		}
}
