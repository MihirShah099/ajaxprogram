<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="h" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1px solid black>
<tr>
<td>id</td><td>country</td><td>state</td><td>action</td>
</tr>
<h:forEach items="${sessionScope.ls}" var="x">
<tr>
<td>${x.id}</td>
<br>
<td>${x.cid.cn}</td>
<br>
<td>${x.stat}</td>
<td>
<a href="deletestatecon?id=${x.id}">delete</a>
<a href="editstate?id=${x.id}">edit</a>

</td>
 </h:forEach>
 </table>
 <br>
</body>
</html>