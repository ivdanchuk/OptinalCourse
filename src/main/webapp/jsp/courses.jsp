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
		<h2>Courses</h2>
            <!--Sort option Form--> 
			<form class="form-inline" action="controller" method="get">
            <input type="hidden" id="command" name="command" value="sort_courses">

			<div class="form-group mb-2 mr-sm-2">
		  		<label for="topicId">Select topic:</label>
		  		<select class="form-control" id="topicId" name="topicId">
				    <c:forEach var="topic" items = "${topics}">
				    <option value ="${topic.id}">${topic.name}</option>
		  			</c:forEach>
		  		</select>

		  		<label for="tutorId">Select tutor:</label>
		  		<select class="form-control" id="tutorId" name="tutorId">
				    <c:forEach var="tutor" items = "${tutors}">
				    <option value ="${tutor.id}">${tutor.f_name}</option>
		  			</c:forEach>
		  		</select>
			    
			      <label class="form-check-label" for="radio1">
			        <input type="radio" class="form-check-input" id="radio1" name="sortOption" value="SortbyName" checked>Name
			      </label>
			      <label class="form-check-label" for="radio2">
			        <input type="radio" class="form-check-input" id="radio2" name="sortOption" value="SortbyDuration">Duration
			      </label>
			      <label class="form-check-label" for="radio3">
			        <input type="radio" class="form-check-input" id="radio3" name="sortOption" value="SortbyCount">Count
			      </label>
			</div>
			  <button type="submit" class="btn btn-primary mb-2">Submit</button>
			</form>
       
            <form action="controller" method="post" id="coursesForm" role="form" >              
                <input type="hidden" id="id" name="id">
                <input type="hidden" id="command" name="command">
                <c:choose>
                    <c:when test="${not empty courses}">
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
                                    <td>Count</td>

                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="course" items="${courses}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${id == course.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    
                                    <td>
                                        <a href="controller?id=${course.id}&command=read_course">${course.id}</a>
                                    </td>                                    
                                    <td>${course.name}</td>   
                                    <td>${course.duration}</td>
                                    <td>${course.start_date}</td>
                                    <td>${course.end_date}</td>
                                    <td>${course.topic_id}</td>
                                    <td>${course.user_id}</td>
                                    <td>${course.counter}</td>
                                    <td>
                                        <a href="controller?id=${course.id}&command=delete_course"><span class="glyphicon glyphicon-trash"/></a>
                                    </td>                                    
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No courses found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/new_course.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New course</button> 
            </form>
		</div>
<br> <br>
You are logged as ${currentUser.email}, role is ${currentRole.name}  
<br>
<!--  Tutor's select list ${tutors} -->
</body>
</html>