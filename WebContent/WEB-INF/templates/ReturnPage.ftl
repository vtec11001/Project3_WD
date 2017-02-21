<#if addMov??>
<!--used if user wants to add movie-->

<DOCTYPE! HTML>
<html>
<head>
</head>

	<body style = "background-color:beige">
		<form action = "MainServlet" method = "GET">
	    <p>Add a movie! Specify the </p>
	    
	    Movie Name: <input type = "text" name = "MovieName">
	    Movie Year: <input type = "text" name = "MovieYear">
	    Movie Rank: <input type = "text" name = "MovieRank"/>
	    
	    <br>
	    <br>
	    
	    <input type = "Submit" name="runTest" value = "Submit"/>
	    <!--creates input submission boxes for movies-->
	    <br>
	    
	    
		<table border = "1">
		
			<p>Movies in DataBase</p>
			
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Rank</th>
			</tr>
			
			<#list movies as mov>
			<tr>
				<td>${mov.getName()}</td>
				<td>${mov.getYear()}</td>
				<td>${mov.getRank()}</td>
			</tr>
			</#list>
			
						<!--prints movies so user can see possible choices for submission-->

		</table>
	    
	    
	    
		</form>
	
	</body>
</html>


<#elseif addRev ??>
<!--used if user wants to add review-->
<html>
	<body style = "background-color:beige">
	<form action = "MainServlet" method = "GET">
	<p>Select Movie to add review to</p>

	
	Movie Name: <input type = "text" name = "MovNameRev">
    
    <br>
    <textarea name = "RevArea" rows= "5" cols="100">Enter your review here</textarea>
    
    <!--creates submission area for reviews-->
    <br>
	
	<br>

<br>
	<input type="Submit" value="Submit" />
	
		<table border = "1">
		
			<p>Movies in DataBase</p>
			
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Rank</th>
			</tr>
			
			<#list movies as mov>
			<tr>
				<td>${mov.getName()}</td>
				<td>${mov.getYear()}</td>
				<td>${mov.getRank()}</td>
			</tr>
			</#list>
			
						<!--prints movies so user can see possible choices for submission-->

		</table>	
	
	</form>
	</body>
</html>


<#elseif getGenre??>
<!--used if user wants to get genre-->
<html>
<body style = "background-color:beige">
	<form action = "MainServlet" method = "GET">
		<select name = "Genres">
		<option value = "Sci-Fi">Sci-Fi</option>
		<option value = "Thriller">Thriller</option>
		<option value = "Action">Action</option>
		<option value = "Comedy">Comedy</option>
		<option value = "War">War</option>
		<option value  = "Crime">Crime</option>
		<option value = "Mystery">Mystery</option>
		<option value = "Family">Family</option>
		<option value = "Horror">Horror</option>
		<option value = "Fantasy">Fantasy</option>
		<option value = "Adventure">Adventure</option>
		<option value = "Musical">Musical</option>
		<option value = "Animation">Animation</option>
		<option value = "Romance">Romance</option>
		<option value = "Drama">Drama</option>
		<option value = "Music">Music</option>
		</select>
    <input type = "Submit" value = "Submit"/>
    </form>   
</body>
</html>



<#elseif delMov ??>
<!--used if user wants to delete a movie-->
<html>
<body style = "background-color:beige">
	<form action= "MainServlet" method = "GET">
		<p>Enter movie you wish to delete</p>

	
			Movie Name: <input type = "text" name = "DelMovName">
			
			<!--submission area if you wish to delete a movie-->
    
    		<br>


		<br>
	<input type="Submit" value="Submit" />
	
	<br>
	
		<table border = "1">
		
			<p>Movies in DataBase</p>
			
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Rank</th>
			</tr>
			
			<#list movies as mov>
			<tr>
				<td>${mov.getName()}</td>
				<td>${mov.getYear()}</td>
				<td>${mov.getRank()}</td>
			</tr>
			</#list>
			
						<!--prints movies so user can see possible choices for submission-->

		</table>
	
	
	</form>
</body>
</html>

<#elseif delRev??>
<!--used if user wants to delete a review-->
<html>
<body style = "background-color:beige">
	<form action= "MainServlet" method = "GET">
	<p>Enter movie review you wish to delete</p>

	
			Movie Name: <input type = "text" name = "DelRevName">
			
			<!--submission area for deleteing a review-->
    
    		<br>


		<br>
	<input type="Submit" value="Submit" />
	</form>
	
	<br>
	
		<table border = "1">
		
			<p>Movies in DataBase</p>
			
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Rank</th>
			</tr>
			
			<#list movies as mov>
			<tr>
				<td>${mov.getName()}</td>
				<td>${mov.getYear()}</td>
				<td>${mov.getRank()}</td>
			</tr>
						<!--prints movies so user can see possible choices for submission-->

			
			</#list>
		</table>
	
	
	
	
</body>
</html>

<#elseif ViewSpec ??>
<!--used if user wants to see a specefic movie-->
<html>
<body style = "background-color:beige">
	<form action= "MainServlet" method = "GET">
		<p>Enter movie you wish to view</p>

	
			Movie Name: <input type = "text" name = "ViewMovName">
			<!--submission area for view specefic movie-->
    
    		<br>
		<br>
		<input type="Submit" value="Submit" />
	</form>
	
	
	<br>
	
		<table border = "1">
		
			<p>Movies in DataBase</p>
			
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Rank</th>
			</tr>
			
			<#list movies as mov>
			<tr>
				<td>${mov.getName()}</td>
				<td>${mov.getYear()}</td>
				<td>${mov.getRank()}</td>
			</tr>
			</#list>
			
			<!--prints movies so user can see possible choices for submission-->
			
		</table>
	
	

</body>
</html>


</#if>
