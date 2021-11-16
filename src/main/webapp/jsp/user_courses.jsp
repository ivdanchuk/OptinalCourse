<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>
	<body>
		<div class="container">
		<h2>User courses</h2>
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
	<a href="/optinal-course/controller?command=read_users">Users</a>
	<a href="/optinal-course/controller?command=read_topics">Topics</a>
	<a href="/optinal-course/controller?command=read_userCourses">Courses</a>
	<a href="/optinal-course/controller?command=logout">Logout</a>
<br	>
You are logged as ${currentUser}, role is ${currentRole}  
<br	>
User courses are: ${userCourses}
<br>
Command is ${command}

	</body>
</html>