/**
 * 
 */

 function openLoginWindow(pageName,width,height){
	 var left = (screen.width/2)-(width/2);
	 var top = (screen.height/2)-(height/2);
	 window.open(pageName,'mywindow','width='+width+',height='+height+',top='+top+', left='+left+')');
 }
 
 function closePP(){
	 window.close();
	 
	 if (window.opener && !window.opener.closed) {
		 window.opener.location.reload();
	 }	 
 }
  