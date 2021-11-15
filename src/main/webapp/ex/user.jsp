<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>

<h2>User details</h2>

<p></p>

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

</body>
</html>


