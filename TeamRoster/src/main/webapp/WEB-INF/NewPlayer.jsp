<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Add a player to team ${nameTeam}</p>
<br>
<form action="Players" method="post">
  <label for="first_name">First Name:</label><br>
  <input type="text" id="first_name" name="first_name"><br><br>
   <label for="last_name">Last Name:</label><br>
  <input type="text" id="last_name" name="last_name"><br><br>
   <label for="age">Age:</label><br>
  <input type="number" id="age" name="age"><br><br>
  <input type="submit" value="Add">
</form>
</body>
</html>