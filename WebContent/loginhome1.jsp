<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Online Furniture Store</title>
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


				<li><input type="submit" class="btn btn-primary"
					value="welcome ${name}"></li>

				<form action="show" method="get">
					<li><input type="submit" class="btn btn-primary"
						value="Logout" name="action"></li>
				</form>

			</ul>

		</div>
	</nav>

	<center>
		<h1 style="color: red">OUR SERVICES</h1>
	</center>
	<br>
	<br>
	<br>

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
								<img src="images/formal1.jpeg" class="img-responsive">
							</div>
							<div class="col-xs-4">
								<img src="images/formal2.jpeg" class="img-responsive">
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

			<form method="get" action="show">
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
			<!-- <div> -->
			<form action="show" method="get">
				<table cellspacing="0" cellpadding="10px" class="table table-hover">
					<tr>
						<th>Image</th>
						<th>Name</th>
						<th>UnitPrice</th>
						<th>Quantity</th>

					</tr>
					<c:forEach items="${items}" var="pl">
						<tr>
							<td><img src="images/${pl.getKey().image_url}" width="300px"
								height="250px" /></td>

							<td>${pl.getKey().name}</td>
							<td>${pl.getKey().price}</td>
							<td><input type="number" name="quant" value="${pl.getValue()}" max="10" /></td>


						</tr>
						<input type="hidden" name="ids" value="${pl.getKey().id}" />
					</c:forEach>
				</table>
				&nbsp&nbsp<input type="submit" class="btn btn-primary" name="action" value="AddToCart" />
			</form>
			<br> <br> <br>
</body>
</html>