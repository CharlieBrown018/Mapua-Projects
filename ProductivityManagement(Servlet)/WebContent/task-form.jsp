<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Tasks</title>
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
	<div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${task != null}">
                    <form action="update" method="POST">
                        <caption>
                            <h2>Edit Task</h2>
                        </caption>
                        <input type="hidden" name="task_id" value="<c:out value='${task.task_id}' />" />
                </c:if>
                <c:if test="${task == null}">
                    <form action="insert" method="POST">
                        <caption>
                            <h2>Add New Task</h2>
                        </caption>
                </c:if>

				<fieldset class="form-group">
					<label>Task Name</label> <input type="text"
						value="<c:out value='${task.task_name}' />" class="form-control"
						name="task_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Task Type</label> <input type="text"
						value="<c:out value='${task.task_type}' />" class="form-control"
						name="task_type">
				</fieldset>

				<fieldset class="form-group">
					<label>Task Status</label> <input type="text"
						value="<c:out value='${tast.task_status}' />" class="form-control"
						name="task_status">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Task Due Date</label> <input type="date"
						value="<c:out value='${tast.task_duedate}' />" class="form-control"
						name="task_duedate">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</html>