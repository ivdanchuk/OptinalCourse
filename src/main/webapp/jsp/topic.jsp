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
        <div class="container">
            <form action="/w2/controller" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty command}">                        	
                    <c:set var="command" value="create_topic"/>
                </c:if>

                <input type="hidden" id="command" name="command" value="${command}">
                <input type="hidden" id="id" name="id" value="${topic.id}">
                
                <h2>Topic</h2>
                <div class="form-group col-xs-4">

                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${topic.name}" required="true"/>                                   
 
                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
	</body>
</html>


