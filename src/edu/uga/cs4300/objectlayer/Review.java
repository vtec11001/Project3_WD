package edu.uga.cs4300.objectlayer;

public class Review 
{
	private String review; 
	private int id; 
	
	public Review(String userReview, int userId)
	{
		review = userReview; 
		id = userId;
		//constructor for review objects so we can access easily when gettting result sets of reviews. 
	}
	
	public String getReview()
	{
		return review; 
		//return the actual review string. 
	}
	
	public int getReviewId()
	{
		return id; 
		//return the associated movie id. 
	}
	
	

}
