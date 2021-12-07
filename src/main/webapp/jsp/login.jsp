<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><head><title>Login</title>
<head>
 	<c:set var="context" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${context}/css/bootstrap.min.css">   		
	<script src="${context}/js/bootstrap.min.js"></script>     
</head>
</head>
<body>
<div class="container">
	<br>
	<div class="form-group col-xs-3">
		<form name="loginForm" method="post" action="${context}/controller">
			<input type="hidden" id ="command" name="command" value="login" />
	
			<label for="email" class="control-label col-xs-4">Email:</label>
	        <br>                   
	        <input type="email" class="form-control" name="login" id="login"  
	        pattern="[a-zA-Z0-9._]+@[a-z0-9.-]+\.[a-z]{2,}$" value=""placeholder="smith@aol.com" required="true" maxlength="64" minlength="10">
			
			<br/>	
			<label for="password" class="control-label col-xs-4">Password:</label>
			<br/>
			<input type="password" class="form-control" name="password" pattern="[a-zA-Z0-9]{3,32}" required="true" value=""/>
			<br/>
		 	
		 	<input type="submit" class="btn btn-primary  btn-md" value="Sign in" style="margin-right:50px"/>
		</form>
		<hr/>
		<input type = "button" class="btn btn-primary  btn-md" value="Sign up" onclick = "location.href='${context}/jsp/signup.jsp'"/>
		<br><br>	
		${errorLoginPassMessage}
		<br/>
		${wrongAction}
		<br/>
		${nullPage}
		<br/><br/>	
		Admin: admin@admin.com 
		<br>
		Tutor: maksym@gmail.com, dmytro@gmail.com, tutor2@gmail.com  
		<br>
		Student: ivdanchuk@gmail.com, ivanov@gmail.com, victor@gmail.ua
		<br><br>

	</div>
</body></html>