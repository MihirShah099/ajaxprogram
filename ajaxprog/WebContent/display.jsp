<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 

String s=request.getParameter("fn");
String s1=request.getParameter("ln");
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost/javac","root","root");
Statement s2=c.createStatement();
ResultSet r=s2.executeQuery("select * from list where fname='"+s+"' and lname='"+s1+"'");

if(r.next())
{
	out.println("hii");
	
}
else{
	out.println("bye");	
}
s2.close();
c.close();

		





	
%>