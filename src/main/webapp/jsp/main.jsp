<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome</title></head>
<body>
<h3>Welcome</h3>
<hr/>
${currentUser.f_name}, hello!
<hr/>
<a href="/w2/controller?command=read_users">Users</a>
<a href="/w2/controller?command=read_topics">Topics</a>
<a href="/w2/controller?command=read_courses">Courses</a>
<a href="/w2/controller?command=logout">Logout</a>
</body></html>