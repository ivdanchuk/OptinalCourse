<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css">   		
		<script src="js/bootstrap.min.js"></script>       
	</head>
	<body>
		<div class="container">
		<h2>Users</h2>
		<!-- -->
            <!--Search Form -->
            <form action="controller" method="get" id="seachUsersForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="userName" id="userName" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>                    
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
    
            <form action="controller" method="post" id="usersForm" role="form" >              
                <input type="hidden" id="id" name="id">
                <input type="hidden" id="command" name="command">
                <c:choose>
                    <c:when test="${not empty users}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>E-mail</td>
                                    <td>Name</td>
                                    <td>Last name</td>
                                    <td>Role</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <c:forEach var="user" items="${users}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${id == user.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="controller?userId=${user.id}&command=read_user">${user.id}</a>
                                    </td>                                    
                                    <td>${user.email}</td>   
                                    <td>${user.f_name}</td>
                                    <td>${user.l_name}</td>
                                    <td>${user.role_id}</td>
                                    <td><a href="#" id="delete" 
                                           onclick="document.getElementById('command').value ='delete_user';
                                           document.getElementById('id').value = '${user.id}';
                                           document.getElementById('usersForm').submit();"> 
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
                            No users found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/new_user.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">New user</button> 
            </form>
		</div>
<a href="/optinal-course/controller?command=read_users">Users</a>
<a href="/optinal-course/controller?command=read_topics">Topics</a>
<a href="/optinal-course/controller?command=read_courses">Courses</a>
<a href="/optinal-course/controller?command=logout">Logout</a>
<br>
You are logged as: ${currentUser}, role is ${currentRole}  
<br>
Selected user is: ${selectedUser}
<br>
</body>
</html>