<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/optinal-course/css/bootstrap.min.css">   		
        <script src="/optinal-course/js/bootstrap.min.js"></script>     
    </head>

<body>
	<!--  -->    

        <div class="container">
            <form action="/optinal-course/controller" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty command}">                        	
                    <c:set var="command" value="create_course"/>
                </c:if>
                <input type="hidden" id="command" name="command" value="${command}">
                <input type="hidden" id="id" name="id" value="${course.id}">
                <h2>Course details</h2>
                <div class="form-group col-xs-4">

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" pattern="[A-Za-z0-9#+\s]{2,128}" value="${course.name}" required="true"/>                                   
                    
                    <label for="duration" class="control-label col-xs-4">Duration (h):</label>
                    <input type="number" name="duration" id="duration" min="1" max="100" class="form-control" value="${course.duration}" required="false"/>                                   
					
                    <label for="Start date" class="control-label col-xs-4">Start date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="start_date" id="start_date" class="form-control" value="${course.start_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>

                    <label for="End date" class="control-label col-xs-4">End date</label>                 
                    <input type="date"  pattern="^\d{2}-\d{2}-\d{4}$" name="end_date" id="end_date" class="form-control" value="${course.end_date}" maxlength="10" placeholder="dd-MM-yyyy" required="false"/>
					
					<label for="Select topic" class="control-label col-xs-4">Select topic:</label>
				    <label for="cars">Choose a car:</label>

					<select class="form-control" id="topic_id" name="topic_id">
                            <c:forEach var="topic" items="${topics}">
								<option value="${topic.id}">${topic.name}</option>
                            </c:forEach>               
					</select>						

					<label for="Select tutor" class="control-label col-xs-4">Select tutor:</label>
					<select class="form-control" id="user_id" name="user_id">
                            <c:forEach var="tutor" items="${tutors}">
								<option value="${tutor.id}">${tutor.f_name}</option>
                            </c:forEach>               
					</select>						

<!--  
					<select class="form-control" name="topic_id" id="topic_id">
						<option value="1">Jav</option>
					    <option value="2">C#</option>
					</select>

					<label for="Select tutor" class="control-label col-xs-4">Select tutor:</label>
					<select class="form-control" name="user_id" id="user_id">
						<option value="2">Maksym</option>
					    <option value="3">Dmytro</option>
					</select>
-->							
					<!--              		        
                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="topic_id" id="topic_id" class="form-control" value="${course.topic_id}" required="true"/> 
					-->

                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
	</body>
</html>


