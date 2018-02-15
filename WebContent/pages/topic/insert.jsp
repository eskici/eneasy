<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="\en-easy\js\\nicEdit.js"></script>
<script type="text/javascript">
	bkLib.onDomLoaded(function() { 
		new nicEditor({fullPanel : true}).panelInstance('content')
		
	});
</script>
<title>Insert title here</title>
</head>
<body>
 
 
 <form action="/en-easy/topic?action=add" method="post">
 	<label for="name">Konu başlığını girin</label><br>	
 	<input type="text" name="name" id="name" size="100"/>
 	<br><br>
 	<textarea id="content" name="content" rows="10" cols="80"></textarea>
 	<input type="submit" value="Gönder"> 
 </form>

</body>
</html>