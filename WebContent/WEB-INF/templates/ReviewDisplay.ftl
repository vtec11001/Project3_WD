<DOCTYPE! HTML>
<html>

<!--used to display the review-->

	<body style = "background-color:beige">
		<table border = "1">
		
		<!--creates table element-->
				<tr><th>Reviews for ${MovNameRev}</th></tr>
					<tr>
						<th>Review</th>
						
						
					</tr>
					
					<#list reviews as rev>
						<tr>
							<td>${rev.getReview()}</td>
						</tr>
						
						<!--iterates through list-->
						
					</#list>
			
					
									
		</table>
	</body>
</html>