<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
	<body>
		<div class="container">
			<h2>Tutor's register</h2>
			
			<form class="form-inline" method="get" action="${context}/controller" style ='float: left; padding: 5px;'>
    			<input type="hidden" id="command" name="command" value="show_tutor_reg_form">  
				<label for="courseId">Course:</label>
						<select class="form-control" id="courseId" name="courseId">
							<c:forEach var="course" items="${tutorCourses}">
								<c:choose>
								    <c:when test="${course.id == CourseId}">
										<option value="${course.id}" selected="selected">${course.name}</option>
								    </c:when>    
								    <c:otherwise>
										<option value="${course.id}">${course.name}</option>
								    </c:otherwise>
								</c:choose>								

							</c:forEach>               
						</select>								
				<button type="submit" class="btn btn-primary">Get students of selected course</button>
			</form>
			
			<form class="form-inline" action="${context}/controller" style ='float: left; padding: 5px;'>
    			<input type="hidden" id="command" name="command" value="filter_tutor_courses_by_state">  
				<label for="CourseState">State:</label>
						<c:if test="${empty CourseStateId}">
    						<c:set var="CourseStateId" value="${4}"/>
						</c:if>								
						<select class="form-control" id="CourseStateId" name="CourseStateId">													
							<c:forEach var="courseState" items="${coursesState}">
								<c:choose>
								    <c:when test="${courseState.id == CourseStateId}">
										<option value="${courseState.id}" selected="selected">${courseState.name}</option>								    
								    </c:when>    
								    <c:otherwise>
										<option value="${courseState.id}">${courseState.name}</option>
								    </c:otherwise>
								</c:choose>								
							</c:forEach>               
						</select>								
				
				<button type="submit" class="btn btn-primary">Filter by state</button>
			</form>			
			<br>            

            <form action="controller" method="get" id="tutorReg" role="form" >              
	    		<input type="hidden" id="command" name="command" value="">  
	    		<input type="hidden" id="userId" name="userId" value="">  
	    		<input type="hidden" id="courseId" name="courseId" value="">  
	    		<input type="hidden" id="userMark" name="userMark" value="">  
                <c:choose>
                    <c:when test="${not empty usersOfCourse}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Student id</td>
                                    <td>Course id</td>
                                    <td>First name</td>
                                    <td>Last name</td>
                                    <td>Email</td>
                                    <td>Reg.date</td>
                                    <td>Mark</td>
                                </tr>
                            </thead>

                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="user" items="${usersOfCourse}">
                                <tr>
                                    <c:set var="count" value="${count + 1}"/>
                                    <td>${count}</td>
                                    <td>
                                       ${user.user_id}
                                    </td>                                    
                                    <td>${user.course_id}</td>
                                    <td>${user.f_name}</td>
                                    <td>${user.l_name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.reg_date}</td>
									<td>
                                        <a href="controller?userId=${user.user_id}&courseId=${user.course_id}&command=show_mark_form&userMark=${user.mark}">${user.mark}</a>
										<!--  <input type="number" id="mark" name="mark" min="0" max="100"value ="${user.mark}">-->	
									</td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No student's registered found.
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
    	</div>
		<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>
</body>
</html>