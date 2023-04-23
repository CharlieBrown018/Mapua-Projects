<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Tasks</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<style>
	
        body {
            background: linear-gradient(to right, #F7D060, #FF6D60);
        }

		h3 {
			color: white;
			font-weight: bold;
			font-size: 1.5rem;
		}
		
		.nav-link {
		    background-color: transparent;
		    color: #fff;
		    padding: 10px 100px;
		    border: 2px solid #fff;
		    border-radius: 15px;
		    transition: background-color 0.3s ease, color 0.3s ease;
		    font-weight: 20;
		}

		.nav-link:hover {
		    background-color: #F7D060;
		    color: #000;
		}
		
		.table {
    		background-color: #fff;
		}
		  
    </style>
	
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #000000">
				<div>
					<a href="<%=request.getContextPath()%>/welcome" class="navbar-brand"> Productivity Management Web Application </a>
				</div>
				
				<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Tasks</a></li>
				</ul>
		</nav>
	</header>
	<br>
	
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Tasks</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Task</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Name</th>
						<th>Task Type</th>
						<th>Task Status</th>
						<th>Task Due Date</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="task" items="${listTask}">

						<tr>
							<td><c:out value="${task.task_id}" /></td>
							<td><c:out value="${task.task_name}" /></td>
							<td><c:out value="${task.task_type}" /></td>
							<td><c:out value="${task.task_status}" /></td>
							<td><c:out value="${task.task_duedate}" /></td>
							<td><a href="edit?task_id=<c:out value='${task.task_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?task_id=<c:out value='${task.task_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>	

</body>
</html>