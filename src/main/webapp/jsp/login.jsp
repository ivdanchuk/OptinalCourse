<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head><title>Login</title>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<div class="container">
	<br>
	<form name="loginForm" method="POST" action="/optinal-course/controller">
		<input type="hidden" id ="command" name="command" value="login" />
		
		<!--  Login:<br/> 
		<input type="text" name="login" value=""/ size="20">
		class="form-control"
		-->

        <label for="email" class="control-label col-xs-4">Email:</label>
        <br>                   
        <input type="email" name="login" id="login"  
        pattern="[a-zA-Z0-9._]+@[a-z0-9.-]+\.[a-z]{2,}$" value="" 
        placeholder="smith@aol.com" required="true"/ 
        maxlength="32" minlength="10">

		
		<br/>Password:<br/>	
		<input type="password" name="password" value=""/>
		<br/><br/>

	 	<input type="submit" value="Sign in" style="margin-right:50px"/>
		<input type = "submit" value="Sign up" onclick = "document.getElementById('command').value = 'signup'"/>

	</form>
		

	<hr/><br>
	${errorLoginPassMessage}
	<br/>
	${wrongAction}
	<br/>
	${nullPage}
	<br/>
	<br/>
	admin@admin.com maksym@gmail.com ivdanchuk@gmail.com !!!
	<br/>	
</div>
</body></html>