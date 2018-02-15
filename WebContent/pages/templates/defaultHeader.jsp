<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table width="100%">
		<tr>
			<td width="30%">
				<div id="userPanel">
					<sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
						<div  class="panel">					
							<form action="<c:out value='${root}/j_spring_security_check'/>" method="post">
							
								<table>
									<tr>
										<td><label for="j_username">Kullanıcı Adı</label></td>
										<td><input type="text" name="j_username" id="j_username"/></td>
									</tr>
									<tr>
										<td><label for="j_password">Şifre</label></td>
										<td><input type="password" name="j_password" id="j_password"/></td>
									</tr>
									<tr>
										<td></td>
										<td><input type='checkbox' name='_spring_security_remember_me'/> Beni Hatırla</td>
									<tr>
									<tr>
										<td colspan="2" align="center"><input type="submit" value="Giriş"/> || 
										<input type="button" value="Üye Ol" onclick="openLoginWindow('\pages\\login\\registration.jsp',450,600)">
										</td>
									</tr>					
								</table>
							</form>			
						</div>			
					</sec:authorize>
			
					<sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
				 	 <div class="panel">		 
						<table>
							<tr>
							  <td>
							  	<img alt="" src="images/user.jpg">
							  </td>
							  <td>Hoşgeldin <sec:authentication property="principal.username"/><br>
							  	<a href="topic?action=viewMyTopics">Yazılarım</a> 
							  </td>	
							</tr>
						</table>
						<input type="button" value="Yeni Başlık Aç" onclick="openLoginWindow('\pages\\topic\\insert.jsp',700,400)">
						<a href="<c:out value="${root}/logout.htm"/>"><input type="button" value="Çıkış"></a>
					  			 						
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<a href="<c:out value="${root}/topic?action=viewWaitingTopics"/>"><input type="button" value="Admin Ekranı"></a>
						</sec:authorize>
					</div>
				</sec:authorize>													
			</div>			
		</td>
		<td width="70%" align="left">
				<div id="searchPanel" style="width: 100%">
					<img alt="" src="images/logo.gif"><br>
					<form action="<c:out value="${root}/topic"/>" method="post">
						<input type="text" size="130" name="title"><input type="submit" value="Ara">
						<input type="hidden" name="action" value="search">
					</form>
				</div>
			</td>
		</tr>	
	</table>
	 
