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
        <div class="container">
            <form action="/optinal-course/controller" method="post"  id="userForm" role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="update_user">

				<h3>User details</h3> 
                <div class="form-group col-xs-4">
                    <input type="hidden" name="userId" id="userId" class="form-control" value="${currentUser.id}"/>

                    <label for="email" class="control-label col-xs-4">Email:</label>                   
                    <input type="email" name="email" id="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="${currentUser.email}" placeholder="smith@aol.com" required="true"/>

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="f_name" id="f_name" class="form-control" pattern="[a-zA-Z]{4,}" value="${currentUser.f_name}" required="true"/>                                   

                    <label for="lastName" class="control-label col-xs-4">Last name:</label>                   
                    <input type="text" name="l_name" id="l_name" class="form-control" pattern="[a-zA-Z]{4,}" value="${currentUser.l_name}" required="true"/> 

                    <label for="password" class="control-label col-xs-4">Password:</label>                   
                    <input type="password" name="password" id="password" class="form-control" pattern="[a-zA-Z0-9]{3,16}" value="${currentUser.password}" required="true"/> 

                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="role_id" id="role_id" class="form-control" value="${currentUser.role_id}" required="true"/> 
                    <br>
	                <button type="submit" class="btn btn-primary  btn-md">Update</button> 
                </div>                                                      
            </form>
        </div>
<!--  
        		<div class="container">
                <div class="form-group col-xs-4">
				        <h4>User's courses:</h4> 
            	        <form action="/optinal-course/controller" method="get"  role="form" data-toggle="validator" >             
                			<input type="hidden" id="command" name="command" value="read_user_courses"> 
	                		<button type="submit" class="btn btn-primary  btn-md">My courses</button> 
	                	</form>
       		 	</div>
        		</div>		
-->
You are logged as ${currentUser.email}, your role is ${currentRole.name}
</body>
</html>


