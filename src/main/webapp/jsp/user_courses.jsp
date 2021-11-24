<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	</head>

	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>

	<body>
		
		<div class="container">
			<br>
			<h2>My learning</h2>
			<br>

            <!--Get option Form--> 
            <form class="form-inline" form action="controller" method="get" id="userCoursesForm" role="form" >              
    		<input type="hidden" id="command" name="command" value="read_user_courses">  
    		<input type="hidden" id="courseId" name="courseId" value="">
			<div class="form-group mb-2 mr-sm-2">

			     <label class="form-check-label" for="radio1">
					<c:choose>
					    <c:when test="${getOption=='1'}">
			        		<input type="radio" class="form-check-input" id="radio1" name="getOption" value="1" checked>Not started
					    </c:when>    
					    <c:otherwise>
			        		<input type="radio" class="form-check-input" id="radio1" name="getOption" value="1">Not started
					    </c:otherwise>
					</c:choose>
			      </label>

			      <label class="form-check-label" for="radio2">
					<c:choose>
					    <c:when test="${getOption=='2'}">
			        		<input type="radio" class="form-check-input" id="radio2" name="getOption" value="2" checked>In progress
					    </c:when>    
					    <c:otherwise>
			        		<input type="radio" class="form-check-input" id="radio2" name="getOption" value="2">In progress
					    </c:otherwise>
					</c:choose>
				  </label>
			      
			      <label class="form-check-label" for="radio3">
					<c:choose>
					    <c:when test="${getOption=='3'}">
			        		<input type="radio" class="form-check-input" id="radio3" name="getOption" value="3" checked>Finished

					    </c:when>    
					    <c:otherwise>
			        		<input type="radio" class="form-check-input" id="radio3" name="getOption" value="3">Finished

					    </c:otherwise>
					</c:choose>
			      
			      </label>

			      <label class="form-check-label" for="radio4">
					<c:choose>
					    <c:when test="${getOption=='0'}">
			        <input type="radio" class="form-check-input" id="radio3" name="getOption" value="0" checked>Get all

					    </c:when>    
					    <c:otherwise>
			        <input type="radio" class="form-check-input" id="radio3" name="getOption" value="0">Get all

					    </c:otherwise>
					</c:choose>


			      </label>

			</div>
			  <button type="submit" class="btn btn-primary mb-2">Filter courses</button>

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
                                    <td>State</td>
                                    <td>Mark</td>
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
                                    <td>${course.state}</td>
                                    <td>${course.mark}</td>
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
</body>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>
</html>