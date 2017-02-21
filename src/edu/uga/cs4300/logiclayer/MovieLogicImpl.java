package edu.uga.cs4300.logiclayer;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import edu.uga.cs4300.persistlayer.MoviePersistImpl;

//hello there!


public class MovieLogicImpl 
{


	
	public void DeleteMovie(String query ) throws ClassNotFoundException, SQLException
	{
		//deletes a single movie. 
		
		//the query is the name of the movie. 
		
		String queryId = Integer.toString(ConvertNametoId(query)); 
		//converts the user name input into an id the db can work with. 
		
		MoviePersistImpl mpi = new MoviePersistImpl(); 
		
		mpi.deleteMovie(queryId);
		//creates persist and calls the delete command. 
		
		
		
	}
	
	public void DeleteMovieReview(String query) throws ClassNotFoundException, SQLException
	{
		//deletes a single movie review. 
		
		String queryId = Integer.toString(ConvertNametoId(query)); 
		//input is a movie name, need to convert to ID for db. 
		
		
		MoviePersistImpl mpi = new MoviePersistImpl(); 
		
		
		mpi.deleteReview(queryId);
		//used to delete a single review. 
		
	}
	
	public void CreateMovieEntry(String movName, String movYear, String movRank) throws ClassNotFoundException, SQLException
	{
		//creates single movie entry. 
		
		MoviePersistImpl mpi = new MoviePersistImpl(); 
		
		//String query = "insert into movies (name, year, rank) values(" + "\"" + movName + "\", " + movYear + ", " + movRank + ")";
		
		mpi.createMovie(movName, movYear, movRank);
		//creates a new movie entry takes the movie charectersitics and processes later for DB. 
	}
		
	public void CreateMovieReview(String query, String ReviewString) throws ClassNotFoundException, SQLException
	{
		//creates single movie review. 
		//takes in name of movie and the review itself. 
		
		MoviePersistImpl mpi = new MoviePersistImpl(); 
		//create movie persist object. 
		
		//query = "insert into reviews (movie_id, review) values(" + query + ",  \"" + ReviewString +  "\")";
		
		String id = Integer.toString(ConvertNametoId(query)); 
		//converts the input name into an id the database can process. 
		
		//System.out.println("Id is: " + id);
		
		mpi.createReview(id, ReviewString);
		//create a movie review for a given id/name; 
	}
	
