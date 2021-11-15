<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	ok
	${mes}
	<hr>
	${requestScope.mes}
	<hr>
	${usersList}
	
	<hr>
	${x}
	<hr>	

	<c:forEach var="user" items="${usersList}">
		${user.login}	
		<a href="showFormEditUser?id=${user.id}">edit</a>		
		<a href="controller?command=confirmUserDelete&id=${user.id}">delete</a>		
		
		<br>
	</c:forEach>

	<hr>

	<c:forEach var="entry" items="${usersMap}">
		${entry.key} ==&gt; ${entry.value.login}
		<br>
	</c:forEach>
	
</body>
</html>
