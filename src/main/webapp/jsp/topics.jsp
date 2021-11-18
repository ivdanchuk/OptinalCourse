<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>
	<body>
		<div class="container">
		<h2>Topics</h2>
         <!--Topics List-->
    
            <form action="controller" method="post" id="topicsForm" role="form" >              
                <input type="hidden" id="id" name="id">
                <input type="hidden" id="command" name="command">
                <c:choose>
                    <c:when test="${not empty topics}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="topic" items="${topics}">
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="controller?id=${topic.id}&command=read_topic">${topic.id}</a>
                                    </td>                                    
                                    <td>${topic.name}</td>   
                                    <td><a href="#" id="delete" 
                                           onclick="document.getElementById('command').value ='delete_topic';
                                           document.getElementById('id').value = '${topic.id}';
                                           document.getElementById('topicsForm').submit();"> 
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
                            No topics found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/topic.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New topic</button> 
            </form>
		</div>
	</body>
</html>