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
		<h1 style="color: red">You have Successfully orderd your products</h1>
	</center>
	<center>
		<h1 style="color: green; font-size:100px">Thank You for Visting us &#128525;</h1>
	</center>
	<center>
	<form action="show" method="get">
	<input type="submit" class="btn btn-primary" name="action" value="Go Home"/>
	</form>
	</center>

</body>
</html>