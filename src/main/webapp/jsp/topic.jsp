<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
	<jsp:include page="/jsp/templates/header.jsp"></jsp:include>
<body>
        <div class="container">
            <br>
            <h2>Topic</h2>
			<br>
            <form action="${context}/controller" method="post">
 
                <c:if test ="${empty command}">                        	
                    <c:set var="command" value="create_topic"/>
                </c:if>
 
                <input type="hidden" id="command" name="command" value="${command}">
                <input type="hidden" id="id" name="id" value="${topic.id}">
                
                <div class="form-group col-xs-4">
                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" pattern="[a-zA-Za-zА-я0-9]{4,64}" value="${topic.name}" required="true"/>                                   
                     <br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
	</body>

	<jsp:include page="/jsp/templates/footer.jsp"></jsp:include>

</html>


