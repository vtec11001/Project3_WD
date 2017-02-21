package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbAccessInterface 
{
	
	public Connection connect() throws ClassNotFoundException;
	//connect to db. 
	
	public ResultSet retrieve (Connection con, String query) throws SQLException;
	//get info from db. 

	public int create (Connection con, String query) throws SQLException;
	//creates connection. 
	
	public int update (Connection con, String query);
	//update info on db. 
	
	public int delete (Connection con, String query) throws SQLException;
	//delete info on db. 
	
	public void disconnect(Connection con);
	//disconnect from db. 
	

}
