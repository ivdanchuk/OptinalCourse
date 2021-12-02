<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
 	   	<c:set var="context" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${context}/css/bootstrap.min.css">   		
        <script src="${context}/js/bootstrap.min.js"></script>     
    </head>
<body>
        <div class="container">
            	<form action="${context}/controller" method="get"  id="signupForm" role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="signup">                

				<h3>Signup student</h3> 

                <div class="form-group col-xs-4">
                    <label for="email" class="control-label col-xs-4">Email:</label>                   
                    <input type="email" name="email" id="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="" placeholder="smith@aol.com" required="true"/>

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="f_name" id="f_name" class="form-control" pattern="[a-zA-Zа-яА-Я0-9]{4,}" value="" required="true"/>                                   

                    <label for="lastName" class="control-label col-xs-4">Last name:</label>                   
                    <input type="text" name="l_name" id="l_name" class="form-control" pattern="[a-zA-Zа-яА-Я0-9]{4,}" value="" required="true"/> 

                    <label for="password" class="control-label col-xs-4">Password:</label>                   
                    <input type="password" name="password" id="password" class="form-control" pattern="[a-zA-Z0-9]{3,16}" value="" required="true"/> 
					<!--  
                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="role_id" id="role_id" class="form-control" value="" required="true"/> 
                    <label for="role" class="control-label col-xs-4">Role:</label>                    
					<select class="form-control" id="role_id" name="role_id">
							<c:forEach var="role" items="${roles}">
								<option value="${role.id}">${role.name}</option>
                            </c:forEach>               
					</select>						
					-->
	
                    <br>
                    <button type="submit" class="btn btn-primary  btn-md">Sign up</button> 
                </div>                                                      				
            </form>
        </div>
<br>
</body>
</html>


