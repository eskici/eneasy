<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
   <div class="panel">		
	<ul>
	   <c:choose>
		   <c:when test="${searchTopics!=null}">
			   <c:forEach var="topic" items="${searchTopics}">
			 		 <li><a href="/en-easy/topic?action=read&objid=${topic.objid}">${topic.name}</a></li>
		 		</c:forEach>	
		   </c:when>
		   <c:otherwise>	
			   <c:forEach var="topic" items="${topics}">
			 		 <li><a href="/en-easy/topic?action=read&objid=${topic.objid}">${topic.name}</a></li>
		 		</c:forEach>
	 		</c:otherwise>
 		</c:choose>		
	</ul>
	</div>
</div>