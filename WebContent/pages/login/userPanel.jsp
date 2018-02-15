<%@ page language="java" contentType="text/html; charset=iso-8859-9"
    pageEncoding="iso-8859-9"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sen de bir þeyler yaz</title>
</head>
<body>

	<table>
		<tr>
		  <td>
		  	<img alt="" src="">
		  </td>
		  <td>Hoþgeldin <sec:authentication property="principal.username"/>
		  </td>	
		</tr>
	</table> 

</body>
</html>