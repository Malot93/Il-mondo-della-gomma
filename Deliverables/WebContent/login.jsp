
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>Il Mondo della Gomma - Login</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="img/favicon.ico" rel="icon" type="image/x-icon" />


</head>

<body>

	<div id="navbar"></div>
	<div id="centrale">
		<h2 align="center" style="position: relative; top: -40px;">Accedi
			al Gestionale</h2>
		<form action="LoginEffettuatoConSuccessoS" method="post">
			<p style="position: relative; left: 80px;">
				<span>Username:</span><br> <input type="text" name="user"
					id="user" ><br> <br> <span>Password:</span><br>
				<input type="password" name='passww' id="pass" >




			</p>



			<input class="bottone" type="submit" value="Accedi">




		</form>
	</div>


</body>
</html>