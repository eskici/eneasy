<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="/en-easy/js/en-easy.js"></script>
    <link rel="stylesheet" type="text/css" href="/en-easy/css/en-easy.css"/>
</head>

<body style="width: 100%; height: 100%">
<c:set var="root" value="${pageContext.request.contextPath}" scope="session"/>
<c:set var="user" value="${pageContext.request.remoteUser}" scope="session"/>
	<table border="0" cellspacing="0" cellpadding="0"
		style="width: 100%; height: 100%">
		<tr>
			<td colspan="2" height="120px"><tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td width="300" valign="top"><tiles:insertAttribute name="menu" />
			</td>
			<td width="700" valign="top"><tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>
</body>
</html>