<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${nameTeam}</h1>
<a href="Players">New ${nameTeam}</a>
<table>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
    <th>Action</th>
  </tr>

  <c:forEach items="${listPlayer}" var="current">
  <tr>
    <td>${current.getFirst_name()}</td>
    <td>${current.getLast_name()}</td>
    <td>${current.getAge()}</td>
   <td><a href="Players">Details</a> | <a href="DeletePlayer?id=${current.getId()}">Delete</a></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>