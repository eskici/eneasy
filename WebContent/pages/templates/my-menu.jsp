<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
   <div  style="margin:5px; padding:10px; -webkit-border-radius: 15px; -moz-border-radius: 15px; border-radius: 15px; border: 3px solid #C2C2C2; background: rgba(255, 255, 255, 0.7); -webkit-box-shadow: #B3B3B3 5px 11px 11px; -moz-box-shadow: #B3B3B3 11px 11px 11px; box-shadow: #B3B3B3 11px 11px 11px;">		
	<ul>
	   <c:forEach var="topic" items="${myTopics}">
	 		 <li><a href="/en-easy/topic?action=read&objid=${topic.objid}">${topic.name}</a></li>
 		</c:forEach>		
	</ul>
	</div>
</div>