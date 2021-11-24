<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
	<body>
	<div class="w3-container">

		<div class="container">
			<br>
			<h2>Tutor's register</h2>
			<br>
			<form class="form-inline" action="/optinal-course/controller">
    		<!--<input type="hidden" id="command" name="command" value="read_users_of_course">-->  
    		<input type="hidden" id="command" name="command" value="show_tutor_reg_form">  

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
	    		<input type="hidden" id="userMark" name="userMark" value="">  

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
                            No user's courses found matching your search criteria.
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            
		</div>
		<br	>
	</body>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>
</html>