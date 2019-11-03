<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Online MenFashion Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table, th, td {
	border: 2px solid black;
}
</style>

</head>
<body style="background-color: white;">
	<nav class="navbar" style="background-color: #cccc00">


		<div class="container">
			<div class="navbar-header">
				<a><image src="images/ajio.jpg" style="width:60%"></image></a>

			</div>

			<ul class="nav navbar-nav navbar-right">
				<br>

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#Login">Login</button>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#SignUp">SignUp</button>

			</ul>
			<br> <br>
		</div>
	</nav>

	<center>
		<h1 style="color: red">OnlineFashion</h1>
	</center>
	<br>
	<br>
	<br>
	<div class="modal" id="Login">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter Email and Password !</h4>

				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="show" method="get">

						<div class="form-group">
							<label for="email">Email address :</label> <input type="email"
								class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="pwd">Password :</label> <input type="password"
								class="form-control" name="pwd">
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<div class="form-group">
						<input type="submit" class="btn btn-primary" name="action"
							value="Login">
					</div>
				</div>
				</form>

			</div>
		</div>
	</div>
	<div class="modal" id="SignUp">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter Details to Register !</h4>

				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="show" method="get">
						<div class="form-group">
							<label for="name">Name : </label> <input type="text"
								class="form-control" name="name">
						</div>
						<div class="form-group">
							<label for="email">Email address :</label> <input type="email"
								class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="pwd">Password :</label> <input type="password"
								class="form-control" name="pwd">
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<div class="form-group">
						<input type="submit" class="btn btn-primary" name="action"
							value="SignUp">
					</div>
				</div>
				</form>

			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<div class="row">
							<div class="col-xs-4">
								<img src="images/framless2.jpg"  class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/rayban.jpg"  class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/round_Black Matte.jpg"  class="img-responsive">
							</div>
						</div>
					</div>
					<div class="item">
						<div class="row">
							<div class="col-xs-4">
								<img src="images/formal1.jpeg" class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/formal2.jpeg"   class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/formal2.jpeg" class="img-responsive">
							</div>
						</div>
					</div>
					<div class="item">
						<div class="row">
							<div class="col-xs-4">
								<img src="images/watch1.jpeg" class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/watch2.jpeg" class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/watch3.jpeg" class="img-responsive">
							</div>
						</div>

					</div>

					<div class="item">
						<div class="row">
							<div class="row">
								<div class="col-xs-4">
									<img src="images/sports1.jpeg" class="img-responsive">
								</div>
								<div class="col-xs-4">
									<img src="images/sports2.jpeg" class="img-responsive">
								</div>
								<div class="col-xs-4">
									<img src="images/sports3.jpeg" class="img-responsive">
								</div>
							</div>
						</div>
					</div>

					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!-- End of carousel -->
			<br> <br> <br> <br> <br> <br>

			<form method="post" action="show">
				<div class="column">

					<div class="col-sm-3">
						<b>Select Category :</b> <select class="form-control"
							style="width: 200px;" name="category">
							<option value="-1">Select Category</option>
							
							<c:forEach items="${list}" var="cl">
								<option value="${cl}">${cl}</option>
							</c:forEach>



						</select>
					</div>
					
					<div class="col-sm-2">
						<br> <input type="submit" class="btn btn-primary"
							name="action" value="Go" style="float: center;" />
					</div>
				</div>


			</form>

			<br> <br> <br>
			<div>
			<table  backcellspacing="0" cellspacing ="10px" class="table table-hover">
					
					<tr>
					
					<th>Image</th>
					<th>Name</th>
					<th>UnitPrice</th>
					</tr>
					
					<c:forEach items="${items}" var="it">
					<tr>
					
					<td><img src="images/${it.image_url} " width="200px" height="150px"/></td>
					<td>${it.name}</td>
					<td>${it.price}</td>
					</tr>
					
					
					
					</c:forEach>
					
					
					</table>
			
			</div>
			
			
			
			
</body>
</html>