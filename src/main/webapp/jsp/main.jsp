<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>
<div class="w3-container">
  <h2>Optional course</h2>

  <div class="w3-bar w3-light-grey w3-border">
    <a href="/optinal-course/controller?command=read_users" class="w3-bar-item w3-button w3-mobile">Users</a>
	<a href="/optinal-course/controller?command=read_user_courses" class="w3-bar-item w3-button w3-mobile">My learning</a>
	<a href="/optinal-course/controller?command=show_tutor_reg_form" class="w3-bar-item w3-button w3-mobile">My tutoring</a>
    <a href="/optinal-course/controller?command=read_topics" class="w3-bar-item w3-button w3-mobile">University topics</a>
    <a href="/optinal-course/controller?command=read_courses" class="w3-bar-item w3-button w3-mobile">University courses</a>
    <a href="/optinal-course/controller?command=read_user" class="w3-bar-item w3-button w3-mobile">My account</a>
    <a href="/optinal-course/controller?command=logout" class="w3-bar-item w3-button w3-mobile">Logout</a>

    <input type="text" class="w3-bar-item w3-input w3-white w3-mobile" placeholder="Search..">
    <button class="w3-bar-item w3-button w3-green w3-mobile">Go</button>
  </div>

You are logged as ${currentUser.email}, your role is ${currentRole.name}
<!--  
	<hr/>
	<a href="/optinal-course/controller?command=read_users">Users</a>
	<a href="/optinal-course/controller?command=read_topics">Topics</a>
	<a href="/optinal-course/controller?command=read_courses">Courses</a>
	<a href="/optinal-course/controller?command=logout">Logout</a>
-->
</body>
</html>