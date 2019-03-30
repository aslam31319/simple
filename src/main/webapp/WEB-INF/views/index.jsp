<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="resources/download.png">
<link rel="stylesheet" href="resources/main.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/jquery/jquery-ui.min.css">

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
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active lognav" id="lognavli"><a
					class="nav-link" href="#" id="login">Login <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item regnav" id="regnavli"><a class="nav-link"
					href="#" id="register">Register</a></li>

			</ul>

		</div>
	</nav>

	<div class="container-fluid justify-content-center">
		<div class="rew justify-content-center" id="rew1">
			<div class="col-12 col-sm-6 col-md-3">

				<form class="form-container logfor" action="login" method="post">

					<table>
						<tr>
							<td style="text-align: center" colspan="2"><h3>Login</h3></td>
						</tr>
						<tr>
							<td><div class="form-group">
									<label for="exampleInputEmail1">Email :</label></td>
							<td><input type="text" class="form-control" id="email"
								name="email" aria-describedby="emailHelp"
								placeholder="Enter email">
								</div></td>
						</tr>
						<tr>
							<td><div class="form-group">
									<label for="exampleInputPassword1">Password : </label></td>
							<td><input type="password" class="form-control"
								id="password" name="password" placeholder="Password">
								</div></td>
						</tr>
						<tr>
							<td></td>
							<td><label style="color: red">${result }</label></td>
						</tr>
						<tr>
							<td></td>
							<td><label style="color: red"><a class="link"
					href="#" id="forgot">Forgot Password ?</a></label></td>
						</tr>
					</table>
					<button type="submit" style="background-color: grey"
						id="loginsubmit" class="btn btn-primary btn-block" disabled>Login</button>
				</form>
			</div>
		</div>
	</div>
	
	<div class="container-fluid justify-content-center">
		<div class="rew justify-content-center" id="forgotPass" style="display: none">
			<div class="col-12 col-sm-6 col-md-3">

				<form class="form-container logfor" action="forgot" method="post">

					<table>
						<tr>
							<td style="text-align: center" colspan="2"><h3>Forgot Password</h3></td>
						</tr>
						<tr>
							<td><div class="form-group">
									<label for="exampleInputEmail1">Email :</label></td>
							<td><input type="text" class="form-control" id="emailforg"
								name="email" aria-describedby="emailHelp"
								placeholder="Enter email">
								</div></td>
						</tr>
						
					</table>
					<button type="submit" style="background-color: grey"
						id="forgotsubmit" class="btn btn-primary btn-block" disabled>Submit</button>
				</form>
			</div>
		</div>
	</div>


	<!--registration form-->


	<div class="container-fluid reg">
		<div class="raw justify-content-center" id="raw1"
			style="display: none">
			<div class="col-12 col-sm-6 col-md-3">
				<form class="form-container justify-content-center regfor"
					action="register" method="post" id="regis">


					<table>
						<tr>
							<td style="text-align: center" colspan="2"><h3>Registration</h3></td>
						</tr>

						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Fisrt
										Name :</label></td>
							<td><input type="text" class="form-control" name="firstName"
								id="firstName" placeholder="First Name">
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Second
										Name :</label></td>
							<td><input type="text" class="form-control" name="lastName"
								id="lastName" placeholder="Last Name">
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Phone
										:</label></td>
							<td><input type="text" class="form-control" name="phone"
								id="phone" placeholder="Phone" maxlength="10">
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Email
										:</label></td>
							<td><input type="text" class="form-control" name="email"
								id="emailreg" aria-describedby="emailHelp"
								placeholder="Enter email">
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Password
										:</label></td>
							<td><input type="password" name="password"
								class="form-control" id="passwordreg" placeholder="Password">
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><label id="emailHelp"
								class="form-text text-muted">Gender :</label></td>
							<td><div class="form-group btn-group btn-group-toggle"
									data-toggle="buttons">

									<label class="btn btn-secondary active gender4 btn-sm">
										<input type="radio" name="gender" value="Male" id="gender1"
										autocomplete="off" checked> Male
									</label> <label class="btn btn-secondary gender4 btn-sm"> <input
										type="radio" name="gender" value="Female" id="gender2"
										autocomplete="off"> Female
									</label>
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="input-group mb-3"
									style="margin-top: 2px">
									<label id="emailHelp" class="form-text text-muted">Date
										of Birth : <br>
									</label></td>
							<td><input type="text" class="dob-control" id="DOB"
								placeholder="Date of birth" name="DOB" size="15"
								aria-label="Recipient's username"
								aria-describedby="basic-addon2" readonly>
								<div class="input-group-append"></div>
								</div></td>

						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">Country
										:</label></td>
							<td><select id="country" name="country"
								class="btn btn-secondary btn-sm">

									<option value="Nil">Choose your country</option>

							</select>
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="emailHelp" class="form-text text-muted">State:</label></td>
							<td><select name="state" id="state"
								class="btn btn-secondary btn-sm state" disabled>
									<option value="Nill">Choose your state</option>

							</select>
								</div></td>
						</tr>
						<tr>
							<td style="text-align: right"><div class="form-group">
									<label id="City" class="form-text text-muted">City:</label></td>
							<td><select name="city" id="city"
								class="btn btn-secondary btn-sm state" disabled>
									<option value="Nill">Choose your city</option>

							</select>
								</div></td>
						</tr>
					</table>



					<button type="submit" style="background-color: grey"
						class="btn btn-primary btn-block" id="btnreg" disabled="disabled">Register</button>
				</form>

			</div>
		</div>

	</div>


	<script src="resources/jquery/jquery-3.3.1.min.js"></script>
	<script src="resources/jquery/jquery-ui.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/jquery/popper.min.js"></script>

	<script src="resources/main.js"></script>
</body>

</html>