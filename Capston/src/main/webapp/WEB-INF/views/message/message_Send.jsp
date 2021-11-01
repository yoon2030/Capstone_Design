<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>쪽지 보내기</title>
	<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css?after" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
<style>
#message-btn{
position: position: relative; bottom: -198px;right: -81px;}
#email_content{width: 278px; height: 224px;}
#email_form{height: 580px;display: inline-block; width: 348px; border:1px solid;}
</style>
</head>

<body style = "text-align: center;">
<div id="message-container"> 
<form id = "email_form" role="form" method="post" autocomplete="off" enctype="multipart/form-data">
	
			<h2 id="message-title"class="mt-4 mb-3">쪽지 전송함</h2>
<div id = "email_logo"></div>

<div id="reciev-man" class="inputArea">
	<label for="tals_Term">받는 사람 : </label>	
	<input type="text" id = "recv_Id"name="recv_Id" value="${recv_Id}"/>
</div>
<div style ="text-align: left; position:relative; left:34px;"><span id = "send-content">내용</span></div>
<div id= "message-text" class="inputArea">
	<label for="content"> </label>
	<textarea rows="5" cols="50" id="email_content" name="content"></textarea>
</div>

<div id="message-btn" class="inputArea">
	<button id="register_Btn"  onclick ="rowClick()">보내기</button>
	<button id="close_btn"  onclick ="opener.parent.location.reload();window.close();">닫기</button>
	<script language="JavaScript">
	function rowClick(){
		var frmPop = document.frmPopup;
		var url = '/message/message_Send';
		frmPop.action = url;
		frmPop.submit();
	}
	</script>
</div>
</form>
</div>

</body>


</html>