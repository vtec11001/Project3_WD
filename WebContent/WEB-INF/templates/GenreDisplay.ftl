<DOCTYPE! HTML>
<html>
<body style = "background-color:beige">
	<table border = "1">
	<tr><th>Movies in DataBase</th></tr>
	<!--create the table that will hold genres-->
	
	<tr>
	<th>Name</th>
	</tr>
	
	<#list genres as gen>
	<tr>
	<td>${gen}</td>
	<!--prints out the genres-->

	</tr>
	</#list>
	
	</table>
</body>
</html>