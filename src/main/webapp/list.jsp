<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List</h1>
<table border="1">
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td><c:out value="${student.birthday}"></c:out></td>
            <td><c:out value="${student.sex}"></c:out></td>
            <td><a href="/students/edit?id=${student.id}"><c:out value="edit"></c:out></a></td>
            <td><a href="/students/delete?id=${student.id}"><c:out value="delete"></c:out></a></td>
            <td><a href="/students/add"><c:out value="add"></c:out></a></td>
        </tr>
        <%--<c:out value="${userItem.name}"></c:out>--%>
        <%--<c:out value="${userItem.type}"></c:out>--%>
    </c:forEach>
</table>
</body>
</html>