<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>URL Shortener</title>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h2>Url Shortener</h2>
	<div class="container">
		<form action="/shorten-form" method="post">
			Enter Url: <input type="text" name="url" required />
			<input type="submit" value="shorten" />
		</form>
	
		<c:if test="${not empty shortUrl}">
			<div class="result">
				<p>Shortened URl: <a href="${shortUrl}">${shortUrl} </a></p>
			</div>
		</c:if>	
	</div>
</body>	
</html>