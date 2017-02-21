package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DbAccessConfiguration 
{
	
	protected Connection conn; 
	protected Statement statement; 
	
	protected ResultSet result; 
	
	
	static String DB_CONNECTION_USERNAME = "demo"; 
	static String DB_CONNECTION_PASSWORD = "demo"; 
	
	static String DB_DRIVER_NAME = "com.mysql.jdbc.Driver"; 
	static String DB_CONNECTION_URL = "jdbc:mysql://localhost/imdb2";
	//set the varibales for conenctions. 
	
	
	//it wouldnt make sense to return info life password so thus minimal methods. 
	


	

}
