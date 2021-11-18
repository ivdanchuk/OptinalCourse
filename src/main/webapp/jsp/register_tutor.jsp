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

			<h2>Tutor's register</h2>

			<form class="form-inline" action="/optinal-course/controller">
    		<input type="hidden" id="command" name="command" value="read_users_of_course">  
				<label for="courseId">Course:</label>
						<select class="form-control" id="courseId" name="courseId">
							<c:forEach var="course" items="${tutorCourses}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>               
						</select>								
				<button type="submit" class="btn btn-primary">Select course</button>
			</form>
			
            <form action="controller" method="get" id="tutorReg" role="form" >              
	    		<input type="hidden" id="command" name="command" value="">  
	    		<input type="hidden" id="userId" name="userId" value="">  
	    		<input type="hidden" id="courseId" name="courseId" value="">  
	    		<input type="hidden" id="mark" name="userMark" value="">  

                <c:choose>
                    <c:when test="${not empty usersOfCourse}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>userId</td>
                                    <td>courseId</td>
                                    <td>First name</td>
                                    <td>Last name</td>
                                    <td>Email</td>
                                    <td>Reg.date</td>
                                    <td>Mark</td>
                                </tr>
                            </thead>
                            <c:forEach var="user" items="${usersOfCourse}">
                                <tr>
                                    <td>
                                       ${user.user_id}
                                    </td>                                    
                                    <td>${user.course_id}</td>
                                    <td>${user.f_name}</td>
                                    <td>${user.l_name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.reg_date}</td>
									<td>
                                        <a href="controller?userId=${user.user_id}&courseId=${user.course_id}&command=show_mark_form">${user.mark}</a>
										<!--  <input type="number" id="mark" name="mark" min="0" max="100"value ="${user.mark}">-->	
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
            
		</div>
		<br	>
		You are logged as ${currentUser.email}, your role is ${currentRole.name}
	</body>
</html>