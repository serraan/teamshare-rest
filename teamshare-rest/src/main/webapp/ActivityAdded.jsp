<%@page import="java.util.List"%>
<%@page import="it.linksmt.teamshare.business.dto.request.ActivityRequestDto"%>
<%-- <%@page import="it.linksmt.teamshare.business.services.impl.UserServiceImpl"%> --%>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>One Activity Added</title>
</head>
<body>
	<%
		ActivityRequestDto act = (ActivityRequestDto) request.getAttribute("actAdded");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String date;
// 		out.println(act.toString());
		%>
		<div class="container">
			<h3>The Activity <%out.write(act.getTitle()); %> was added with Success</h3>
		</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</html>

<%-- 			<% out.write(userService.getUser(act.getIdUserCreator()).getFirstName()+ " "
 		    		  + userService.getUser(act.getIdUserCreator()).getLastName()); %>
 		    		  -----------------------
 		    		  <% out.write(userService.getUser(act.getIdUserAssignee()).getFirstName()+ " "
		    		  + userService.getUser(act.getIdUserAssignee()).getLastName()); %>
 		    		   --%>