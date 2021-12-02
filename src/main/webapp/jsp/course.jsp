<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
<body>
        <div class="container">
				<br>
                <h2>University course details</h2>
				<br>
				
            	<form action="/optinal-course/controller" method="post" role="form" data-toggle="validator" >
               	<input type="hidden" id="command" name="command" value="update_course">
                <input type="hidden" id="id" name="id" value="${course.id}">
                
                <div class="form-group col-xs-4">

                    <label for="name" class="control-label">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" pattern="[A-Za-z0-9#+,\s]{2,128}" value="${course.name}" required="true"/>                                   
                    
                    <label for="duration" class="control-label">Duration (h):</label>
                    <input type="number" name="duration" id="duration" min="1" max="100" class="form-control" value="${course.duration}" required="false"/>                                   
					
                    <label for="Start date" class="control-label">Start date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="start_date" id="start_date" class="form-control" value="${course.start_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>

                    <label for="End date" class="control-label">End date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="end_date" id="end_date" class="form-control" value="${course.end_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>
                    
					<label for="Topic" class="control-label">Select topic:</label>
					<select class="form-control" id="topic_id" name="topic_id">
							<c:forEach var="topic" items="${topics}">
								<c:choose>
								    <c:when test="${course.topic_id==topic.id}">
										<option selected="selected" value="${topic.id}">${topic.name}</option>
								    </c:when>    
								    <c:otherwise>
										<option value="${topic.id}">${topic.name}</option>
								    </c:otherwise>
								</c:choose>
                            </c:forEach>               
							
					</select>						

					<label for="Tutor" class="control-label">Select tutor:</label>
					<select class="form-control" id="user_id" name="user_id">
                            <c:forEach var="tutor" items="${tutors}">
								<c:choose>
								    <c:when test="${course.user_id==tutor.id}">
										<option selected="selected" value="${tutor.id}">${tutor.f_name},${tutor.l_name}</option>
								    </c:when>    
								    <c:otherwise>
										<option value="${tutor.id}">${tutor.f_name},${tutor.l_name}</option>
								    </c:otherwise>
								</c:choose>
                            </c:forEach>               
					</select>						
                    <br>
                    <button type="submit" class="btn btn-primary  btn-md">Update</button> 
                </div>                                                      
            </form>
        </div>
	</body>
</html>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>


