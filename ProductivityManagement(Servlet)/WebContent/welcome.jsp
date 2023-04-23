<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
	
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
        
        .welcome-message {
	        margin-top: 50px;
	        margin-bottom: 50px;
	        padding: 20px;
	        background-color: #000;
	        border-radius: 10px;
    	}

    	.welcome-message ul {
	        list-style-type: disc;
	        margin: 0 auto;
	        max-width: 500px;
	        font-weight: bold;
	        font-size: 1.2rem;
	        color: #fff;
    	}

    	.welcome-message li {
       	 	margin-bottom: 10px;
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
		<div class="container text-center">
	  		<div class="welcome-message">
	    <h3 style="margin-bottom: 30px;">Welcome to our Web App! With it you can:</h3>
	    <ul>
	      <li>Manage your tasks efficiently</li>
	      <li>Organize your schedule</li>
	      <li>Track IT equipment for academics and home use</li>
	      <li>Set and achieve goals as a developer</li>
	    </ul>
	  		</div>
		</div>

</body>
</html>