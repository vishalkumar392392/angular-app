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

	<form action="show" method="get">
		<table cellspacing="0" cellpadding="10px" class="table table-hover">
			<tr>
				<th>ItemId</th>
				<th>Image</th>
				<th>Name</th>
				<th>UnitPrice</th>
				<th>Quantity</th>

			</tr>
			<c:forEach items="${map}" var="m">
				<tr>
					<td>${m.getValue().getId()}</td>
					<td><img src="images/${m.getValue().getImage_url()}"
						width="300px" height="250px" /></td>

					<td>${m.getValue().name}</td>
					<td>${m.getValue().price}</td>
					<td>${m.getKey()}</td>


				</tr>

			</c:forEach>
		</table>
		
		<br>
		<br>
		<br>
		<center><h1 style="color: green">Total Amount :${price}</h1><br>
		<br>
		<br>
		<input type="submit" class="btn btn-primary" name="action" value="PlaceOrder" />
		<br>
		<br>
		<br>
		<input type="submit" class="btn btn-primary" name="action" value="MoreShopping" /></center>
		<br>
		<br>
		<br>
	</form>
































</body>
</html>