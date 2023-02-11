<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function fun1(){
	
var x=document.getElementById("con");
var y=document.getElementById("sat");

var ajax=new XMLHttpRequest();

ajax.onreadystatechange=function(){
	
	if(ajax.readyState==4)
	{
	
		y.innerHTML = '';
		
		var jsn=JSON.parse(ajax.responseText);
		for(var i=0;i<jsn.length;i++)
		{
			var sid=jsn[i].sid;
			var sname=jsn[i].sname;
			var opn=document.createElement("option");
			opn.text=sname;
			opn.value=sid;
		
			y.options.add(opn);
		}
		
	}
	
}
ajax.open("get","json.jsp?country="+x.value,true);
ajax.send();
}
</script>
</head>
<body>
country: <select id="con" onchange="fun1()">
<option>India</option>
<option>USA</option>
<option>JAPAN</option>
</select>
<br/>
State:<select id="sat">
<option></option>
</select>



</body>
</html>