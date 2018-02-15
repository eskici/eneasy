<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <script type="text/javascript" src="/en-easy/js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        $("#editArea").hide();
        $("#btnEditEntry").click(function(){
            $content = document.getElementById("content").value;
            $objid = document.getElementById("objid").value;
            $.post("entry", {content:$content,action:'edit',objid:$objid}, function(data) {
                alert(data);
                $("#content").html(data);
            });
        }); 
    });
    
    function showEditArea(){
    	$("#editArea").show();
    }
    
  
    </script>
<div id="header">
	
	<table width="80%" style="vertical-align: top;" align="left">
		<c:forEach var="myTopic" items="${myTopics}" varStatus="counter">	
			<tr>
				<td>
					<h3><c:out value="${myTopic.name}"></c:out></h3>
				</td>
				<td align="right">
					<sec:authorize ifAllGranted="ROLE_USER">
						<input type="button" value="Sil" onclick="openLoginWindow('\pages\\entry\\insert.jsp',700,400)">
						<input type="button" value="Düzenle" onclick="showEditArea()">
					</sec:authorize>
				</td>
			</tr>
	
			<c:forEach var="entry" items="${myTopic.entries}" varStatus="counter">
			  <c:if test="${user==entry.createdBy.username}">
				<tr>
					<td colspan="2">${counter.count} . ${entry.content}</td>
				</tr>
				<tr>
					<td></td>
					<td align="right">${entry.createdBy.username},
						<fmt:formatDate value="${entry.creationDate}" pattern="dd.MM.yyyy HH:mm"/>
					 </td>
				</tr>
				<tr id="editArea">
					<td colspan="2">
						<input id="objid" type="hidden" value="${entry.objid}">
					 	<textarea id="content" name="content" rows="10" cols="80">${entry.content}</textarea>
 						<input id="btnEditEntry" type="submit" value="Gönder"> 
					</td>
				</tr>					
			  </c:if>	
			</c:forEach>
		</c:forEach>		
	</table>
	
</div>