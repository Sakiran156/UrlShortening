<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head><title>Register</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<h2>Register page</h2>
		<div class="container">
		<form action="/register" method="post">
			Email Id:<input type="text" name="email"/>
			Password:<input type="text" name="password"/>
			
			<input type="submit" value="register"/></br>
		</form>
		
		
		<c:if test="${not empty message}">
		    <p style="color:green">${message}</p>
		</c:if>
		
		<p>already have an account ?<a href="/login">login</a></p></br>
		<p>Do you want to go to the Homepage ?<a href="/home">Click Here</a></p>
		</div>	
	</body>
</html>