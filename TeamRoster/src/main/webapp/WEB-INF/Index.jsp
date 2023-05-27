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
<h1>Prototype Roster</h1>
<a href="Teams">New Team</a>
<table>
  <tr>
    <th>Team</th>
    <th>Players</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${listTeams.getTeamsList()}" var="current">
  <tr>
    <td>${current.getName()}</td>
    <td>${current.getPlayersList().size()}</td>
    <td><a href="Teams?id=${current.getId()}">Details</a> | <a href="DeleteTeam?id=${current.getId()}">Delete</a></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>