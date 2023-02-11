<%@ taglib prefix="h" uri="http://java.sun.com/jstl/core_rt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/functions" %>
 <h:set var="dt" value="${sessionScope.list}"></h:set>
 <h:set var="len" value="${c:length(dt)}" ></h:set>
[
	<h:forEach items="${dt}" var="i" varStatus="j">
   
	{
		"sid" : ${i.id},
		"sname" : "${i.stat}"
	}
	
	<h:if test="${j.count ne len}">
	,
	</h:if>
	
</h:forEach>
]