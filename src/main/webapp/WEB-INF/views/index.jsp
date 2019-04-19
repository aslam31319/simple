<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="resources/download.png">
<meta charset="UTF-8">
<!--CSS-->

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/jquery/jquery-ui.min.css">
<link rel="stylesheet" href="resources/main.css">
<title>Title of the document</title>
</head>

<body>


    <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #ed562d;">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><img src="resources/logo.png"
					alt="" height="30px" ></li>


			</ul>
			<ul class="navbar-nav ml-auto">

				<li class="nav-item " ><a class="nav-link" href="login?error=false" id="login">Login </a></li>
				<li class="nav-item " ><a class="nav-link" href="regp" id="register">Register</a></li>

			</ul>

		</div>
	</nav>


    
    


            
        

    <div class='console-container'>
        <span id='text'></span>
        <div class='console-underscore' id='console'>&#95;</div>
    </div>


    
    


<!--JavaScript-->

<script src="resources/jquery/jquery-3.3.1.min.js"></script>
<script src="resources/jquery/jquery-ui.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/jquery/popper.min.js"></script>
<script src="resources/animation.js"></script>

</body>

</html>