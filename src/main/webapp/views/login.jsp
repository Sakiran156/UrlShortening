<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head><title>Login page</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<h2>Login page</h2>
		<div class="container">
			<form action="/login" method="post">
				Email Id:<input type="text" name="email" required/>
				Password:<input type="text" name="password" required/>
				
				<input type="submit" value="login"/></br>
				
				
			</form>
			<c:if test="${not empty error}">
			    <p style="color:red">${error}</p>
			</c:if>
			<p>don't have account ? <a href="/register">register</a></p></br>
			<p>Do you want to go to the Homepage ?<a href="/home">Click Here</a></p>
			
			
		</div>
		
	</body>
</html>