	public int ConvertNametoId(String name) throws ClassNotFoundException, SQLException
	{
		//function used to convert name to id. 
		//must do this as we get movie information via id. 
		
		
		MoviePersistImpl mpi = new MoviePersistImpl(); 
		//create persist object. 
		
		int result = 0; 
		ResultSet rs = mpi.getId(name); 
		//gets the id associated with name. 
		
		while (rs.next())
		{
			//used to get id from the movie dataset essentially converts from table to int format. 
			
			
			 

			int tempId = rs.getInt("id"); 
			//System.out.println("int is: " + tempId);
			result = tempId; 
			//break; 
		}
		
		return result; 	
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList ReturnAllMovies() throws ClassNotFoundException, SQLException
	{
		//function used to return all movies. 
		
		MoviePersistImpl mpi = new MoviePersistImpl();
		//create persist object. 
		
		ResultSet rs = mpi.getAllMovies(); 
		//rs set to all movies in database. 
		
		ArrayList<Movie>MovieResults = new ArrayList<Movie>(); 
		//arraylist of movie objects. Used for easy acess later. 
		
		while (rs.next())
		{
			
			
			
			String name = rs.getString("name"); 
			int year = rs.getInt("year"); 
			double rank = rs.getFloat("rank"); 
			//gets the movies name, rank and year. 
			
			//System.out.println("Rank: " + rank);
			
			MovieResults.add(new Movie(name, year, rank)); 
			//dynamically create movie obejcts based off of information we just pulled from results. 
			
			
		}
		
		return MovieResults;
		//return arrayList. 
		
		
	}

	@SuppressWarnings("rawtypes")
	public ArrayList ReturnReviews(String movieName) throws ClassNotFoundException, SQLException
	{
		ArrayList<Review>reviews = new ArrayList<Review>(); 
		//create list of reviews. 
		
		MoviePersistImpl mpi = new MoviePersistImpl();
		//creates the persist object. 
		
		int id = 0; 
		//init id .
		
		id = ConvertNametoId(movieName); 
		//convert user input name to lookable id. 
		
		
		ResultSet rs = mpi.getReviews(id); 
		//get resultset of of reviews for specefied id.  
		
		
		
		while (rs.next())
		{
			String tempString = rs.getString("review"); 
			int tempId = rs.getInt("movie_id"); 
			
			reviews.add(new Review(tempString, tempId)); 
			//iterate thorugh all reviews given movie and add to arraylist. 
			
		}
		
		return reviews; 
		//return reviews. 
		
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList ReturnGenres(String genreName) throws ClassNotFoundException, SQLException
	{
		//used to return all movies of a genre. 
		
		
		MoviePersistImpl mpi = new MoviePersistImpl();
		//create new persist object. 
		
		ArrayList<String>resultList = new ArrayList<String>(); 
		//arraylist used to hold all the movies names after processing resultsets. 
		
		ResultSet genresId = mpi.GenreAccess(genreName);
		//contains the movie id's of associated genre. 
		
		ArrayList<Integer>id = new ArrayList<Integer>(); 
		//arraylist that holds the results from genreID in integer form. 
		
		ResultSet movies = mpi.getMoviesIdNames(); 
		//returns all movie id's and names. 
		
		
		HashMap<Integer, String>moviesMap = new HashMap<Integer, String>(); 
		//hashmap used to store the integer id and the associated name of the movie. 
		
		
		while (genresId.next())
		{
			int temp = 0; 
			temp = genresId.getInt("movie_id"); 
			id.add(temp); 
			//add the id of asked genre to id arraylist. 
		}
		
		while(movies.next())
		{
			int temp = 0; 
			temp = movies.getInt("id"); 
			
			String tempString = ""; 
			tempString = movies.getString("name"); 
			
			moviesMap.put(temp, tempString); 
			//get all the movies and their id, and names and put it to hashmap. 
		}
		
		for (int i = 0; i<id.size(); i++)
		{
			if (moviesMap.containsKey(id.get(i)))
			{
				//iterate through the genres movie id. If the movie in genres list is in the general movie list add to final arraylist reesult. 
				
				String temp = moviesMap.get(id.get(i)); 
				
				resultList.add(temp); 
				System.out.println(temp);
			}
		}
		return resultList; 
		//return all the movies of associated genre in stirng name form. 
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList ReturnSingleMovie(String movieName) throws ClassNotFoundException, SQLException
	{
		//used to return a single movie from db. 
		
		ArrayList<Movie>movie = new ArrayList<Movie>();
		//create arraylist to hold the movie. 
		
		MoviePersistImpl mpi = new MoviePersistImpl();
		//create persist object. 
		
		ResultSet rs = mpi.getSingleMovie(movieName); 
		//create result set from the single movie. 
		
		while (rs.next())
		{
			String tempString = rs.getString("name"); 
			int tempYear = 0; 
			double tempRank  = 0; 
			
			tempYear = rs.getInt("year"); 
			tempRank = rs.getDouble("rank"); 
			
			movie.add(new Movie(tempString, tempYear, tempRank)); 
			//create movie object and put into arraylist. 
			
		}
		
		return movie; 
		//return the movie. 
		
	}

	public void MakeDisconnect() throws ClassNotFoundException
	{
		MoviePersistImpl mpi = new MoviePersistImpl();
		//create persist object. 
		
		mpi.makeDisconnect();
		//disconnect from server. 
		
		
	}
	

}
