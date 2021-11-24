<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>

<body>
        <div class="container">
            <form action="/optinal-course/controller" method="post"  id="userForm" role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="update_user">
                <input type="hidden" name="userId" id="userId" class="form-control" value="${selectedUser.id}"/>

				<h3>User details</h3> 
                <div class="form-group col-xs-4">
                    <label for="email" class="control-label col-xs-4">Email:</label>                   
                    <input type="email" name="email" id="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="${selectedUser.email}" placeholder="smith@aol.com" required="true"/ maxlength="64" minlength="10">

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="f_name" id="f_name" class="form-control" pattern="[a-zA-Za-zА-я]{4,}" value="${selectedUser.f_name}" required="true"/>                                   

                    <label for="lastName" class="control-label col-xs-4">Last name:</label>                   
                    <input type="text" name="l_name" id="l_name" class="form-control" pattern="[a-zA-Za-zА-я]{4,}" value="${selectedUser.l_name}" required="true"/> 

                    <label for="password" class="control-label col-xs-4">Password:</label>                   
                    <input type="password" name="password" id="password" class="form-control" pattern="[a-zA-Z0-9]{3,16}" value="${selectedUser.password}" required="true"/> 

                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="role_id" id="role_id" class="form-control" value="${selectedUser.role_id}" required="true"/> 
                    <br>
	                <button type="submit" class="btn btn-primary  btn-md">Update</button> 
                </div>                                                      
            </form>
        </div>
</body>
</html>
	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>



