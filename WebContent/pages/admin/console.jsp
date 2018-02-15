<%@ page language="java" contentType="text/html; charset=iso-8859-9"
    pageEncoding="iso-8859-9"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/en-easy/js/jquery-1.4.2.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
        //$("#editArea").hide();
        

    });
	
	function listWaitingTopics(){
        $.post("topic", {action:'viewWaitingTopics'}, function(data) {
        });
	}

  
</script>

<input type="button" value="Konular" onclick="document.location.href = '\\en-easy\\topic?action=viewWaitingTopics';"> || 
<input type="button" value="Cevaplar" onclick="document.location.href = '\\en-easy\\entry?action=viewWaitingEntries';"> || 
<input type="button" value="Kullanýcýlar" onclick="openLoginWindow('\pages\\entry\\insert.jsp',700,400)">

<c:if test="${waitingTopics!=null}">
 <table id="waitingTopics" width="90%" style="vertical-align: top;" align="left">
 	<c:forEach var="topic" items="${waitingTopics}"  varStatus="counter">
			<tr>
				<td>
					<h3></h3>
				</td>
				<td align="right">
					<sec:authorize ifAllGranted="ROLE_ADMIN">
						<a href="<c:out value="${root}/topic?action=approve&&objid=${topic.objid}"/>">
							<input id="btnApprove" type="button" value="Onayla">
						</a>	
						<a href="<c:out value="${root}/topic?action=cancel&&objid=${topic.objid}"/>">	
							<input id="btnCancel" type="button" value="Ýptal">
						</a>
						<input id="btnEdit" type="button" value="Düzenle" onclick="showEditArea()">
					</sec:authorize>
				</td>
			</tr> 	
		<tr>
			<td colspan="2">${counter.count} . ${topic.name}</td>
		</tr>
		
		<tr id="${topic.objid}">
			<td></td>
			<td align="right">${topic.createdBy.username},
				<fmt:formatDate value="${topic.creationDate}" pattern="dd.MM.yyyy HH:mm"/>
			 </td>
		</tr>
		
		<tr>
			<td colspan="2" width="30px"><hr/></td>
		</tr>	 	
		
 	</c:forEach>		
 </table> 
 </c:if>
 
 <c:if test="${waitingEntries!=null}">
 <table id="waitingTopics" width="90%" style="vertical-align: top;" align="left">
 	<c:forEach var="entry" items="${waitingEntries}"  varStatus="counter">
			<tr>
				<td>
					<h3>${entry.topic.name}</h3>
				</td>
				<td align="right">
					<sec:authorize ifAllGranted="ROLE_ADMIN">
						<a href="<c:out value="${root}/entry?action=approve&&objid=${entry.objid}"/>">
							<input id="btnApprove" type="button" value="Onayla">
						</a>
						<a href="<c:out value="${root}/entry?action=cancel&&objid=${entry.objid}"/>">	
							<input id="btnCancel" type="button" value="Ýptal">
						</a>
						<a href="<c:out value="${root}/entry?action=cancel&&objid=${topic.objid}"/>">	
							<input id="btnEdit" type="button" value="Düzenle" onclick="showEditArea()">
						</a>	
					</sec:authorize>
				</td>
			</tr> 	
		<tr>
			<td colspan="2">${counter.count} . ${entry.content}</td>
		</tr>
		
		<tr id="${entry.objid}">
			<td></td>
			<td align="right">${entry.createdBy.username},
				<fmt:formatDate value="${entry.creationDate}" pattern="dd.MM.yyyy HH:mm"/>
			 </td>
		</tr>
		
		<tr>
			<td colspan="2" width="30px"><hr/></td>
		</tr>	 	
		
 	</c:forEach>		
 </table> 
 </c:if>