<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
		<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
    </head>

<body>
        <div class="container">
        	 <!--<h2>Topic</h2> -->
			 <br>	
            <form action="/optinal-course/controller" method="post"  role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="reg_user_for_course">
                <input type="hidden" id="userId" name="userId" value="${selectedUser.id}">
				    <label for="course">Choose the course:</label>
					<select id="courseId" name="courseId">
                            <c:forEach var="course" items="${coursesNotStarted}">
								<option value="${course.id}">${course.name}</option>
                            </c:forEach>               
					</select>						
                    <button type="submit" class="btn btn-primary  btn-md">Register</button> 
            </form>
                    
                    <table  class="table table-striped">
                    <br></br>
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Duration</td>
                                    <td>Start date</td>
                                    <td>End date</td>
                                    <td>Topic</td>
                                    <td>Tutor</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="course" items="${coursesNotStarted}">
                                 <tr>
                                    <td>
                                        <a href="controller?id=${course.id}&command=read_course">${course.id}</a>
                                    </td>                                    
                                    <td>${course.name}</td>   
                                    <td>${course.duration}</td>
                                    <td>${course.start_date}</td>
                                    <td>${course.end_date}</td>
                                    
                                    <!-- <td>${course.topic_id}</td> -->
									<c:forEach var="topic" items="${sessionScope.topics}">
										<!--  <option value="${topic.id}">${topic.name}</option> -->
										<c:if test ="${course.topic_id==topic.id}">                        	
                                    		<td>${topic.name}</td>
										</c:if>
		                            </c:forEach>               

                                    <!--  <td>${course.user_id}</td> -->                                                                                      
									<c:forEach var="tutor" items="${sessionScope.tutors}">
										<c:if test ="${course.user_id==tutor.id}">                        	
                                    		<td>${tutor.l_name}</td>
										</c:if>
		                            </c:forEach>               

                                </tr>
                            </c:forEach>               
                        </table>                
                </div>                                                      
</body>
</html>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>


