<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="h" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">
	function fun1() {

		var x = document.getElementById("cn");
		var y = document.getElementById("sate");

		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (ajax.readyState == 4) {

				y.innerHTML = '';
				var jsn = JSON.parse(ajax.responseText);

				for (var i = 0; i < jsn.length; i++) {

					var sid = jsn[i].sid;

					var sname = jsn[i].sname;

					var opn = document.createElement("option");

					opn.text = sname;

					opn.value = sid;

					y.options.add(opn);
				}

			}

		}

		ajax.open("get", "statecon1?flag=statesearch&countryId=" + x.value,
				true);
		ajax.send();
	}

	function fun2() {
		var x = document.getElementById("sate");
		var y = document.getElementById("cname");

		var ajax = new XMLHttpRequest();

		ajax.onreadystatechange = function() {

			if (ajax.readyState == 4) {
				
				y.innerHTML = '';
				
				var jsn = JSON.parse(ajax.responseText);
				
				for (var i = 0; i < jsn.length; i++) {

					
					
					var cid = jsn[i].cid;

					var cname = jsn[i].cname;

					var opn = document.createElement("option");

					opn.text = cname;

					opn.value = cid;

					y.options.add(opn);
				}

			}

		}

		ajax.open("get", "citycon?flag=citysearch&stateId=" + x.value, true);
		ajax.send();
	}
</script>
</head>
<body>
	country:
	<select onchange="fun1()" id="cn">
		<option>Select Country</option>
		<h:forEach items="${sessionScope.ls}" var="i">
			<option value="${i.id}">${i.cn}</option>
		</h:forEach>
	</select>
	<br> State:
	<select onchange="fun2()" name="stat" id="sate">
		<option>Choose State</option>
	</select>


	<br> city:
	<select name="cname" id="cname">
		<option>Choose city</option>
	</select>
</body>
</html>