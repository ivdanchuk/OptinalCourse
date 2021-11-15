<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/w2/css/bootstrap.min.css">   		
        <script src="/w2/js/bootstrap.min.js"></script>     
    </head>

<body>
        <div class="container">
            <form action="/w2/controller" method="get"  role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="${command}">
                <input type="hidden" id="userId" name="userId" value="${userId}">
                <input type="hidden" id="courseId" name="courseId" value="${courseId}">

                <h2>Topic</h2>
                <div class="form-group col-xs-4">


				    <label for="cars">Choose a car:</label>
					<select id="cars" name="cars">
                            <c:forEach var="course" items="${courses}">
								<option value="${course.id}">${course.name}</option>
                            </c:forEach>               
					</select>						

                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                    
                    <table  class="table table-striped">

                    <br></br>
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
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
              
                </div>                                                      
            </form>
        </div>
	</body>
</html>


