package edu.uga.cs4300.objectlayer;




public class Movie 
{
private String MovieName; 
private String year; 
private String rank;
private int ID; 

public  Movie(String inputName, int inputYear, double inputRank)
{
	MovieName = inputName; 
	year = Integer.toString(inputYear);  
	rank = Double.toString(inputRank);  
	
	//movie class holds movie objects for easy acess when getting movie data. 
}

public String getName()
{
	return MovieName; 
	
	//get name
}

public String getYear()
{
	return year;
	//get year
}

public String getRank()
{
	return rank;
	//get rank
}

public int getID()
{
	return ID;
	//get unique id. 
}

/*
public void setYear(int userYear)
{
	year = userYear;
}

public void setName(String inputName)
{
	MovieName = inputName;
}

public void setID(int userID)
{
	ID = userID;
}

public void setRank(int userRank)
{
	rank = userRank;
}
*/

}
