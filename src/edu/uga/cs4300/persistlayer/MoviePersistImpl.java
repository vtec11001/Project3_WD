package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviePersistImpl 
{
			
	/*
	public int insertMovie(String movieName, String userID, String userRank, String userYear) throws ClassNotFoundException, SQLException
	{
		String sqlQuery = "insert into movies (id, name, year, rank) values ( " + movieName + " " +  userID + " " + userRank + " " + userYear + " )" ;
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		
		Connection con = dbImpl.connect(); 
		//connect to database, this and the retrieval commands are calls to the backend layer.
		
		dbImpl.create(con, sqlQuery); 
		//creates new movie row in the database. 
		
		return 0; 
			
		
	}
	
	/*
	public void deleteMovie(String movieName) throws ClassNotFoundException, SQLException
	{
		String sqlQuery = "delete from movies " + movieName; 
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		
		Connection con = dbImpl.connect(); 
		//connect to database, this and the retrieval commands are calls to the backend layer.
		
		dbImpl.delete(con, sqlQuery); 
		
	}
	*/
	
	
	public ResultSet ResultColumn(String userQuery) throws ClassNotFoundException, SQLException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		ResultSet rs = dbImpl.retrieve(con, userQuery); 
		//performs retrieve command, gets the columns you want. 
		
		return rs; 
		
	}
	

	public ResultSet GenreAccess(String userGenre) throws ClassNotFoundException, SQLException
	{
		//used when getting movies for a certain genre. 
		
		
		String query = "select movie_id from movies_genres where genre = " + "\""+userGenre+"\""; 
		//gets all the movie id's from the genre user requests. 
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		ResultSet rs = dbImpl.retrieve(con, query); 
		//performs retrieve command, gets the columns you want.
		
		
		return rs;
		
	}
	
	public ResultSet getMoviesIdNames() throws ClassNotFoundException, SQLException
	{
		String query = "select id, name from movies"; 
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		ResultSet rs = dbImpl.retrieve(con, query); 
		
		return rs; 
	}
	
	
	public ResultSet RetrieveData(String userQuery) throws ClassNotFoundException, SQLException
	{
		
		
		//String movieQuery = "select name, id from movies"; 
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		if (userQuery != null)
		{
			userQuery = "select * from movies_genres where genre = " + "\"" + userQuery + "\""; 
		}
		
		else if (userQuery == null)
			userQuery = "select name, id from movies"; 
		
		
		ResultSet rs = dbImpl.retrieve(con, userQuery); 
		//performs retrieve command, gets the columns you want.
		
		
		return rs;
		
		
		//generic retreive method. 
	}
	
	public void deleteMovie(String queryId) throws ClassNotFoundException, SQLException
	{
		
		
		//user query is merely the movie you want to delete. 
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		String userQuery = null; 
		
		
		userQuery = "delete from movies where id = " + queryId; 
		dbImpl.delete(con, userQuery);
		//delelte movie. 
		
		userQuery = "delete from movies_genres where movie_id = " + queryId; 
		dbImpl.delete(con, userQuery);
		//deletes the genre. 
		
		userQuery = "delete from reviews where movie_id = " + queryId; 
		dbImpl.delete(con, userQuery);
		//deletes the review as a whole. 
		
		
		//used to delete movie; 

	}
	
	public void deleteReview(String id) throws ClassNotFoundException, SQLException
	{
		//user query is merely the movie you want to delete. 
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		String userQuery = null; 
		
		userQuery = "delete from reviews where movie_id = " + id; 
		dbImpl.delete(con, userQuery); 
		
	}
	
	
	public void createReview(String id, String review) throws ClassNotFoundException, SQLException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		
		String userQuery = "insert into reviews (movie_id, review) values(" + id + ",  \"" + review +  "\")";
		System.out.println("REVIEW CALL IS: " + userQuery);
		//command used to create a review based on id and input review from user. 
		
		//note id is converted from a string name the user inputs. 
		
		dbImpl.create(con, userQuery); 
		//used to create review for a single movie. 
		
	}
	
	public void createMovie(String movName, String movYear, String movRank) throws ClassNotFoundException, SQLException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect(); 
		 
		String userQuery = "insert into movies (name, year, rank) values(" + "\"" + movName + "\", " + movYear + ", " + movRank + ")";
		
		dbImpl.create(con, userQuery); 
		//used to create an entire movie itself. 
		
	}
	
	public ResultSet getId(String name) throws SQLException, ClassNotFoundException
	{
		
		//function used to return id from name. 
		
		//this is because user looks movie input via name. 
		
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect();
		
		String query = "select id from movies where name = " + "\"" + name +"\""; 
		//selects the id given the name. 
		
		System.out.println("TEST QUERY IS: " + query);
		
		ResultSet rs = dbImpl.retrieve(con, query); 
		
		return rs; 
	}
	
	public ResultSet getAllMovies() throws ClassNotFoundException, SQLException
	{
		//used to return all the movies in the db. 
		
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect();
		
		
		String query = "select name, year, rank from movies"; 
		
		ResultSet rs = dbImpl.retrieve(con, query); 
		
		return rs; 
		
		
	}
	
	public ResultSet getReviews(int id) throws ClassNotFoundException, SQLException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect();
		
		String query = "select review, movie_id from reviews where movie_id = " + id; 
		
		ResultSet rs = dbImpl.retrieve(con, query); 
		
		return rs; 
		
	}
	
	public ResultSet getSingleMovie(String movieName) throws ClassNotFoundException, SQLException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect();
		//create connection objects. 
		
		
		
		String query = "select * from movies where name = " + "\"" + movieName + "\""; 
		//selects all charecteristics of a specefic movie. 
		
		ResultSet rs  = dbImpl.retrieve(con, query); 
		
		return rs; 
	}
	
	public void makeDisconnect() throws ClassNotFoundException
	{
		DbAccessImpl dbImpl = new DbAccessImpl(); 
		Connection con = dbImpl.connect();
		dbImpl.disconnect(con);
	}


}
