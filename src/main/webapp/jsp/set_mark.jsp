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
            <form action="/optinal-course/controller" method="post"  id="setMarkForm" role="form" data-toggle="validator" >
                <input type="hidden" id="command" name="command" value="set_mark">
                <input type="hidden" id="userId" name="userId" value="${userId}">
                <input type="hidden" id="courseId" name="courseId" value="${courseId}">
                <h3>Set mark for student</h3> 
					<label for="mark">Enter the mark (0-100):</label>
				  	<input type="number" id="mark" name="mark" min="0" max=100><br>
					<input type="submit">
            </form>
        </div>
</body>
</html>


