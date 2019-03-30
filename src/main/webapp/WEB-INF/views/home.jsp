<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="resources/download.png">
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/main.css">

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/datatables/datatables.css">
<link rel="stylesheet" href="resources/c3.css">
<link rel="stylesheet" href="resources/mydatatables.css">
<title>Welcome Page</title>
</head>
<body class="" bgcolor="white">
<span id="widget">
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
				<li class="nav-item active lognav" id="lognavli"><a
					class="nav-link" href="#" id="logot">${result } <span
						class="sr-only">(current)</span></a></li>
				<input type='hidden' name='useremail' id="useremail" value=${email }>
			</ul>
			<ul class="navbar-nav ml-auto">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><img id="downloadimg"src="resources/download.png"
						height="40px" width="40px"><b class="caret"></b></a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li class="dropdown-item" data-toggle="modal"
							data-target="#myModal" id="pdfli"><a href="#" id="PDF">PDF</a></li>
						<div class="dropdown-divider"></div>
						<li class="dropdown-item" data-toggle="modal"
							data-target="#myModal" id="xlsxli"><a href="#" id="XLSX">XLSX</a></li>
						<div class="dropdown-divider"></div>
						<li class="dropdown-item" data-toggle="modal"
							data-target="#myModal" id="csvli"><a href="#" id="CSV">CSV</a></li>
					</ul></li>
					<li class="nav-link"><img src="resources/cam.png" onclick="generateScreenshot()"
						height="40px" width="40px"></li>
					<li class="nav-link"><input type="button"
					class="btn btn-primary" id="SwitchD" value="Show Table"/></li>
				<li class="nav-link"><a href="logout"
					class="btn btn-primary">Logout</a></li>
			</ul>

		</div>
	</nav>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<img src="resources/user.png" height="40px" width="40px"><br>
					<h6 class="modal-title">${email}</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					What you want to do.... <input type="hidden" value="" id="filetype">
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<a id="downloadlink"><button type="button"
							class="btn btn-secondary" id="downloadbtn">Download</button></a>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" id="emailbtn">Send Email</button>
				</div>

			</div>
		</div>
	</div>

	</div>
	<!-- <form action="uploadFile" method="post" enctype="multipart/form-data">
<input type="file" name="file">
<input type="submit">
</form> -->



	<table id="example" class="table table-striped table-bordered"
		style="width: 95%; background-color: white;" id="tabledata">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Office</th>
				<th>position</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Office</th>
				<th>position</th>
				<th>Salary</th>
			</tr>
		</tfoot>
	</table>
	
	
	

<div class="container" id="containerchart">
  <div class="row">
    <div class="col">
      <div id="lineChart"></div>
    </div>
    <div class="col">
     <div id="barChart"></div>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div id="pieChart" ></div></div>
    
    <div class="col">
     <div id="donutChart"></div>
     </div>
     </div>
    </div>

</span>

	<script src="resources/jquery/jquery-3.3.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

	<script src="resources/jquery/popper.min.js"></script>
	<script src="resources/datatables/datatables.js"></script>
	<script src="resources/d3.js"></script>
	<script src="resources/c3.js"></script>
	
	<script src="resources/html2canvas.js"></script>
	<script src="resources/main.js"></script>
	<script src="resources/download.js"></script>

</body>
</html>