package edu.uga.cs4300.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.cs4300.logiclayer.MovieLogicImpl;
import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")



public class MainServlet extends HttpServlet 
	{
	//String addRev; 
	 
	
	private static final long serialVersionUID = 1L;
       
	private String TemplateDirectory = "WEB-INF/templates/";  
	
	MovieLogicImpl movieLogic = new MovieLogicImpl(); 
	//configure cirital varibales for databse connection. 
	
	
	Configuration config = null; 
	//configuration variable. 
	
	String UserInput = null;
	//takes the user input. 
	
	
		
	
    public void init()
    {
    	// Create your Configuration instance, and specify if up to what FreeMarker
    	// version (here 2.3.25) do you want to apply the fixes that are not 100%
    	// backward-compatible. See the Configuration JavaDoc for details.
    	config = new Configuration(Configuration.VERSION_2_3_25);
    	
    	// Specify the source where the template files come from.
		config.setServletContextForTemplateLoading(getServletContext(), TemplateDirectory);
		
		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		config.setLogTemplateExceptions(false);
		
		System.out.println("took input 1");
    }
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// You can use this structure for all of your objects to be sent to browser
	
		
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		runTemplate(request, response); 
		

		
	}
	
	@SuppressWarnings("unchecked")
	public void runTemplate(HttpServletRequest request, HttpServletResponse response) 
	{
		
		
		/***************READ: FIRST FEW CONDITIONALS GET COMMAND OPTIONS FROM INDEX. LATER ONES PROCESS DATA FROM THOSE CALLED FUNCTIONS*****/
		
		DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		
		SimpleHash root = new SimpleHash(df.build());
		
		String responseType = "default"; 
		
		
		
		if (request.getParameter("Add Movie") != null)
		{
			//used if user selected the add movie option. 
			
			
			String addMov = "Add Movie"; 
			
			
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 
			try 
			{
				movies = movieLogic.ReturnAllMovies();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("movies", movies); 
			//adds movies viewer can see before entering a movie. 
			
			
			
			root.put("addMov", addMov);
			
			testDeploy(response, root, "return");
			//testDeploy(response, root, "return");
			//calls the add movie portion of the ReturnPage form. 
			
			
			
			System.out.println(request.getParameter("MovieName") + " test");
			System.out.println(request.getAttribute("MovieName") + " test");
			
			
		}
		
		if (request.getParameter("Add Review")!= null)
		{
			//used if the user selected add review option from the index.html
			
			String addRev = "Add Review"; 
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 
			try 
			{
				movies = movieLogic.ReturnAllMovies();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("movies", movies);
			//prior to adding review the user will see what reviews are available. 
			
			
			root.put("addRev", addRev);
			
			testDeploy(response, root, "return"); 
			//generate input page for add review. 
			
			
		}
		
		if (request.getParameter("Delete Movie") != null)
		{
			//used if the user selected delte movie option from the index.html
			
			String delMov = "Delete Movie"; 
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 
			try 
			{
				movies = movieLogic.ReturnAllMovies();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("movies", movies);
			//prior to deleting movies the user will be displayed all the current movies in the db. 
			
			
			root.put("delMov", delMov); 
			
			testDeploy(response, root, "return");
		}
		
		if (request.getParameter("Delete Review") != null)
		{
			//used if the user selected delte review option from the index.html
			
			String delRev = "Delete Review"; 
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 
			try 
			{
				movies = movieLogic.ReturnAllMovies();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("movies", movies);
			//prior to deleting review the user will be shown all the movies in the db. 
			
			
			
			root.put("delRev", delRev);
			
			testDeploy(response, root, "return");
			//generate input page for delete review.
		}
		
		if (request.getParameter("Get Genre") != null)
		{
			//checks if user picked genre from index.html
			
			String getGenre = request.getParameter("Get Genre"); 
			
			root.put("getGenre", getGenre);
			
			//System.out.println(request.getParameter("TestGenre") + "1");
			
			testDeploy(response, root, "return"); 
			//generate input page for delete review.
			
			//System.out.println(request.getParameter("TestGenre") + "2");
			
			
		}
		
		if (request.getParameter("View Specific") != null)
		{
			//checks if user picked the view specefic movie info option. 
			
			String ViewSpec = request.getParameter("View Specific"); 
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 
			try 
			{
				movies = movieLogic.ReturnAllMovies();
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("movies", movies);
			
			root.put("ViewSpec", ViewSpec);
			
			testDeploy(response, root, "return");
			
		}
		
		/***************************************************************/
				
		if ((request.getParameter("MovieName") != null) && (request.getParameter("MovieYear") != null) && (request.getParameter("MovieRank") != null))
		{
			//gets parameters from the add movie option if you selected. 
			
			String inputName = request.getParameter("MovieName"); 
			String inputYear = request.getParameter("MovieYear"); 
			String inputRank = request.getParameter("MovieRank");
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 		
			try 
			{
				movieLogic.CreateMovieEntry(inputName, inputYear, inputRank);
				String templateName = "MovieDisplay.ftl"; 
				
				movies = movieLogic.ReturnAllMovies(); 
				
				root.put("movies", movies);
				//ashow movies before creating a new movie entry. 
				
				
				testDeploy(response, root, "movies");
			} 
			
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		
		if ((request.getParameter("MovNameRev") != null ) && (request.getParameter("RevArea") != null))		
		{
			//gets parameters from the add review option if you selected. 
			
			String movieName = request.getParameter("MovNameRev"); 
			String review = request.getParameter("RevArea"); 
			
			ArrayList<Review>reviews = new ArrayList<Review>(); 
			
			try 
			{
				movieLogic.CreateMovieReview(movieName, review);
			} 
			
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try 
			{
				reviews = movieLogic.ReturnReviews(movieName);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			//gets the list of reviews for the selected movie. 
			
			root.put("MovNameRev", movieName);
			root.put("reviews", reviews);
			
			testDeploy(response, root, "reviews");
			//process and deploy to freemarker from userinput. 

			
			
		}
		
		
		if (request.getParameter("Genres") != null)
		{
			//gets parameters from the genres option if you selected. 
			
			String userGenre = request.getParameter("Genres"); 
			
			ArrayList<String>genres = new ArrayList<String>(); 
			
			try 
			{
				genres = movieLogic.ReturnGenres(userGenre); 
			} 
			
			catch (NumberFormatException | ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			root.put("genres", genres);
			
			testDeploy(response, root, "genres");
			//process and deploy to freemarker from userinput. 

			
		}
		
		if (request.getParameter("DelMovName") != null)
		{
			//gets parameters from the delete movie option if you selected. 
			
			
			String movieName = request.getParameter("DelMovName") ; 
			
			ArrayList<Movie>movies = new ArrayList<Movie>(); 		
			try 
			{
				movieLogic.DeleteMovie(movieName);
				movies = movieLogic.ReturnAllMovies(); 
				root.put("movies", movies);
				testDeploy(response, root, "movies");
				
				//process and deploy to freemarker from userinput. 
				
			} 
			
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (request.getParameter("DelRevName") != null)
		{
			
			//gets parameters from the delete review option if you selected. 
			
			String movieName = request.getParameter("DelRevName"); 
			
			String MovNameRev = movieName; 
			
			ArrayList<Review>reviews = new ArrayList<Review>(); 
			
			try 
			{
				movieLogic.DeleteMovieReview(movieName);
				
				reviews = movieLogic.ReturnReviews(movieName); 
				
				root.put("MovNameRev",  MovNameRev);
				root.put("reviews", reviews);
				
				testDeploy(response, root, "reviews");
				
			} 
			
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		if (request.getParameter("ViewMovName") != null)
		{
			
			//gets parameters from the view specefic movie option if you selected. 
			
			String movieName = request.getParameter("ViewMovName"); 
			
			ArrayList<Movie>movies = new ArrayList<Movie>();
			ArrayList<Review>reviews = new ArrayList<Review>();
			//gets the movies and reviews. 
			
			String isSingle = "false"; 
			
			try 
			{
				movies = movieLogic.ReturnSingleMovie(movieName);
				reviews = movieLogic.ReturnReviews(movieName); 
				
				root.put("isSingle", isSingle);
				root.put("movies", movies);
				root.put("reviews",  reviews);
				
				testDeploy(response, root, "movies");
				//deployt the freemarker. 
				
			} 
			
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	
		}

		try {
			movieLogic.MakeDisconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		// TODO Auto-generated method stub
		doGet(request, response);
		//call do get. 
	}
	
	
	protected void testDeploy(HttpServletResponse response, SimpleHash root, String param)
	{
		//used for deploying the freemarker template. 
		
		
		response.setContentType("text/html");
		//sets what ftl should return as. 
	
		
		try
		{
			PrintWriter out = response.getWriter(); 
			Template template = null; 
			//init variables. 
			
			if (param.equals("movies"))
			{
				template = config.getTemplate("MovieDisplay.ftl"); 
				//if the return is of movies direct to movies display 
			}
			
			else if (param.equals("reviews"))
			{
				template = config.getTemplate("ReviewDisplay.ftl"); 
				//if the return is of reviews direct to reviews display 
			}
			
			else if (param.equals("return"))
			{
				template = config.getTemplate("ReturnPage.ftl"); 
				//if the return is a command page (like add movies) call the return page 
			}
			
			else if (param.equals("genres"))
			{
				//if the return is genres call the genres template. 
				
				template = config.getTemplate("GenreDisplay.ftl"); 
			}
		template.process(root, out);
		}
		
		catch (TemplateException e )
		{
			e.printStackTrace(); 
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//handles exceptions. 
		
	}


}
