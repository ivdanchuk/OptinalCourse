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
	<!--  

	<h2>User details</h2>
	<form name="CreateUserForm" method="POST" action="/w2/controller">
	<input type="text" id="command" name="command" value="${command}"/>
	<input type="text" id="id" name="id" value="${user.id}"/>
	<input type="text" id="role_id" name="role_id" value="${user.role_id}"/>

  	<fieldset>
    <legend>Personal data</legend>

    <label for="email">Email :</label><br>
    <input type="email" id="email" name="email" value="${user.email}"><br><br>

    <label for="fname">First name:</label><br>
    <input type="text" id="f_name" name="f_name" value="${user.f_name}"><br><br>
   
    <label for="lname">Last name:</label><br>
    <input type="text" id="l_name" name="l_name" value="${user.l_name}"><br><br>

    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password" value="${user.email}"><br><br>

   	<br/>
	${errorLoginPassMessage}
	<br/>
	${wrongAction}
	<br/>
	${nullPage}
	<br/>
    <input type="submit" value="Accept">

  	</fieldset>
	</form>

-->    
        <div class="container">
            <form action="/w2/controller" method="post"  id="userForm" role="form" data-toggle="validator" >
                <c:if test ="${empty command}">                        	
                    <c:set var="command" value="create_user"/>
                </c:if>
                <input type="hidden" id="command" name="command" value="${command}">
                <input type="hidden" id="id" name="id" value="${user.id}">
				<c:choose>
				    <c:when test="${command=='create_user'}">
				        <h1>Add new user</h1> 
				    </c:when>    
				    <c:otherwise>
				        <h1>User details</h1> 
				    </c:otherwise>
				</c:choose>
                <div class="form-group col-xs-4">
                    <label for="email" class="control-label col-xs-4">Email:</label>                   
                    <input type="email" name="email" id="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="${user.email}" placeholder="smith@aol.com" required="true"/>

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="f_name" id="f_name" class="form-control" pattern="[a-zA-Z]{4,}" value="${user.f_name}" required="true"/>                                   

                    <label for="lastName" class="control-label col-xs-4">Last name:</label>                   
                    <input type="text" name="l_name" id="l_name" class="form-control" pattern="[a-zA-Z]{4,}" value="${user.l_name}" required="true"/> 
					<!--  
                    <label for="birthdate" class="control-label col-xs-4">Birth date</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="birthDate" id="birthdate" class="form-control" value="${employee.birthDate}" maxlength="10" placeholder="dd-MM-yyyy" required="true"/>
					-->
                    <label for="password" class="control-label col-xs-4">Password:</label>                   
                    <input type="password" name="password" id="password" class="form-control" pattern="[a-zA-Z0-9]{8,16}" value="${user.password}" required="true"/> 

                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="role_id" id="role_id" class="form-control" value="${user.role_id}" required="true"/> 


                    <br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>

        </div>
        		<div class="container">
                <div class="form-group col-xs-4">
				        <h1>User's courses</h1> 
            	        <form action="/w2/controller" method="get"  role="form" data-toggle="validator" >             
                		<input type="hidden" id="command" name="command" value="read_user_courses">
                		<input type="hidden" id="userId" name="userId" value="${user.id}">
                    	<button type="submit" class="btn btn-primary  btn-md">My courses</button> 
	                	</form>
       		 	</div>
        		</div>		
	</body>
</html>


