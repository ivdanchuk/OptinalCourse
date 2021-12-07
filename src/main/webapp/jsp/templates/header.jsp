<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<head>
	<link rel="stylesheet" href="${context}/css/bootstrap.min.css">   		
    <script src="${context}/js/bootstrap.min.js"></script>     

	<title>W3.CSS</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<div class="w3-container">
		<h2><fmt:message key="main.title"/> </h2>
		<p style="text-align:left;">
		    <span style="float:right;">
		    	<my:user/>	
		    </span>
		</p>
		<div class="w3-bar w3-light-grey w3-border">
				<c:choose>
    			<c:when test="${currentRole.id=='2'}">
					<a href="${context}/controller?command=show_tutor_reg_form"
					class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.mytutoring"/></a> 
    			</c:when>    
    			<c:when test="${currentRole.id=='3'}">
					<a href="${context}/controller?command=read_student_courses"
					class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.mylearning"/></a> 
    			</c:when>    
    			<c:otherwise>
					<!--
					-->
					<a href="${context}/controller?command=read_users"
					class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.users"/></a> 
					  	
					<a href="${context}/controller?command=show_tutor_reg_form"
					class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.mytutoring"/></a> 

					<a href="${context}/controller?command=read_student_courses"
					class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.mylearning"/></a> 
        		</c:otherwise>
				</c:choose>
				
				<a href="${context}/controller?command=read_topics"
				class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.utopics"/></a> 
				
				<a href="${context}/controller?command=read_courses"
				class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.ucourses"/></a> 
				
				<a href="${context}/controller?command=read_user&userIdForUpdate=${currentUser.id}"
				class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.myaccount"/></a> 
				
				<a href="${context}/controller?command=logout"
				class="w3-bar-item w3-button w3-mobile"><fmt:message key="main.menu.button.logout"/>
				</a> 
				
				<input type="text" class="w3-bar-item w3-input w3-white w3-mobile"
					placeholder="Search..">
				<button class="w3-bar-item w3-button w3-green w3-mobile">Go</button>
							 	
			 	<form action="${context}/controller">
					<input type="hidden" name="command" value="i18n" />
			      	<label for="langParam"></label>	
	      			<select id="langParam" name="langParam" onchange="this.form.submit()" class="w3-bar-item w3-button w3-white w3-mobile">
						<c:choose>
						    <c:when test="${defaultLocale=='ru'}">
								<option selected="selected">ru</option>
								<option>en</option>
						    </c:when>    
						    <c:otherwise>
								<option selected="selected">en</option>
								<option>ru</option>
						    </c:otherwise>
						</c:choose>
	      			</select>			  
			  </form>				
		</div>
	</div>
</body>

</html>