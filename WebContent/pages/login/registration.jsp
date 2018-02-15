<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Üye Ol</title>
</head>
<body>
<form action="/en-easy/user?action=add" method="post">
<table>
	<tr>
		<td>
			<label for="username">Kullanýcý Adý : </label>	
		</td>
		<td>
			<input type="text" name="username" id="username"/>
		</td>
	</tr>
	<tr>
		<td>
			<label for="password">Þifre : </label>
		</td>
		<td>
			<input type="password" name="password" id="password"/>
		</td>
	</tr>
	<tr>
		<td>
			<label for="passwordAgain">Þifre Tekrarý: </label>	
		</td>
		<td>
			<input type="password" name="passwordAgain" id="passwordAgain"/>
		</td>
	</tr>
	<tr>
		<td>
			<label for="text">E-posta: </label>	
		</td>
		<td>
			<input type='text' name='email'/>
		</td>
	</tr>
	<tr>
	    <td valign="middle">Güvenlik Resmi:<br/>
	    </td>
	    <td>
	    	<input type="text" name="jcaptcha"/>
	    </td>
	 </tr>
	 <tr>
	 	<td></td>
	 	<td>
	 		<img src="/en-easy/captcha" align="middle" alt="Enter the characters appearing in this image" border="1"/>
	 	</td>
	 </tr>		
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Üye ol"/></td> 
	</tr>			
</table>

	</form>
</body>
</html>

