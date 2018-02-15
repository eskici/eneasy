<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:out value='${root}/j_spring_security_check'/>" method="post">

	<table>
		<tr>
			<td><label for="j_username">Kullanýcý Adý</label></td>
			<td><input type="text" name="j_username" id="j_username"/></td>
		</tr>
		<tr>
			<td><label for="j_password">Þifre</label></td>
			<td><input type="password" name="j_password" id="j_password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type='checkbox' name='_spring_security_remember_me'/> Beni Hatýrla</td>
		<tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Giriþ"/></td>
		</tr>					
	</table>
</form>
</body>
</html>

