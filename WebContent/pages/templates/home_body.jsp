<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
 
<div id="header">

	<table width="80%" style="vertical-align: top;" align="left">
		<tr>
			<td>
			</td>
			<td align="right">
					<input type="button" value="Klasik" onclick="openLoginWindow('\pages\\entry\\insert.jsp',700,400)">
					<input type="button" value="Forum" onclick="openLoginWindow('\pages\\entry\\insert.jsp',700,400)">					
			</td>
		</tr>			

		<tr>
			<td>
				<h3><c:out value="${topic.name}"></c:out></h3>
			</td>
			<td align="right">
				<sec:authorize ifAllGranted="ROLE_USER">
					<input type="button" value="Cevap Yaz" onclick="openLoginWindow('\pages\\entry\\insert.jsp',700,400)">
				</sec:authorize>
			</td>
		</tr>
		
		<c:forEach var="entry" items="${topic.entries}" varStatus="counter">
		  <c:if test="${entry.status=='ON'}">
			<tr>
				<td colspan="2">${counter.count} . ${entry.content}</td>
			</tr>
			<tr>
				<td></td>
				<td align="right">${entry.createdBy.username},
					<fmt:formatDate value="${entry.creationDate}" pattern="dd.MM.yyyy HH:mm"/>
				 </td>
			</tr>
		   </c:if>			
		</c:forEach>
		
		
				
	</table>
	
</div>