<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>

	<style>
        body {
            background: linear-gradient(to right, #F7D060, #FF6D60);
        }

		h1 {
			color: white;
			font-weight: bold;
			font-size: 0.5rem;
		}

		h2 {
			color: white;
			font-weight: bold;
			font-size: 1.0rem;
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
<centre>
<h1>Error</h1>
<h2><%=exception.getMessage() %></h2>
</centre>
</body>
</html>