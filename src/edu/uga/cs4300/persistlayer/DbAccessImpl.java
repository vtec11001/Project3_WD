package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAccessImpl extends DbAccessConfiguration implements DbAccessInterface 
{
	
	/******THERE FUNCTIONS ARE CALLED BY MOVIE PERSIST*****/

	@Override
	public Connection connect() throws ClassNotFoundException 
	{
		try 
		{
			
			System.out.println(DB_DRIVER_NAME); 
			
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println(DB_CONNECTION_URL);
			conn = DriverManager.getConnection(DB_CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);
			//establishes connection. 
		} 
		
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet retrieve(Connection con, String query) throws SQLException 
	{
		con = conn; 
		
		Statement statement = con.createStatement(); 
		ResultSet rs = null; 
		//gets the result set for the given query. 
		
		// TODO Auto-generated method stub
		try 
		{
			rs = statement.executeQuery(query);
		}
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return rs;
	}

	@Override
	public int create(Connection con, String query) throws SQLException 
	{
		con = conn; 
		Statement statement = con.createStatement(); 
		
		try 
		{
			
			statement.executeUpdate(query);
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			
			System.out.println("Update Unsucessful");
			
			e.printStackTrace();
		} 
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection con, String query) 
	{
		con = conn; 
		
		//handles update queries. These do not really return anything. 
		
		try 
		{
			statement.executeUpdate(query);
			//runs update query. 
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			
			System.out.println("Update Unsucessful");
			//print error. 
			
			e.printStackTrace();
		} 
		
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection con, String query) throws SQLException 
	{
		con = conn; 
		
		Statement statement = con.createStatement();
		
		String openKey = "set foreign_key_checks = 0"; 
		String closeKey = "set foreign_key_checks = 1";
		//need to run these to open up for deletion. 
		
		try 
		{
			statement.executeQuery(openKey);
			statement.executeUpdate(query);
			statement.executeQuery(closeKey);
			//opens for deletion, delete and then close. 
			
			
			//delete review, then delete movie. 			
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void disconnect(Connection con) 
	{
		con = conn; 
		
		//diconnects servlet. 
		
		
		if (con != null)
			try 
			{
				con.close();
			}
		
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		
	}
	

}
