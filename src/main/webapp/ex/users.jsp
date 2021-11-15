<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Users page</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Users list</h2>

<p>Use email link to open user's card</p>

<table style="width:100%">
  <tr>
    <th>Email</th>
    <th>First name</th> 
    <th>Last name</th>
  </tr>
<c:forEach var="user" items="${users}" >
  <tr>
	<td><a href="controller?command=read_user&id=${user.id}">${user.email}</a></td>
    <td>${user.f_name}</td>
    <td>${user.l_name}</td>

  </tr>
</c:forEach>
  <tr>
</table>
<br>
<hr>
<a href="controller?command=new_user_form">New user </a>
<!--    -->
</body>
</html>