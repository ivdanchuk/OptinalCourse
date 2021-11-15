<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>
	<body>
		<div class="container">
		<h2>Courses</h2>
		<!-- -->
            <!--Search Form -->
            <form action="controller" method="get" id="seachUsersForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="courseName" id="courseName" class="form-control" required="true" placeholder="Type the Name or Last Name of the course"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>

            <!--Users List-->
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
    
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
                                    <td><a href="#" id="delete" 
                                           onclick="document.getElementById('command').value ='delete_course';
                                           document.getElementById('id').value = '${course.id}';
                                           document.getElementById('coursesForm').submit();"> 
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
                            No courses found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/course.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New course</button> 
            </form>
		</div>
<a href="/w2/controller?command=read_users">Users</a>
<a href="/w2/controller?command=read_topics">Topics</a>
<a href="/w2/controller?command=read_courses">Courses</a>
<a href="/w2/controller?command=logout">Logout</a>

	</body>
</html>