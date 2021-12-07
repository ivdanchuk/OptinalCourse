<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	</head>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
	<body>
		<div class="container">
		<h2>Courses</h2>

            <!--Select & sort option Form--> 
			<form class="form-inline" action="controller" method="get">
            <input type="hidden" id="command" name="command" value="sort_courses">
			<div class="form-group mb-2 mr-sm-2">
		  		<label for="topicId">Select topic:</label>
		  		<select class="form-control" id="topicId" name="topicId">
						<c:choose>
						     <c:when test="${topicIdForSorting == '0' }" >
								<option selected="selected" value ="0">All topics</option>
						     </c:when>
						     <c:otherwise>
								<option value ="0">All topics</option>
						     </c:otherwise>
						 </c:choose>
					     						     					
				    <c:forEach var="topic" items = "${topics}">
						<c:choose>
						     <c:when test="${topic.id == topicIdForSorting}" >
								<option selected="selected" value ="${topic.id}">${topic.name}</option>
						     </c:when>
						     <c:otherwise>
								<option value ="${topic.id}">${topic.name}</option>
						     </c:otherwise>
						 </c:choose>
		  			</c:forEach>
		  		</select>

		  		<label for="tutorId">Select tutor:</label>
		  		<select class="form-control" id="tutorId" name="tutorId">
						<c:choose>
						     <c:when test="${tutorIdForSorting == '0' }" >
								<option selected="selected" value ="0">All tutors</option>
						     </c:when>
						     <c:otherwise>
								<option value ="0">All tutors</option>
						     </c:otherwise>
						 </c:choose>

				    <c:forEach var="tutor" items = "${tutors}">
						<!--  <option value ="0">All tutors</option> -->
						<c:choose>
						     <c:when test="${tutor.id == tutorIdForSorting}" >
				    			<option selected="selected" value ="${tutor.id}">${tutor.f_name}</option>
						     </c:when>
						     <c:otherwise>
				    			<option value ="${tutor.id}">${tutor.f_name}</option>
						     </c:otherwise>
						 </c:choose>
		  			</c:forEach>
		  		</select>

				<c:if test ="${empty sortOptionForSorting}">                        	
					<c:set var="sortOptionForSorting" scope="session" value="SortbyName"/>
				</c:if>

				  <label class="form-check-label" for="radio1">
						<c:choose>
						     <c:when test="${sortOptionForSorting == 'SortbyName'}" >
			        			<input type="radio" class="form-check-input" id="radio1" name="sortOption" value="SortbyName" checked>Course name
						     </c:when>
						     <c:otherwise>
			        			<input type="radio" class="form-check-input" id="radio1" name="sortOption" value="SortbyName">Course name
						     </c:otherwise>
						 </c:choose>
				</label>

				  <label class="form-check-label" for="radio2">
						<c:choose>
						     <c:when test="${sortOptionForSorting == 'SortbyDuration'}" >
			        			<input type="radio" class="form-check-input" id="radio2" name="sortOption" value="SortbyDuration" checked>Duration
						     </c:when>
						     <c:otherwise>
			        			<input type="radio" class="form-check-input" id="radio2" name="sortOption" value="SortbyDuration">Duration
						     </c:otherwise>
						 </c:choose>
				</label>

			      <label class="form-check-label" for="radio3">
						<c:choose>
						     <c:when test="${sortOptionForSorting == 'SortbyCount'}" >
			        			<input type="radio" class="form-check-input" id="radio3" name="sortOption" value="SortbyCount" checked>Registered
						     </c:when>
						     <c:otherwise>
			        			<input type="radio" class="form-check-input" id="radio3" name="sortOption" value="SortbyCount">Registered
						     </c:otherwise>
						 </c:choose>			        		
			      </label>
			    
			</div>
			  <button type="submit" class="btn btn-primary mb-2">Filter & sort courses</button>
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
                                    <td>Course name</td>
                                    <td>Duration</td>
                                    <td>Start date</td>
                                    <td>End date</td>
                                    <td>Topic</td>
                                    <td>Tutor</td>
                                    <td>Registered</td>
                                    <td>State</td>
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

                                    <!--  <td>${course.topic_id}</td> -->
									<c:forEach var="topic" items="${sessionScope.topics}">
										<c:if test ="${course.topic_id==topic.id}">                        	
                                    		<td>${topic.name}</td>
										</c:if>
		                            </c:forEach>               

                                    <!-- <td>${course.user_id}</td> -->
									<c:forEach var="tutor" items="${sessionScope.tutors}">
										<c:if test ="${course.user_id==tutor.id}">                        	
                                    		<td>${tutor.l_name}</td>
										</c:if>
		                            </c:forEach>               

                                    <td>${course.counter}</td>
                                    <td>${course.state}</td>
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

    		<c:if test ="${currentRole.name !='student'}">                        	
	            <form action ="jsp/new_course.jsp">                            
	                <button type="submit" class="btn btn-primary  btn-md">New course</button> 
	            </form>
			</c:if>
    
		</div>
</body>
</html>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>
	