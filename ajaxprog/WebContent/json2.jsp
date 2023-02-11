<%@ taglib prefix="h" uri="http://java.sun.com/jstl/core_rt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/functions" %>
 <h:set var="dt" value="${sessionScope.ls}"></h:set>
 <h:set var="len" value="${c:length(dt)}" ></h:set>
[
	<h:forEach items="${dt}" var="i" varStatus="j">
   
	{
		"cid" : ${i.id},
		"cname" : "${i.cname}"
	}
	
	<h:if test="${j.count ne len}">
	,
	</h:if>
	
</h:forEach>
]