<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.02.2017
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.pojo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/students/edit" method="post">
    <label for="id"></label>
    <input type="hidden" name="id" id="id" value="${stud.id}" placeholder="Input">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${stud.name}" placeholder="Input">
    <label for="birthday">Birthday</label>
    <input type="text" name="birthday" id="birthday" value="${stud.birthday}" placeholder="Input">
    <label for="sex">Sex</label>
    <input type="text" name="sex" id="sex" value="${stud.sex}" placeholder="Input">
    <input type="submit" value="Submit" formmethod="post">
</form>

</body>
</html>
