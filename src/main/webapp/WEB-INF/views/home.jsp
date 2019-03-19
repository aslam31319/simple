<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/main.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<title>Welcome Page</title>
</head>
<body class="bg">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><img src="resources/spring.svg"
					alt="" height="40px" width="40px"></li>

			</ul>

		</div>
	</nav>



	<h2 align="center" class="res">${result }</h2>
	
	
	<script src="resources/jquery/jquery-3.3.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="resources/jquery/popper.min.js"></script>
	<script src="resources/main.js"></script>
	
</body>
</html>