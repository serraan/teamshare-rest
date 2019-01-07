<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>Activities</title>
</head>
<body>

	<div class="container">
		
		<h4>Insert a value to search or leave it empty to show all</h4>
		<form action="Act" method="get">
		  <div class="form-group">
		    <label for="id">Activity's id: </label>
		    <input type="number" class="form-control" id="id" name="id" placeholder="Enter an ID">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		 </form>
		 
		 <h4>Insert the value to add an activity</h4>
		<form action="Act" method="post">
		  <div class="form-group">
		  	<label for="title">Title: </label>
		    <input type="text" class="form-control" id="title" name="title" placeholder="Enter the Title">
		   	<label for="description">Description: </label>
		    <input type="text" class="form-control" id="description" name="description" placeholder="Enter the Description">
		    <label for="type">Type: </label>
		    <input type="text" class="form-control" id="type" name="type" placeholder="Enter the Type">
		    <label for="priority">Priority: </label>
		    <input type="text" class="form-control" id="priority" name="priority" placeholder="Enter the Priority">
		    <label for="userCreator">User Creator: </label>
		    <input type="number" class="form-control" id="userCreator" name="userCreator" placeholder="Enter the User Creator">
		    <label for="userAssignee">User Assignee: </label>
		    <input type="number" class="form-control" id="userAssignee" name="userAssignee" placeholder="Enter the User Assignee">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		 </form>
		 
		 <h4>Delete An Activity</h4>
		 <form action="Act" method="delete">
		  <div class="form-group">
		  	<label for="idDelete">ID: </label>
		  	<input type="number" name="idDelete" id="idDelete" class="form-control" placeholder="Enter the ID that you want to Delete">
		  	<button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		 </form>
		 
	</div>
	
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</html>