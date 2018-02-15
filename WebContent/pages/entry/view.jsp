<%@ page language="java" contentType="text/html; charset=iso-8859-9"
    pageEncoding="iso-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 <a href="/en-easy/topic?action=view">View Topic </a>
 
 
 <table cellspacing="5" cellpadding="5" border="2" bordercolor="#000000">
 	<tbody>
 		<th>Konu Adi</th>
 		<th>Durumu</th>
 		<th></th>
 		<th></th>
 	</tbody>
 	<c:forEach var="topic" items="${topics}">
	 	<tr>
	 		<td>${topic.name}</td>
	 		<td>${topic.status}</td>
	 		<td>
	 			<form action="/en-easy/topic">
	 				<input type="hidden" name="objid" value="${topic.objid}"/>
	 				<input type="hidden" name="action" value="approve"/>
	 				<input type="submit" value="Onayla"/>
	 			</form>
	 		</td>
	 		<td>
	 			<form action="/en-easy/topic?action=cancel">
	 				<input type="hidden" name="objid" value="${topic.objid}"/>
	 				<input type="submit" value="Iptal"/>
	 			</form>	 		
	 		</td>
	 	</tr>		
 	</c:forEach>		
 </table>
 

</body>
</html>