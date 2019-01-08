<%@page import="java.util.List"%>
<%@page import="it.linksmt.teamshare.business.dtos.TeamDto"%>
<%@page
	import="it.linksmt.teamshare.business.dto.request.TeamRequestDto"%>
<%-- <%@page import="it.linksmt.teamshare.business.services.impl.UserServiceImpl"%> --%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<style>
.glyphicon {
	margin-right: 1em;
}
</style>
<title>Teams</title>
</head>
<body>
	<%
		List<TeamDto> teams = (List<TeamDto>) request.getAttribute("team");
		Integer idTeam = 0;
		String teamName = "";
		String teamNameSpaziato = "";
		Integer counter = 0;
	%>
	<div class="container">

		<table class="table h3">
			<thead class="thead-dark">
				<tr>
					<th scope="col-sm">#</th>
					<th scope="col-sm">Team name</th>
					<th scope="col-sm">Edit/Delete</th>
				</tr>
			</thead>
			<%
				for (TeamDto team : teams) {
					idTeam = team.getId();
					teamName = team.getName();
					teamNameSpaziato = team.getName();
					teamName = teamName.replaceAll("\\s+", "");
			%>
			<tbody>
				<tr>
					<th scope="row">
						<%
							counter++;
								out.write(Integer.toString(counter));
						%>
					</th>
					<td>
						<%
							out.write(team.getName());
						%>
					</td>
					<td>
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#edit<%=teamName%>" value="<%=idTeam%>">
							<span class="glyphicon glyphicon-pencil h3"></span>
						</button>

						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#delete<%=teamName%>" value="<%=idTeam%>">
							<span class="glyphicon glyphicon-trash h3"></span>
						</button>
						<div class="modal fade h3" id="edit<%=teamName%>" tabindex="-1"
							role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Edit team
											name</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body h3">
										<form action="teamUpdate" method="post">
											<div class="form-group">
												<input class="d-none form-control" type="number"
													name="idUpdate" id="idUpdate" value="<%=idTeam%>">
												Previous name: <strong> <%=teamNameSpaziato%>
												</strong> <br> <label for="nameUpdate" class="col-form-label">New
													name:</label> <input type="text" class="form-control"
													name="nameUpdate" id="nameUpdate">
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Save
														changes</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<div class="modal fade h3" id="delete<%=teamName%>" tabindex="-1"
							role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Confirm
											deletion</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body h3">
										<form action="teamDelete" method="POST">
											<div>
												<input class="d-none form-control" type="number"
													name="idDelete" id="idDelete" value="<%=idTeam%>">
												<strong>Delete team <%=teamName%>?
												</strong>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">No</button>
												<button type="submit" class="btn btn-primary">Yes</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

						<div class="modal fade h3" id="addTeam" tabindex="-1"
							role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Add team</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body h3">
										<form action="team" method="post">
											<div class="form-group">

												<strong> Enter the team name </strong> <br> <label
													for="name" class="col-form-label">New name:</label> <input
													type="text" class="form-control" id="name" name="name"
													placeholder="Enter the name">
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Add team</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</td>

				</tr>

			</tbody>

			<%
				}
			%>
		</table>
		<button type="button" class="btn btn-default" data-toggle="modal"
			data-target="#addTeam">
			<span class="glyphicon glyphicon-plus h3"></span>
		</button>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
</html>

<%-- 			<% out.write(userService.getUser(act.getIdUserCreator()).getFirstName()+ " "
 		    		  + userService.getUser(act.getIdUserCreator()).getLastName()); %>
 		    		  -----------------------
 		    		  <% out.write(userService.getUser(act.getIdUserAssignee()).getFirstName()+ " "
		    		  + userService.getUser(act.getIdUserAssignee()).getLastName()); %>
 		    		   --%>