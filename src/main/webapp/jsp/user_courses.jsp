<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>

	<title>W3.CSS</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<body>
	  <div class="w3-container">
	  <h2>Optional course</h2>
	
	  <div class="w3-bar w3-light-grey w3-border">
	    <a href="/optinal-course/controller?command=read_users" class="w3-bar-item w3-button w3-mobile">Users</a>
		<a href="/optinal-course/controller?command=read_user_courses" class="w3-bar-item w3-button w3-mobile">My learning</a>
		<a href="/optinal-course/controller?command=show_tutor_reg_form" class="w3-bar-item w3-button w3-mobile">My tutoring</a>
	    <a href="/optinal-course/controller?command=read_topics" class="w3-bar-item w3-button w3-mobile">University topics</a>
	    <a href="/optinal-course/controller?command=read_courses" class="w3-bar-item w3-button w3-mobile">University courses</a>
	    <a href="/optinal-course/controller?command=read_user" class="w3-bar-item w3-button w3-mobile">My account</a>
	    <a href="/optinal-course/controller?command=logout" class="w3-bar-item w3-button w3-mobile">Logout</a>
	
	    <input type="text" class="w3-bar-item w3-input w3-white w3-mobile" placeholder="Search..">
	    <button class="w3-bar-item w3-button w3-green w3-mobile">Go</button>
	  </div>
	
		<div class="container">
		<c:if test ="${currentUser.role_id=='1'}">                        	
			<h2>Admin view</h2>
		</c:if>
		<c:if test ="${currentUser.role_id=='2'}">                        	
			<h2>Tutor's courses</h2>
		</c:if>
		<c:if test ="${currentUser.role_id=='3'}">                        	
			<h2>Student's courses</h2>
		</c:if>

            <form action="controller" method="post" id="userCoursesForm" role="form" >              
    		<input type="hidden" id="command" name="command" value="">  
    		<input type="hidden" id="courseId" name="courseId" value="">
            
                <c:choose>
                    <c:when test="${not empty userCourses}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Duration</td>
                                    <td>Start date</td>
                                    <td>End date</td>
                                    <td>Topic id</td>
                                    <td>Tutor id</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="course" items="${userCourses}">
                                    <td>
                                        <a href="controller?id=${course.id}&command=read_course">${course.id}</a>
                                    </td>                                    
                                    <td>${course.name}</td>   
                                    <td>${course.duration}</td>
                                    <td>${course.start_date}</td>
                                    <td>${course.end_date}</td>
                                    <td>${course.topic_id}</td>
                                    <td>${course.user_id}</td>
                                    <td><a href="#" id="delete" 
                                           onclick="document.getElementById('command').value ='unreg_user_for_course';
                                           document.getElementById('courseId').value = '${course.id}';
                                           document.getElementById('userCoursesForm').submit();"> 
                    	                        <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No user's courses found matching your search criteria.
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            
			<form action ="/optinal-course/jsp/reg_for_course.jsp	" method="get">
                <button type="submit" class="btn btn-primary  btn-md">Register for course</button> 
            </form>

		</div>
<br	>
You are logged as ${currentUser.email}, your role is ${currentRole.name}
</body>
</html>