<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function fun1(){
	
var x=document.getElementById("fn");
var y=document.getElementById("ln");

var ajax=new XMLHttpRequest();

ajax.onreadystatechange=function(){
	
	if(ajax.readyState==4){
	
		alert(ajax.responseText);
	}
	
}
ajax.open("get","display.jsp?fn="+x.value+"&ln="+y.value,true);
ajax.send();
}
</script>
</head>
<body>

<div style="width:200px;height:10px;float:left">
first name: </div>
<div>
<input type="text"  name="fn"id="fn"/><br>
</div>
<div style="width:200px;height:10px;float:left">
last name   : 
</div>
<div>
<input type="text"  name="ln" id="ln"/><br>
</div><br>
<input type="button" value="ok" onclick="fun1()"/>
</body>
</html>