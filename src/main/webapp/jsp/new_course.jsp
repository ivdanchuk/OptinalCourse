<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
<body>
        <div class="container">
            	<form action="${context}/controller" method="post" role="form" data-toggle="validator" >
               	<input type="hidden" id="command" name="command" value="create_course">
                <input type="hidden" id="id" name="id" value="">
                
                <h2>New course </h2>
                <div class="form-group col-xs-4">

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" pattern="[A-Za-z0-9#+,\s]{2,128}" value="${course.name}" required="true"/>                                   
                    
                    <label for="duration" class="control-label col-xs-4">Duration (h):</label>
                    <input type="number" name="duration" id="duration" min="1" max="100" class="form-control" value="${course.duration}" required="false"/>                                   
					
                    <label for="Start date" class="control-label col-xs-4">Start date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="start_date" id="start_date" class="form-control" value="${course.start_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>

                    <label for="End date" class="control-label col-xs-4">End date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="end_date" id="end_date" class="form-control" value="${course.end_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>
                    
					<label for="Topic" class="control-label col-xs-4">Select topic:</label>
					<select class="form-control" id="topic_id" name="topic_id">
							<c:forEach var="topic" items="${topics}">
								<option value="${topic.id}">${topic.name}</option>
                            </c:forEach>               							
					</select>						

					<label for="Tutor" class="control-label col-xs-4">Select tutor:</label>
					<select class="form-control" id="user_id" name="user_id">
                            <c:forEach var="tutor" items="${tutors}">
								<option value="${tutor.id}">${tutor.f_name}</option>
                            </c:forEach>               
					</select>						
                    <br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
	</body>
</html>

	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>

