
	<html>
	<body style = "background-color:beige">
	
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
			
			<!--prints out the movie charecteristics-->
			
		</tr>
		</#list>
		
		<#if isSingle ??>
			<table border = "1">
			<tr><th>Reviews for Movie</th></tr>
			<tr><th>Review</th></tr>
			
			<!--this is used when we call command that adds review. Will display the movie and the review-->
	
			
			
			<#list reviews as rev>
			<tr><td>${rev.getReview()}</td></tr>
			</#list>
				
			</table>
		</#if>
		
	</table>
	
	</body>
	</html>